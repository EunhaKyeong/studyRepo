# Ajax(Asynchronous Javascript And Xml)  
## fetch API
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