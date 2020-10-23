#sub() : 문자열 바꾸기
#sub 메서드를 이용하면 정규식과 매치되는 부분을 다른 문자로 바꿀 수 있음.
import re 

p = re.compile("(red|blue|white)")
sub_result = p.sub('color', 'blue socks and red shoes') #첫번째 인수는 바꿀 문자열, 두번째 인수는 대상 문자열
print(sub_result)

#count 인수를 사용하면 바꾸기 횟수를 제어할 수 있음.
sub_result = p.sub('color', 'blue socks and red shoes', count=1)    #count값이 1이므로 정규표현식과 매치되는 모든 문자열을 바꾸는것이 아니라 맨 처음 딱 하나의 문자열만 바꿈.
print(sub_result)

#sub 메서드에서 참조 구문 사용하기
p = re.compile(r"(?P<name>\w+)\s+(?P<phone>\d+[-]\d+[-]\d+)")
sub_result = p.sub("\g<phone> \g<name>", "park 010-1234-1234")
print(sub_result)