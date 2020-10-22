import re   #파이썬이 정규 표현식을 지원하기 위해 제공하는 모듈.
p = re.compile('[a-z]+')   #compile 메서드를 이용해 정규표현식을 컴파일함.

#match() : 문자열의 처음부터 정규식과 매치되는지 조사하는 메서드.
m = p.match("python")
print(m)    #정규표현식에 부합하여 match 객체가 리턴됨.
m = p.match("3python")
print(m)    #정규표현식에 부합하지 않아 None이 리턴됨.

#search() : 문자열 전체를 검색해 문자열 중에서 정규표현식에 매칭되는 부분만 객체로 리턴함.
m = p.search("python")
print(m)    #정규표현식에 부합하여 match 객체가 리턴됨.
m = p.search("3 python")
print(m)    #match 메서드에서는 문자열 전체가 정규표현식에 매칭되지 않아 None이 출력되지만 search에서는 문자열의 매칭되는 부분인 python 객체만 출력됨.

#findall() : 문자열 중에서 정규표현식에 매칭되는 단어들만 리스트 형태로 리턴됨.
result = p.findall("life is too short")
print(result)   #출력결과:['life', 'is', 'too', 'short']
result = p.findall("3 python")
print(result)   #출력결과:['python']

#finditer() : findall() 메서드와 같지만 리스트를 리턴하는 것이 아니라 반복 가능한 객체(match 객체)를 리턴한다.