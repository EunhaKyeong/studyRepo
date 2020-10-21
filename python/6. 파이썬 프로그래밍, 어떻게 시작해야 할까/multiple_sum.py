'''
3과 5의 배수 합하기
10 미만의 자연수에서 3과 5의 배수를 구하면 3, 5, 6, 9이다. 이들의 총합은 23이다.
1000 미만의 자연수에서 3의 배수와 5의 배수의 총합을 구하라.
'''

def multiple_sum(lastNum):
    totalList = [num for num in range(1, lastNum) if (num%3==0 or num%5==0)]
    sum = 0
    for num in totalList:
        sum += num
    return sum

print(multiple_sum(1000))
