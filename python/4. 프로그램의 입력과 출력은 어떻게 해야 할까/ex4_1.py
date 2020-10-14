#여러 개의 입력값을 받는 함수
#함수를 만들 때 입력값이 몇 개가 들어갈지 정의하기 어려울 경우 *입력 변수를 사용
def sum_many(*args):    #*args에는 여러개의 변수가 들어갈 수 있고, 함수가 실행되면 입력값들을 args 튜플로 만들어 준다.
    sum = 0
    for i in args:
        sum += i
    return sum

result = sum_many(1, 2, 3)  #args = (1, 2, 3) -> 튜플 형태
print(result)   #출력 결과 : 6

#함수의 결과값은 언제나 하나이다.
def sum_and_mul(a, b):
    return a+b, a*b 

result = sum_and_mul(3, 4)  #함수의 결과값은 언제나 하나이기 때문에 result는 (a+b, a*b) 튜플값 하나를 갖게 된다.
print(result)   #출력 결과 : (7, 12)
sum, mul = sum_and_mul(3, 4) #함수의 결과값을 튜플값이 아니라 각자 하나하나 갖게 하고 싶다면 다음과 같이 함수를 호출한다.
print("sum=", sum, ", mul=", mul)   #sum=7, mul=12