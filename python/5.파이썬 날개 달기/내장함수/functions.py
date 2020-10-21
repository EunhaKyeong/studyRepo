#abs() : 어떤 숫자를 입력으로 받았을 때 그 숫자의 절댓값을 돌려주는 함수.
print(abs(3))   #출력결과:3
print(abs(-3))  #출력결과:3
print(abs(-1.2))    #출력결과:1.2

#all() : 반복 가능한 자료형 x를 입력 인수로 받아 이 x가 모두 참이면 True, 거짓이 하나라도 있으면 False를 리턴하는 함수.
print(all([1, 2, 3]))   #출력결과:True
print(all([0, 1, 2, 3]))    #출력결과:False

#any() : 반복 가능한 자료형 x가 하나라도 참이면 True, 모두 거짓이면 False를 리턴하는 함수.
print(any([1, 2, 3, 0]))    #출력결과:True
print(any([0, ""])) #출력결과:False

#chr() : 아스키 코드값을 입력으로 받아 해당하는 문자를 출력하는 함수.
print(chr(97))  #출력결과:'a'
print(chr(48))  #출력결과:'0'

#dir() : 객체가 자체적으로 가지고 있는 변수나 함수를 보여 줌.
print(dir([1, 2, 3]))   #리스트 객체의 관련 함수들(메서드)을 보여 줌.
print(dir({'1':'a'}))   #딕셔너리 객체의 관련 함수들(메서드)을 보여 줌.

#divmod() : 2개의 숫자를 입력 받아(예를 들어 a, b) a를 b로 나눈 몫과 나머지를 튜플 형태로 리턴하는 함수.
print(divmod(7, 3)) #출력결과:(2, 1)
print(divmod(1.3, 0.2)) #출력결과:(6.0, 0.09999999999999998)

#enumerate() : 순서가 있는 자료형(리스트, 튜플, 문자열 등)을 입력으로 받아 인덱스 값을 포함하는 객체를 리턴함.
for i, name in enumerate(['body', 'foo', 'bar']):
    print(i, name)

#eval() : 실행 가능한 문자열을 입력으로 받아 문자열을 실행한 결과를 리턴하는 함수.
print(eval('1+2'))  #출력결과:3
print(eval('"hi"+"a"')) #출력결과:hia
print(eval('divmod(4, 3)')) #출력결과:(1, 1)

#hex() : 정수를 입력 받아 16진수로 변환하여 리턴하는 함수.
print(hex(234)) #출력결과:0xea
print(hex(3))   #출력결과:0x3

#id() : 객체를 입력 받아 객체의 고유 주소값(=레퍼런스)를 리턴하는 함수.
a = 3
print(id(a))
print(id(3))
b = a
print(id(b))

#input() : 사용자 입력을 받는 함수.
# a = input()
# print(a)
# b = input("Enter : ")
# print(b)

#int() : 문자열 형태나 정수가 아닌 실수를 정수로 리턴하는 함수.
print(int('3')) #문자열->정수
print(int(3.4)) #정수가 아닌 실수->장수

#isinstance() : 첫번째 인자로 인스턴스, 두번째 인자로 클래스 이름을 받아 해당 인스턴스가 해당 클래스의 인스턴스이면 True, 아니면 False를 반환하는 함수.
class Person:
    pass

a = Person()
b = 3
print(isinstance(a, Person))    #a는 Person의 인스턴스이므로 True.
print(isinstance(b, Person))    #b는 Person의 인스턴스가 아니므로 False.

#len() : 입력값의 길이를 리턴하는 함수.
print(len("python"))    #출력결과:6
print(len([1, 2, 3]))   #출력결과:3
print(len((1, 'a')))    #출력결과:2

#list() : 반복 가능한 자료형을 입력 받아 리스트로 만들어 리턴하는 함수.
print(type("python"))   #출력결과:<class 'str'>
print(list("python"))   #출력결과:['p', 'y', 't', 'h', 'o', 'n']
print(type(list("python"))) #출력결과:<class 'list'>

#max() : 최댓값을 리턴하는 함수
print(max([1, 2, 3]))   #출력결과:3
print(max("python"))    #출력결과:y

#min() : 최솟값을 리턴하는 함수
print(min([1, 2, 3]))   #출력결과:1
print(min("python"))    #출력결과:'h'

#oct() : 정수 형태 숫자를 8진수 문자열로 바꿔 리턴하는 함수.
print(oct(34))  #출력결과:0o42
print(oct(12345))   #출력결과:0o30071

#ord() : 문자의 아스키 코드값을 리턴하는 함수.
print(ord('a')) #출력결과:97
print(ord('O')) #출력결과:48

#pow(x, y) : x의 y제곱 결과를 리턴하는 함수.
print(pow(2, 4))    #출력결과:16
print(pow(3, 3))    #출력결과:27 

#str() : 문자열 형태로 변환하여 리턴하는 함수.
print(str(3))   #출력결과:'3'
print(str('hi'))    #출력결과:'hi'
print(str('hi'.upper()))    #출력결과:'HI'

#tuple() : 반복 가능한 자료형을 입력받아 튜플 형태로 변환 후 리턴하는 함수.
print(tuple("abc")) #출력결과:('a', 'b', 'c')
print(tuple([1, 2, 3])) #출력결과:(1, 2, 3)
print(tuple((1, 2, 3))) #출력결과:(1, 2, 3)

#type() : 입력값의 자료형이 무엇인지 알려주는 함수.
print(type("abc"))  #출력결과:<class 'str'>
print(type([])) #출력결과:<class 'list'>
print(type(open("test", 'w')))  #출력결과:<class '_io.TextIOWrapper'> -> 파일 자료형

#zip() : 동일한 개술 이루어진 자료형을 묶어 주는 역할.
print(list(zip([1, 2, 3], [4, 5, 6])))  #출력결과:[(1, 4), (2, 5), (3, 6)]
print(list(zip([1, 2, 3], [4, 5, 6], [7, 8, 9])))   #출력결과:[(1, 4, 7), (2, 5, 8), (3, 6, 9)]
print(list(zip("abc", "def")))  #출력결과:[('a', 'd'), ('b', 'e'), ('c', 'f')]