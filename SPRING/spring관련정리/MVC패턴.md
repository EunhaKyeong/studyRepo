# MVC 패턴
## MVC 패턴이란
WAS 안에서의 역할을 3가지로 나눈 것.  
&nbsp;&nbsp;&nbsp;&nbsp;- M(=Model) : 로직을 처리(데이터 처리 포함).  
&nbsp;&nbsp;&nbsp;&nbsp;- V(=View) : 사용자 화면 출력.  
&nbsp;&nbsp;&nbsp;&nbsp;- C(=Controller) : 모델과 뷰를 제어.  
<br>
<img src="https://user-images.githubusercontent.com/66666533/101716324-65cdbf00-3ae0-11eb-874b-3a14e5f92d68.png">
<br>

## Controller
1. 작업분배 : 아래와 같은 모든 경우에서 controller을 꼭 거쳐야함.
    - 사용자가 URL을 입력할 때  
    - 모델에서 모델을 호출할 때
    - 뷰에서 뷰를 호출할 때 
2. 로직 수행이 필요한 경우 model을 호출하고, model의 결과를 view로 보내줘 화면에 출력.
3. 사용자가 정적 파일을 호출할 경우, model을 호출하지 않고 view만 호출하여 화면 출력.  
<br>

## Model
1. 로직을 수행하는 Java Class.
2. Command는 로직을 수행하는 기능을 가진 클래스.
3. DAO : 데이터 처리 로직을 가진 클래스.
4. DTO : 데이터를 저장/운반하는 클래스.
<br>

## View
1. 주로 JSP 사용
2. Tomcat이 최종적으로 컨트롤러가 실행한 JSP 파일을 서블릿으로 변환하여 실행
3. 사용자는 html 파일로 볼 수 있음.
<br><br>

[출처](https://codevang.tistory.com/192?category=844272)