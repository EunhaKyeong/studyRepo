try:
    4/0
except ZeroDivisionError as e:  #ZeroDivisionError 오류의 오류 메세지를 e에 넣어서 반환.
    print(e)

try:
    f = open("나없는파일", 'r')
except FileNotFoundError:
    pass    #파일이 없더라도 오류를 발생시키지 않고 통과함 -> 오류 회피