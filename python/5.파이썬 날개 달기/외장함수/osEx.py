#OS모듈 : 환경 변수, 디렉터리, 파일 등의 OS 자원을 제어할 수 있게 하는 모듈.
import os

#os.environ : 현재 시스템의 환경 변수 값들을 보여줌.
#os.environ은 환경 변수에 대한 정보를 딕셔너리 객체로 리턴함.
print(os.environ)
print(os.environ['PATH'])   #현재 시스템의 PATH 환경 변수에 대한 내용을 출력.

#os.chdir() : 현재 디렉터리의 위치 변경.

#os.getcwd() : 현재 디렉터리 위치 리턴.
print(os.getcwd())

#os.system() : 시스템 명령어 호출하기
print(os.system("dir"))

#os.popen() : 시스템 명령어를 실행시킨 결과값을 읽기 모드 형태의 파일 객체로 리턴함.
f = os.popen("dir") #dir 명령어의 결과값을 읽기 모드 파일의 파일 객체로 저장.
print(f.read()) #파일 객체의 내용 읽기