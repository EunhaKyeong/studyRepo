'''
map 함수란
1. 함수와 반복 가능한 자료형을 인자로 받음.
2. 입력받은 자료형의 각 요소가 입력받은 함수에 의해 수행된 결과를 묶어서 리턴하는 함수.
'''

def two_times(x):
    return x*2

print(list(map(two_times, [1, 2, 3, 4])))

'''
만약 map 함수를 쓰지 않았다면?
def two_times(numberList):
    resultList = []
    for num in numberList:
        resultList.append(num*2)
    return resultList

result = two_times([1, 2, 3, 4])
print(result)
'''

#lambda 함수를 사용한다면?
print(list(map(lambda a:a*2, [1, 2, 3, 4])))

#lambda 함수와 map 함수를 이용하여 만든 또 다른 예제
print(list(map(lambda a:a+1, [1, 2, 3, 4])))