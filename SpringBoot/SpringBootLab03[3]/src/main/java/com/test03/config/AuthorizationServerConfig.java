package com.test03.config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Spring Security 활성화
public class AuthorizationServerConfig {

  // 1. 보안 필터 체인 - DI로 jwtDecoder를 주입
  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http, JwtDecoder jwtDecoder)
      throws Exception {
    http.with(new OAuth2AuthorizationServerConfigurer(), (authorizationServerConfigurer) -> {
          // 필요한 경우 authorizationServerConfigurer에서 추가 설정 가능
          // OAuth2 인증 서버의 설정을 확장하거나 커스터마이징할 수 있는 객체
        })
        .securityMatcher("/oauth2/**")
        .authorizeHttpRequests(
            auth -> auth
                .requestMatchers("/oauth2/token").permitAll()
                .anyRequest().authenticated()
        )
        .exceptionHandling(
            exception -> exception.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")))
        .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(jwt -> jwt.decoder(jwtDecoder)));
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }

  // 2. RSA KeyPair를 생성하는 Bean
  @Bean
  public KeyPair keyPair() {
    try {
      KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
      generator.initialize(2048);
      return generator.generateKeyPair();
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException("RSA 알고리즘을 사용할 수 없습니다.", e);
    }
  }

  // 3. JwtDecoder Bean - KeyPair의 PublicKey를 사용
  @Bean
  public JwtDecoder jwtDecoder(KeyPair keyPair) {
    return NimbusJwtDecoder.withPublicKey((RSAPublicKey) keyPair.getPublic()).build();
  }

  // 4. 클라이언트 등록 정보 (메모리 기반)
  @Bean
  public InMemoryRegisteredClientRepository registeredClientRepository(PasswordEncoder passwordEncoder) {
    RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
        .clientId("client")
        .clientSecret(passwordEncoder.encode("secret"))
        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
        .scope("read")
        .build();

    return new InMemoryRegisteredClientRepository(registeredClient);
  }

  //5.인증 서버 설정 (토큰 엔드포인트 지정)
  @Bean
  public AuthorizationServerSettings authorizationServerSettings() {
    return AuthorizationServerSettings.builder()
        .tokenEndpoint("/oauth2/token")
        .build();
  }
}