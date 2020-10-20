#모듈이란 함수나 변수 또는 클래스 등을 모아 놓은 파일을 말함.
#mod2 모듈을 불러와 modest.py 파일에서 사용하기
'''
모듈이 저장되어 있는 곳으로 이동하지 않고 모듈을 불러와서 사용하는 방법.
import sys
sys.path.append("C:\Python\Mymodules")
print(sys.path)
'''
import mod2
result = mod2.sum(3, 4)
print(result)

