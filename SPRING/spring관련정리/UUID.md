# 📔UUID  
- UUID는 범용 고유 식별자(Universally Unique IDentifier)를 말함.  
- 스프링에서 파일 업로드할 때 관련된 자료를 찾다보니 uuid란 개념에 대해 알게 되었다.
- 업로드할 파일의 이름과 같은 이름의 파일이 같은 경로상에 존재한다면 기존의 파일로 덮어씌워질 상황이 발생할 수 있다.
- 이를 방지하고자 파일의 이름을 UUID로 생성하여 저장한다.
- UUID의 중복될 확률을 매우 희박하다.
- JAVA에서는 java.util 패키지의 UUID 클래스를 활용하여 UUID를 생성할 수 있다.  
<br><br>

[참고](https://enai.tistory.com/38)