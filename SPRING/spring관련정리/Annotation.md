# Annotaion  
spring에서 사용하는 annotaion들에 대한 정리  

## @Repository, @Service
- **두 가지 모두 root container에 bean 객체를 생성할 때 사용하는 annotaion.**
- @Repository의 경우 DB, 파일 등 외부의 I/O 작업을 처리할 때 사용.
- @Service는 내부 자바 로직을 처리하는 클래스 사용.  

[참조](https://codevang.tistory.com/258?category=849481)
<hr>

## @Resource, @Inject, @Autowired
- **세 가지 모두 컨테이너에 bean 객체를 주입할 때 사용하는 annotaton**
### @Resource
- 사용 가능 위치 : 필드, 파라미터가 한 개인 setter
- Bean 검색 우선 순위 : 이름 -> 타입
- Bean 강제 지정 : @Resource(name="ID")
- Bean이 없을 경우 : 예외 발생.
### @Inject
- 사용 가능 위치 : 필드, 생성자, setter
- Bean 검색 우선 순위 : 타입 -> 이름
- Bean 강제 지정
```
@Inject
@Named("ID")
```
- Bean이 없을 경우 : 예외 발생
### @Autowired
- 사용 가능 위치 : 필드, 생성자, setter
- Bean 검색 우선 순위 : 타입 -> 이름
- Bean 강제 지정
```
@Autowired
@Qualifier("ID")
```
- Bean이 없을 경우 : @Autowired(required=false) 처리하면 예외 발생 방지

[참조](https://codevang.tistory.com/256)
<hr>