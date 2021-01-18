# spring으로 쇼핑몰 만들어보는 튜토리얼

## Spring에서 javascript 파일 사용하는 방법.
1. src/main/webapp/resources/ 경로에 js 폴더 생성.
2. servlet-context.xml 파일에 아래 코드 추가.
```
<resources mapping="/resources/**" location="/resources/" />
```
3. javascript 파일을 추가하고자 하는 jsp 파일에 아래 코드 추가.
```
<script src="${pageContext.request.contextPath}/resources/js/js파일이름.js"></script>
```

[부트스트랩 출처](https://github.com/startbootstrap/startbootstrap-shop-homepage)