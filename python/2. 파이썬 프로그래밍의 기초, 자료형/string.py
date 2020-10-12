#문자열 관련 함수
#문자 개수 세기 : count()
a = "hobby"
print(a.count('b')) #hobboy에 b가 몇 개 들어있는지 카운트 -> 출력 결과:2

#위치 알려주기 : find()
a = "Python is best choice"
print(a.find('b'))  #a에서 'b'가 나온 처음 위치를 알려줌. 문자나 문자열이 존재하지 않으면 -1 출력 -> 출력 결과:10

#위치 알려주기 : index()
a = "Life is too short"
print(a.index('t'))    #a에서 처음 't'가 나오는 위치를 알려줌. 't'가 존재하지 않으면 오류 발생. -> 출력 결과 : 8

#문자열 삽입 : join()
a = ","
print(a.join("abcd"))   #abcd 문자 사이사이에 ',' 삽입. -> 출력 결과 : a,b,c,d

#소문자 -> 대문자 : upper()
a = "hi"
print(a.upper())    #출력 결과 : HI

#대문자 -> 소문자 : lower()
a = "HI"
print(a.lower())    #출력 결과 : hi

#왼쪽 공백 지우기 : lstrip()
a = "  hi"
# 문자열의 왼쪽에 있는 모든 공백을 지움
print(a)    #출력 결과 : "  hi"
print(a.lstrip())   #출력 결과 : "hi"

#오른쪽 공백 지우기 : rstrip()
a = "hi  "
# 문자열의 오른쪽에 있는 모든 공백을 지움
print(a)    #출력 결과 : "hi  "
print(a.rstrip())   #출력 결과 : "hi"

#양쪽 공백 지우기 : strip()
a = "  hi  "
#문자열 양쪽에 있는 모든 공백을 지움.
print(a)    #출력 결과 : "  hi  "
print(a.strip())    #출력 결과 : "hi"

#문자열 바꾸기 : replace()
a = "Life is too short"
print(a.replace("Life", "Your leg"))    #a의 'Life'를 'Your leg'로 바꿈 -> 출력 결과 : Your leg is too short

#문자열 나누기 : split()
a = "Life is too short"
print(a.split())    #공백을 기준으로 문자열 나눔. -> 출력 결과 : ['Life', 'is', 'too', 'short']
a = "a:b:c:d"
print(a.split(':')) #: 기준으로 문자열 나눔. -> 출력 결과 : ['a', 'b', 'c', 'd']