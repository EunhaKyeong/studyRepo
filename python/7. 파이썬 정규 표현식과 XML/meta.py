import re
#메타문자 | : or과 동일한 의미.
p = re.compile('Crow|Servo')    #Crow 이거나 Servo
m = p.match('CrowHello')
print(m.group())

#메타문자 ^ : 문자열의 맨 처음과 일치함.
print(re.search('^Life', "Life is too short").group())  #Life로 시작하는지
print(re.search('^Life', "My Life"))

#메타문자 $ : 문자열의 끝과 매치함.
print(re.search('short$', "Life is too short").group()) #끝이 short로 끝나는가
print(re.search('short$', "Life is too short, you need python"))

#메타문자 \b : 공백을 의미.
p = re.compile(r'\bclass\b')    #r 사용하면 백슬래시를 굳이 두번 쓸 필요 없이 한번만 사용하면 됨.
print(p.search("no class at all").group())
print(p.search("the declassified algorithm"))

#메타문자 \B : 공백이 아닌 문자를 의미
p = re.compile(r'\Bclass\B')
print(p.search("no class at all"))
print(p.search("the declassified algorithm").group())

#그룹핑 : ()
p = re.compile("(ABC)+")    #ABC가 반복
m = p.search("ABCABCABC OK?")
print(m.group())

p = re.compile(r"\w+\s+\d+[-]\d+[-]+\d+")   #"이름 전화번호" 형태의 문자열을 찾는 정규식
m = p.search("park 010-1234-1234")
print(m.group())

p = re.compile(r"(\w+)\s+(\d+[-]\d+[-]\d+)")    #이름과 전화번호를 그룹핑
m = p.search("park 010-1234-1234")
print(m.group(0))   #매치된 전체 문자열
print(m.group(1))   #첫번째 그룹에 해당되는 문자열 -> park
print(m.group(2))   #두번째 그룹에 해당되는 문자열 -> 010-1234-1234

#그룹핑된 문자열 재참조하기
p = re.compile(r"(\w+)\s+\1")   #\1 : 재참조 메타 문자. \1은 첫번째 그룹을 지칭함. 만약에 두번째 그룹이면 \2를 사용하면 됨.
result = p.search("Paris in the the rain").group()
print(result)
p = re.compile(r"(\w+)\s+(\d)+\s+\2")
result = p.search("Paris in the the rain for 3 3 days").group()
print(result)

#그룹핑된 문자열에 이름 붙이기 : 확장 구문을 사용하면 그룹에 이름을 지어 줄 수 있음.
#확장 구문 : (?P<그룹명>그룹 정규 표현식)
p = re.compile(r"(?P<name>\w+)\s((\d+)[-]\d+[-]\d+)")   #확장 구문을 사용하여 \w+라는 그룹에 name이란 그룹명을 붙여줌.
m = p.search("park 010-1234-1234")
print(m.group())    #해당 전체 결과 출력
print(m.group("name"))  #정규표현식에 매칭된 결과 중 그룹명이 name인 결과 출력
#그룹명을 이용하여 재참조하기
p = re.compile(r"(?P<word>\w+)\s+(?P=word)")
m = p.search("Paris in the the spring")
print(m.group())
print(m.group("word"))
