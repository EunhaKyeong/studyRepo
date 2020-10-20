try:
    f = open('foo.txt', 'r')
except FileNotFoundError as e:
    print(str(e))
else:   #에러가 발생하지 않을 경우
    data = f.read()
    f.close()