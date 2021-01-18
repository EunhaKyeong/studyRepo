# Mybatis를 활용해 MySQL DB 연동하기
## 1. pom.xml 에 라이브러리 추가
    1) spring-jdbc : 스프링에서 데이터베이스 처리
    2) spring-tx : 스프링에서 트랜잭션 처리
    3) mybatis : mybatis 라이브러리
    4) mybatis-spring : spring에서 mybatis를 연동하는 라이브러리
    5) mysql-connector-java : spring에서 mysql 연동하는 라이브러리
    6) spring-test : spring test 라이브러리

## 2. properties 파일 추가
    - mysql 데이터베이스 정보를 저장하는 properties 파일 추가.
    - src/main/webapp/config/ 경로 안에 저장
    ```
    ## mysql.properties
    mysql.driverClassName = com.mysql.cj.jdbc.Driver
    mysql.url = jdbc:mysql://host주소/DB명?allowPublicKeyRetrieval=true&serverTimezone=UTC
    mysql.username = DB 유저명
    mysql.password = DB 패스워드
    ```
    - .gitignore에 properties 파일 경로 추가해주기

## 3. root-context.xml에 dataSource, sqlSessionFactory 빈 등록&mapper가 저장돼 있는 패키지를 알려줌.
    - dataSource : 연결할 DB에 대한 정보를 저장하는 역할.
    - sqlSessionFactory : DB를 Connection 하고 SQL 쿼리문을 전달하고, 결과를 리턴받는 sqlSession을 만드는 역할.
    ```
    ## root-context.xml
    //mysql.properties가 있는 경로 알려주기
    <context:property-placeholder location="/config/mysql.properties" />

    //dataSource 빈 등록
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	    <property name="driverClassName" value="${mysql.driverClassName}"/>
		<property name="url" value="${mysql.url}" />
		<property name="username" value="${mysql.username}"/>
		<property name="password" value="${mysql.password}"/>
	</bean>

    //sqlSessionFactory 빈 등록
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    //base-package에 저장돼 있는 패키지 안의 xml 파일과 클래스 파일을 mapper로 인식
    <mybatis-spring:scan base-package="com.oauth2.study.mapper"></mybatis-spring:scan>
    ```

## 4. 프로젝트 구조
```
src/main/java  
    com.oauth2.study  
        controller  
            HomeController.java  
        domain  
            UserVO.java  
        service
            UserService.java
            UserServiceImpl.java
        mapper
            UserMapper.java

src/main/resources
    com.oauth2.study
        mapper
            UserMapper.xml
```
    1) domain 패키지 : DB에 존재하는 테이블의 데이터를 담는 곳.
    2) service 패키지
        - 컨트롤러에서 mapper를 직접 불러오지 않고 service를 통해 mapper를 호출함.  
        - interface와 interface의 로직을 구현하는 클래스로 나눠서 생성함.
    3) mapper.java
        - mapper.xml과 연결되는 패키지  
        - 인터페이스로 구현  
        - mapper의 메소드 이름은 mapper.xml의 id와 같아야 함.  
    4) mapper.xml
        - sql 쿼리문을 작성하는 곳.
        - connection한 db와 직접적으로 연결되는 곳.  
        - namespace에는 mapper.java의 패키지명.mapper.java를 넣어줌.

## 5. UserMapper.xml
```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.oauth2.study.mapper.UserMapper">
    <select id="selectAllUser" resultType="com.oauth2.study.domain.UserVO">
        select * from user;
    </select>
</mapper>
```

## 6. UserMapper.java
```java
public interface UserMapper {
	public List<UserVO> selectAlluser();    //메서드명은 mapper의 id와 동일하게
}
```

## 7. UserVO.java
```java
@Data
public class UserVO {
	private int userCode;
	private String social;
	private String userId;
	private String userEmail;
	private String userAddress;
	private String userPhone;
	private String userName;
}
```

## 8. UserService.java
```java
public interface UserService {
	public List<UserVO> getAllUser();
}
```

## 9. UserServiceImpl.java
```java
@Service
public class UserServiceImpl implements UserService {
	@Inject
	UserMapper userMapper;
	
	@Override
	public List<UserVO> getAllUser() {
		List<UserVO> userVOList = userMapper.selectAlluser();
		
		return userVOList;
	}
}
```

## 10. HomeController.java
```java
@Controller
public class HomeController {
    @Inject
    UserServiceImpl userService;

    public String index() {
        List<UserVO> userVOList = userService.getAllUser();

        System.out.println(userVOList.get(0).getUserNAme());

        return "index";
    }
}
```