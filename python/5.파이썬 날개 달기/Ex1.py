#연습문제1. 다음과 같이 동작하는 클래스 Calculator를 작성해 보자.
'''
cal1 = Calculator([1, 2, 3, 4, 5])
cal.sum()   #합계
>>15
cal1.avg()  #평균
>>3.0
cal2 = Calculator([6, 7, 8, 9, 10])
cal2.sum()
>>40
cal2.avg()
>>8.0
'''
class Calculator:
    def __init__(self, numList):
        self.numList = numList
    def sum(self):
        result = 0
        for num in self.numList:
            result += num
        print(result)
    def avg(self):
        total = 0
        for num in self.numList:
            total += num
        print(total/len(self.numList))
    '''
    def avg(self):
        total = self.sum()
        print(total/len(self.numList))
    ''' 

cal1 = Calculator([1, 2, 3, 4, 5])
cal1.sum()
cal1.avg()

cal2 = Calculator([6, 7, 8, 9, 10])
cal2.sum()
cal2.avg()