'''
연습문제2.
다음 코드의 결과값은 무엇일까?

import re
p = re.compile("[a-z]+")
m = p.search("5 python")
m.start() + m.end()
'''
import re
p = re.compile("[a-z]+")
m = p.search("5 python")
print(m.start() + m.end())

#답:10