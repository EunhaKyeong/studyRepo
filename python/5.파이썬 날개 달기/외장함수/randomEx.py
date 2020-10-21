#random 모듈 : 난수를 발생시키는 모듈.
import random

#random.random() : 0.0에서 1.0 사이의 실수 중 난수값을 리턴함.
print(random.random())

#random.randint(시작 정수, 끝 정수) : 시작 정수에서 끝 정수 사이의 정수 중에서 난수값을 리턴.
print(random.randint(1, 10))    #1에서 10 사이의 정수 중 난수값을 리턴.
print(random.randint(1, 55))    #1에서 55 사의의 정수 중 난수값을 리턴.

#random.choice() : 입력으로 받은 객체에서 무작위로 하나 선택하여 리턴함.
data_list = [1, 2, 3, 4, 5]
print(random.choice(data_list))
data_tuple = (1, 2, 3, 4, 5)
print(random.choice(data_tuple))

#random.shuffle() : 입력받은 객체를 무작위로 섞고 싶을 때 사용하는 함수.
data = [1, 2, 3, 4, 5]
random.shuffle(data)
print(data)