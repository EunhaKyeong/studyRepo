'''
하위 디렉터리 검색하기
특정 디렉터리부터 시작해서 하위의 모든 파일 중 파이썬 파일만 출력해 주는 프로그램 만들기
'''
import os

def search(dirname):
    filesname = os.listdir(dirname)
    pythonfile = [filename for filename in filesname if filename[-3:]=='.py']
    return pythonfile

result = search("C:\\Users\\eunha\\OneDrive\\바탕 화면\\study\\python\\5.파이썬 날개 달기")
print(result)