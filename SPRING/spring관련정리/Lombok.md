# Lombok 라이브러리
- 자바에서 생성자, getter(), setter() 등을 자동으로 만들어주는 라이브러리.
- lombok 어노테이션을 사용하면 됨.
<br><br>

## 생성자
- 우리는 클래스를 만들면 생성자가 필요하다.
```
public class User {
    private int userId;
    private String userName;
    private String userEmail;

    public User() {

    }

    public User(int userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
```
- 하지만 필드가 많아질수록 생성자를 만드는 일은 굉장히 귀찮아진다. 이때 우리는 lombok 라이브러리를 활용하여 생성자를 만드는 귀찮은 과정을 생략할 수 있다. 
### @AllArgsConstructor 
- 모든 필드를 가진 생성자를 만들어준다.
```
@AllArgsConstructor 
public class User {
    private int userId;
    private String userName;
    private String userEmail;
}
```

### @NoArgsConstructor
- 기본생성자를 자동으로 만들어준다.
```
@NoArgsConstructor 
public class User {
    private int userId;
    private String userName;
    private String userEmail;
}
```

### @RequiredArgsContructor
- 필요한 멤버만 가진 생성자를 자동으로 만들어준다.
- 필요한 멤버는 @NonNull을 사용하여 지정한다.
```
@RequiredArgsContructor
public class User {
    @NonNull    //userId는 꼭 필요한 멤버필드.
    private int userId;
    private String userName;
    private String userEmail;
}
```

## Getter/Setter
- @Getter와 @Setter 어노테이션을 사용하면 get() 메서드와 set() 메서드도 일일이 작성할 필요 없이 자동으로 만들어진다.
```
@Getter
@Setter
public class User {
    private int userId;
    private String userName;
    private String userEmail;
}
```

- 이외에도 @ToString, @Data, @Builder 등 lombok 라이브러리에는 다양한 어노테이션들이 존재한다.
<br><br>

[참고1](https://imasoftwareengineer.tistory.com/32)  
[참고2](https://mangkyu.tistory.com/78)