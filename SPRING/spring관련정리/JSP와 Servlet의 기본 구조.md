# JSP와 Servlet의 기본 구조  
## 웹 어플리케이션의 일반적인 구조
1. 브라우저는 url(or ip)을 통해 원하는 요청(=request)을 웹서버에 전송한다. (=사용자는 url 주소를 입력하여 네이버와 같은 웹페이지에 접속하려 한다.)
2. 웹서버는 받은 요청을 직접 처리하거나 WAS(웹 어플리케이션)에 전송한다.
3. WAS는 받은 요청에 대한 연산을 처리한다.(데이터를 활용해야 한다면 DBMS를 이용.)
4. WAS는 요청을 처리하여 결과(response)를 웹서버에 전송한다.
5. 웹서버는 response를 브라우저에 전송한다.
6. 브라우저는 response를 해석하여 화면을 구성한다.  
<br>

## 웹서버 단일 구성
- 웹서버에 대해 단순하게 설명하면 브라우저에서 받은 요청에 대한 페이지를 브라우저에게 전송해줌.  
- 개발자는 자신이 만든 페이지를 웹서버에 미리 전송해두기 때문에 위와 같은 과정이 가능함.
- 페이지의 종류로는 html, css, javascript 등이 있음.  
ex. 사용자가 네이버에서 로그인 버튼을 클릭하면 웹서버로 로그인 페이지에 대한 html, css, javascript 등을 전송해달라는 request가 전송되고, 웹서버는 해당 페이지를 찾아 브라우저에 전송해줌.  
<br>
<img src="https://user-images.githubusercontent.com/66666533/101588269-58a1c900-3a29-11eb-89bb-b6e24df0cec4.PNG">
<br>

## WAS 구성
- 단순 웹서버는 브라우저에서 요청이 오면 페이지를 브라우저로 넘겨주는 정적인 방법이었음.  
- 하지만 페이지에서 처리해야할 로직이 복잡해지면서 웹서버에서만 이를 처리하기가 힘들어짐.  
- 복잡한 로직을 처리하기 위해 WAS라는 웹 어플리케이션 서버가 등장함.
- WAS의 등장으로 웹서버의 업무를 분할하게 돼 효율적으로나 보안적으로나 더 훌륭한 웹을 구현할 수 있게 됨.  
- 이미지파일과 같이 단순한 정적파일만을 요청할 때는 웹서버에서 처리하여 브라우저에게 넘겨주지만 복잡한 연산이 필요할 경우 웹서버는 WAS에게 연산을 요청하고, 연산 결과를 WEB서버에서 브라우저로 넘겨주게 됨.  
<br>
<img src="https://user-images.githubusercontent.com/66666533/101589101-1da09500-3a2b-11eb-97a7-51904d9640e6.PNG">  
<br>

## WEB-WAS-DBMS 구성
- WAS에서 연산처리를 하면서 데이터를 활용해야 할 경우가 많이 발생하게 됨.
- 데이터 활용을 효율적으로 하기 위해 DBMS가 등장.  
<br>
<img src="https://user-images.githubusercontent.com/66666533/101589886-ad930e80-3a2c-11eb-97a3-b74f45181d29.png">
<br>

## WAS와 컨테이너
- WAS는 JSP와 Servlet을 구동하기 위한 컨테이너 역할을 함.  
- 컨테이너는 JSP를 Servlet 형태로 변환시켜 주고, 서블릿이 웹 환경에서 구동될 수 있도록 도와주는 프로그램.
- WAS에서는 하나의 컨테이너만 사용해도 되고, 기능에 따라 여러개의 컨테이너를 생성하여 사용해도 됨.  
<br>
<img src="https://user-images.githubusercontent.com/66666533/101591656-5abb5600-3a30-11eb-89cb-16b0c54a4414.png">  
<br>

## JSP와 Servlet  
- JSP : html 코드 안에 java 코드를 추가한 파일.(.jsp)
- Servlet : Java 코드 안에 html 코드를 추가한 파일.(.java)
- JSP 파일의 경우 WAS 컨테이너에서 Servlet 파일로 변환시켜줘야 함.
- **.jsp -> .java(=servlet) -> .class -> .html**  
<br><br>

[참조](https://codevang.tistory.com/191?category=844272)