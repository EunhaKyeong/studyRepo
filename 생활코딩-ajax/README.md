# Ajax(Asynchronous Javascript And Xml)    
- JavaScript 라이브러리 중 하나.  
- 전체 페이지를 새로고침하지 않아도 필요한 부분만 데이터를 로드해 페이지의 일부만을 변경할 수 있는 기술.  
- JavaScript를 사용한 비동기 통신, 클라이언트와 서버간에 XML 데이터를 주고받는 기술

## fetch API
- XMLHttpRequest와 비슷한 기술이지만 훨씬 최신의 기술.
```
<!DOCTYPE html>
<html>
    <body>
        <article>

        </article>
        <input type='button' value='fetch' onclick="
            function callbackme() {
                console.log("response end");
            }
            fetch('html').then(callbackme);
            console.log(1);
            console.log(2);
        ">
    </body>
</html>
```  
[출력 결과]  
```
1
2
response end
```  
- fetch('html') : html 파일을 서버에 보내주라.  
- then(callbackme) : html 파일을 서버에 보낸 후에 callbackme 함수를 호출해라.  
- **응답하기 전까지 아무런 실행 없이 기다리는게 아니라 그 다음 코드를 실행하여 1, 2를 console에 출력 -> Asychronous(비동기)**  
```
fetch('html').then(function(response) {
    
});
```  
- fetch API에서 then()에서 익명 함수를 호출하는 경우 호출의 인자로 **response 객체(이름은 변경 가능)**를 받도록 함.  
- response 객체는 요청 응답에 대한 여러 정보를 가지고 있음.  

### fetch API의 문제점  
- 뒤로가기를 했을 때, url과 hash값은 바뀌지만 페이지 로딩이 안됨. -> pjax를 이용(차후 필요할 때 공부하기)  
<br><br>  
### Can I Use  
<https://caniuse.com/>  
웹서비스를 만들면서 어떤 기술을 적용하고자 할 때, 이 기술이 어떤 웹브라우에서 지원되는지 알고 싶다면 Can I Use 웹페이지를 이용.  
<br><br>
** 위 자료를 생활코딩-ajax 내용을 보며 공부한 내용입니다.**