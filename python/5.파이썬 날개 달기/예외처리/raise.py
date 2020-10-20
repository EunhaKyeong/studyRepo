#raise는 오류를 강제로 발생시키는 명령어이다.
class Bird:
    def fly(self):
        raise NotImplementedError   #NotImplementedError는 꼭 작성해야 하는 부분이 구현되지 않았을 경우 일부러 오류를 발생시키는 파이썬 내장 오류임.
'''
class Eagle(Bird):
    pass
eagle = Eagle()
eagle.fly() #eagle 객체는 fly 함수를 구현하지 않았기 때문에 raise문에 의해 NotImplementedError가 발생.
'''

class Eagle(Bird):
    def fly(self):
        print("very fast")
eagle = Eagle()
eagle.fly() #fly 함수를 구현했으므로 오류 발생하지 않음.