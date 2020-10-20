try:
    #무언가를 수행한다.
    f = open('foo.txt', 'w')
finally:   #finally절은 try문 수행 도중 예외 발생 여부에 상관없이(예외가 발생하든 발생하지 않든) 항상 수행됨.
    f.close()