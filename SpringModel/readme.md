## [Setting]
### Spring Tools for Eclipse
> Windows > Preferences
<br>&emsp;> Java
<br>&emsp;&emsp;> Build Path
<br>&emsp;&emsp;&emsp;> Classpath Variable
<br>&emsp;&emsp;&emsp;&emsp;> `ECLIPSE_HOME, JRE_LIB` path check
<br>&emsp;&emsp;> Installed JREs
<br>&emsp;&emsp;&emsp;> check `jdk-21` to default setting

<br><br>
--------------------

## [Fix]
### case 1. `pom.xml` 파일 생성 시, `<projcet>` 태그에서 해당 에러가 발생한 경우
`cvc-elt.1.a: Cannot find the declaration of element 'project'. [cvc-elt.1.a]`
- **발생 원인** <br>
실제 리다이렉션 되는 URL 경로 차이 <br>
자동 작성되는 `pom.xml` 파일에서 http 주소로 접속했을 때 https 주소로 리다이렉션 되는 것을 확인 <br>
- **해결 방법 : 링크 주소값 수정** <br>
http 주소로 적혀있을 시, https 주소로 수정(역방향 적용 O) <br>
기타 파일 모두 해당 에러 발생 시, 동일한 방법으로 해결이 가능할 것으로 예상 <br>
 <br>

### case 2. `application.xml` 파일 생성 시, URL에서 해당 에러가 발생한 경우
`Downloading external resources is disabled. [DownloadResourceDisabled]`
- **발생 원인** <br>
외부 리소스 다운로드가 막힌 URL 사용 시도 <br>
해당 URL에서 다운로드가 일어나는 것이 아니라 단순 리소스 URL 일 경우는 실행 시에도 문제되지 않음(실제 케이스) <br>
- **해결 방법 : Preferences 수정** <br>
Windows > Preferences > XML(Wild Web Developer) > `Download external resources like referenced DTD, XSD` 체크

<br><br>
--------------------

## [Link]
- Spring(Main) :: https://docs.spring.io/spring-framework/reference/index.html
- Spring(javadoc-api) :: https://docs.spring.io/spring-framework/docs/current/javadoc-api/
- Maven Repository :: https://mvnrepository.com/
- Maven Central Repository :: https://central.sonatype.com/