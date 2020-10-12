#문자열 포매팅 : 문자열 내에 어떤 값을 삽입하는 방법.

print("I eat %d apples." %3)    #숫자를 넣고 싶으면 %d
print("I eat %s appples." %"five")  #문자열을 넣고 싶으면 %s

#숫자 값을 나타내는 변수로 대입.
number = 3
print("I eat %d apples." %number)

#2개 이상의 값 넣기
number = 10
day = "three"
print("I ate %d apples. So I was sick for %s days." %(number, day))

#포매팅 연산자 %와 그냥 문자 %를 같이 쓸 때는 그냥 문자 %를 %%로 쓴다.
print("Error is %d%%." %98)

#정렬, 공백
print("%10s" %"hi") #전체 길이가 10개인 문자열 공간에서 hi를 오른쪽으로 정렬하고 그 앞의 나머지는 공백으로 남겨 둠.
print("%-10sjane." %"hi")    #왼쪽 정렬(전체 길이가 10개인 문자열 공간에서 hi를 왼쪽으로 정렬 후 나머지 8자는 공백. 이후에 jane이 출력.)

#소수점 표현하기
print("%0.4f" %3.141592423123)  #소수 4번째 자리까지 반올림.
