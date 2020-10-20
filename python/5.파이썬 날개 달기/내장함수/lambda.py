'''
lambda란?
1. 함수를 생성할 때 사용하는 예약어.
2. def와 동일한 역할을 함.
3. 보통 함수를 한줄로 간결하게 만들 때 사용함.
4. def를 사용해야 할 정도로 복잡하지 않거나 def를 사용할 수 없는 곳에 주로 쓰임.
'''

sum = lambda a, b: a+b
print(sum(3, 4))

#리스트 내에 lambda가 들어간 경우
myList = [lambda a, b:a+b, lambda a, b:a*b] #myList 리스트 안에는 lambda 함수 두 개가 들어감.
print(myList[1](3, 4))  #lambda a, b:a*b 함수를 호출, 출력결과:12
