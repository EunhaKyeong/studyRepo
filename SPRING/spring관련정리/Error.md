# Error1.
## Ajax 작동 후 자바스크립트 이벤트가 안먹는 오류
```
$("#nextPage").click(function() {
    ...
});
```
이런식으로 코드를 작성하면 현재 작성된 html 코드에서만 이벤트가 먹힘.  
하지만 우리는 페이지가 변경된 이후에도 클릭 이벤트가 발생해야 하므로 **.on()**을 사용함.  
```
$(document).on('click', '#nextPage', function() {
    ...
});
```