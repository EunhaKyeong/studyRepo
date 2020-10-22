#match 객체의 메서드
#match 메서드와 search 메서드의 결과로 리턴된 match 객체의 메서드로 group(), start(), end(), span() 등이 있다.
import re
p = re.compile("[a-z]+")
m = p.match("python")
#group() : 매치된 문자열을 리턴함.
print(m.group())    #출력결과:python
#start() : 매치된 문자열의 시작 위치를 리턴함.
print(m.start())    #출력결과:0
#end() :매치된 문자열의 끝 위치를 리턴함.
print(m.end())  #출력결과:6
#span() : 매치된 문자열의 시작, 끝에 해당하는 튜플을 리턴함.
print(m.span()) #출력결과:(0, 6)

m = p.search("3 python")
print(m.group())    #출력결과:python
print(m.start())    #출력결과:2
print(m.end())  #출력결과:8
print(m.span()) #출력결과(2, 8)