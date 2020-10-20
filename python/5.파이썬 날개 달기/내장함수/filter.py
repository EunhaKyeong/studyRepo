#filter() : 첫번째 인자 값으로 함수 이름을, 두번째 인자 값으로 순서가 있는 자료형을 받아 자료형을 인자값으로 가지고 있는 함수에 들어갔을 때 참인 값들만 돌려주는 함수.
def positive(x):
    return x>0

print(list(filter(positive, [1, -3, 2, 0, -5, 6]))) #출력결과:[1, 2, 6]

'''
만약 filter 내장 함수를 사용하지 않는다면?
def positive(numberList):
    resultList = []
    for num in numberList:
        if num > 0:
            resultList.append(num)
    return resultList

print(positive([1, -3, 2, 0, -5, 6]))
'''