package com.sec04;

import com.sec01.MyAddress;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

  @Bean
  public MyAddress m1() {
    return new MyAddress("최길동", "부산", "051-000-0000");
  }

  @Bean
  public MyAddress m2() {
    return new MyAddress("홍길동", "서울", "051-000-0000");
  }

  @Bean
  public MyCollection myCollection() {
    MyCollection m = new MyCollection();
    m.setItems(Arrays.asList("Item A", "Item B", "Item C"));
    m.setMyarray(new String[]{"Item A", "Item B", "Item C"});
    m.setMyset(Set.of("Item A", "Item B", "Item C"));
    m.setMymap(Map.of("key 1", "Item A", "key 2", "Item B", "key 3", "Item C"));
    m.setMyaddr(Map.of("addr1", m1(), "addr2", m2()));
    return m;
  }
}
