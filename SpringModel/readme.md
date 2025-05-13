## [Setting]
Spring Tools for Eclipse <br>
Windows > Preferences
<br>&emsp;> Java
<br>&emsp;&emsp;> Build Path
<br>&emsp;&emsp;&emsp;> Classpath Variable
<br>&emsp;&emsp;&emsp;&emsp;> `ECLIPSE_HOME, JRE_LIB` path check
<br>&emsp;&emsp;> Installed JREs
<br>&emsp;&emsp;&emsp;> check `jdk-21` to default setting
<br><br>
============= <br>

## [Fix]
### case 1. `pom.xml` 파일 생성 시, `<projcet>` 태그에서 해당 에러가 발생한 경우
`cvc-elt.1.a: Cannot find the declaration of element 'project'. [cvc-elt.1.a]`
- **링크 주소값 수정** <br>
http 주소로 적혀있을 시, https 주소로 수정 <br>
실제 http 주소로 접속했을 때 https 주소로 리다이렉션 확인 <br>

### case 2. `application.xml` 파일 생성 시, url에서 해당 에러가 발생한 경우
`Downloading external resources is disabled. [DownloadResourceDisabled]`
- **Preferences 수정** <br>
Windows > Preferences > XML(Wild Web Developer) > `Download external resources like referenced DTD, XSD` 체크

============= <br>

## [Link] <br>
- Spring(Main) :: https://docs.spring.io/spring-framework/reference/index.html
- Maven Repository :: https://mvnrepository.com/
- Maven Central Repository :: https://central.sonatype.com/