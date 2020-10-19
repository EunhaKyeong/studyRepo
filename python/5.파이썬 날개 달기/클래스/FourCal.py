class FourCal:
    def setdata(self, num1, num2):
        self.num1 = num1
        self.num2 = num2
    def sum(self):
        result = self.num1+self.num2
        return result
    def sub(self):
        return self.num1-self.num2
    def mul(self):
        return self.num1*self.num2
    def div(self):
        return self.num1/self.num2

a = FourCal()
a.setdata(4, 2)
print(a.sum())
print(a.sub())
print(a.mul())
print(a.div())