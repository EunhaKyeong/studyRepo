# 📔JSTL
1. JSP Standard Tag Library.
2. JSP 페이지에서 사용가능한 커스텀태그와 함수 제공.
3. JSTL을 사용하려면?  
    
    - 프로젝트에 jstl 라이브러리 추가.(pom.xml에 추가)  
    - JSP 페이지 상단에 선언 필요.(필요한 기능에 따라 선언할 태그 라이브러리의 URI가 다름)
4. JSTL 태그의 종류
    
    - Core : 변수지원, 제어문 페이지 관련 처리
        ```
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        ```
    - Formatting : 포맷처리, 국제화지원
        ```
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        ```
    - DataBase : DB관련 CRUD 처리
        ```
        <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
        ```
    - XML : XML 관련 처리
        ```
        <%@ taglib uri="http://java.sun.com/jstl/xml" prefix="xml" %>
        ```
    - Function : Collection 처리, String 처리
        ```
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        ```

<br><br>
[출처1](https://m.blog.naver.com/PostView.nhn?blogId=imf4&logNo=220654812087&proxyReferer=https:%2F%2Fwww.google.com%2F)  
[출처2](https://blog.nerdfactory.ai/2019/05/05/spring-mvc-jstl.html)
        