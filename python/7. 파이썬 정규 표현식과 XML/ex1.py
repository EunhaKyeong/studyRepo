'''
연습문제1.
다음 중 정규식 "a[.]{3,}b"과 매치되는 문자열은 무엇일까?
A. acccb     B. a....b    C. aaab   D. a.cccb
'''
import re
p = re.compile("a[.]{3,}b")
print(p.search("a....b").group())

#답:B