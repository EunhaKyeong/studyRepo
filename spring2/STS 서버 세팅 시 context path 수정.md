STS로 서버 세팅하면 url을 루트(/)로 설정해도 주소가 localhost/spring 이런식으로 뜸.  

**해결 방법**  
  1. Servers/server.xml 이동
  2. 
      **path 값을 "/"로 변경**  
    ```
   <Context docBase="ShoppingMall" path="/" reloadable="true" source="org.eclipse.jst.jee.server:ShoppingMall"/></Host>
    ```
