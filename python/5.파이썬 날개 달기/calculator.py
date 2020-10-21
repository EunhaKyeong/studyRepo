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