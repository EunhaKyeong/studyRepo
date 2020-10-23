'''
연습문제3.
다음과 같은 문자열에서 행드폰 번호 뒷자리인 숫자 4개를 ####로 바꾸는 프로그램을 정규식을 이용하여 작성해 보자.

park 010-9999-8888
'''
import re
def hidePhone(info):
    p = re.compile("\d+$")
    print(p.sub("####", info))

hidePhone("park 010-9999-9988")
hidePhone("kim 010-9909-7789")
hidePhone("lee 010-8789-7768")