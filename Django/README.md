# 📖Django
## MVC, MTV
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Router-MVC-DB.svg/600px-Router-MVC-DB.svg.png">

출처 : [위키백과](https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%8D%B8-%EB%B7%B0-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC)

- 초기 웹 어플리케이션에서는 모든 로직을 하나의 공간에서 작업해 수정 시 모든 로직을 변경해야하는 어려움이 있었음.  
- 하지만 웹 어플리케이션을 기능별로 작업을 나누는 MVC 패턴이 등장하면서 위와 같은 어려움을 해결할 수 있게 됨.  
1. Model : DB 관련 기능을 정의하는 작업을 하는 공간.  
2. View : DB에 있는 데이터를 적절하게 가공하여 웹브라우저에 보여주기 위한 작업을 하는 공간.  
3. Controller or Template : 사용자가 web browser에서 어떠한 이벤트를 일으켰을 때(form 작성, 회원가입, blog 작성 등) Model과 View를 업데이트하는 작업을 하는 공간. 보통 Controller를 사용하지만 Django에서는 Template을 사용.  
## Django란?  
1. Python으로 만들어진 웹 어플리케이션 Framwork.  
2. CRUD의 기능을 가지는 웹서비스를 만들 때 효과적으로 활용할 수 있는 Framework.  
## Project & App  
1. Project란 가장 거대한 웹서비스를 말함. (가장 큰 틀)
2. App은 거대한 Project에서 각각 독자적으로 가지는 서비스들을 말함.  
3. 만약에 Project가 Naver라면, App은 네이버메일, 회원가입, 네이버밴드, 네이버뮤직 ... 등등이 있음.  
4. App 안에 내부적으로 App을 생성할 수도 있고, 외부의 App과 관계를 맺을 수도 있음.  
<br><br>

# 🔍참조
[YOUBUTE_OneQ:웹 프레임워크 Django(python) 개념 정리](https://youtu.be/LYmZB5IIwAI)  
<br><br>

# 📖Django 프로젝트 생성하기  
### 가상환경 생성
```
python -m venv 가상환경이름  
```  
### 가상환경 실행  
```
myvenv\Scripts\activate
```  
### Django 라이브러리 설치  
&nbsp; 가상환경 실행 후 설치하기  
```
pip install django
```
### 프로젝트 생성
```
django-admin startproject 프로젝트이름
```  
### App 생성
```
cd 프로젝트이름     #App을 생성하고 싶은 상위 프로젝트로 이동
manage.py startapp 앱이름 
```  
&nbsp; app을 생성했으면 상위 project의 settings.py로 이동해 app을 등록해 주어야 함.  
### SuperUser 생성
```
manage.py createsuperuser
```
### Server 실행
&nbsp; port번호 입력 안하면 자동으로 port 번호는 8080.
```
manage.py runserver (port번호)
```
<br><br>

# 📖Django Migrate 
- models.py의 DB 관련 변경사항 or 생성 내역을 직접 DB에 연결하지 않고도 적용시켜주는 Django의 기능.  
- models.py에서 생성 or 변경된 migration 파일들을 DB에 적용하는 명령어. 
```
manage.py migrate
```
- migration 파일 생성 명령어.(아직 DB에 적용은 되지 않은 상태)    
```
manage.py makemigrations (app-name)
```
<br><br>

# 🔍참조
[유튜브_OneQ](https://youtu.be/Fn2XMeRmwe4)