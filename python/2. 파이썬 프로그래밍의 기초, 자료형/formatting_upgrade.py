#고급 문자열 포매팅
#숫자 바로 대입하기
print("I eat {0} apples.".format(3))

#문자열 바로 대입하기
print("I eat {0} apples.".format("five"))

#숫자 값을 가진 변수로 대입하기
number = 3
print("I eat {0} apples.".format(number))

#2개 이상의 값 넣기
number = 10
day = "three"
print("I ate {0} apples. So I was sick for {1} days.".format(number, day))

#이름으로 넣기
print("I ate {number} apples. So I was sick for {day} days.".format(number=10, day="three"))

#인덱스와 이름을 혼용해서 넣기
print("I ate {0} apples. So I was sick for {day} days.".format(10, day="three"))

#왼쪽 정렬
print("{0:<10}".format("hi"))

#오른쪽 정렬
print("{0:>10}".format("hi"))

#가운데 정렬
print("{0:^10}".format("hi"))

#공백 채우기
print("{0:=^10}".format("hi"))
print("{0:!<10}".format("hi"))

#소수점 표현하기
y = 3.42134234
print("{0:0.4f}".format(y))
print("{0:10.4f}".format(y))