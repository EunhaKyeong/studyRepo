#time 모듈 : 시간과 관련된 모듈.
import time

#time.time() : 현재 시간을 실수 혀애로 리턴하는 함수. 
#1970년 1월 1일 0시 0분 0초를 기준으로 지난 시간을 초 단위로 리턴함.
print(time.time())

#time.localtime() : time.time()에 의해 반환된 실수값을 연도, 월, 일, 시, 분, 초, ...의 형태로 바꿔 주는 함수.
print(time.localtime(time.time()))

#time.asctime() : time.localtime()에 의해 반환된 튜플 형태의 값을 인수로 받아 날짜와 시간을 알아 보기 쉬운 형태로 리턴하는 함수.
print(time.asctime(time.localtime(time.time())))

#time.ctime() : time.asctime(time.localtime(time.time()))을 time_ctime()을 사용하여 간편하게 표시할 수 있음.
#단 time_ctime()은 time.asctime()과 달리 현재 시간만을 리턴함.
print(time.ctime())

#time.strftime() : 시간에 관계된 것을 세밀하게 표현할 수 잇는 여러 가지 포맷 코드를 제공함.
print(time.strftime('%x', time.localtime(time.time())))
print(time.strftime('%c', time.localtime(time.time())))

#time.sleep() : 일정한 시간 간격을 둘 때 사용하는 함수. 주로 루프 안에서 많이 사용됨.
for i in range(10):
    print(i)
    time.sleep(1)   #1초 간격으로 0부터 9까지 숫자를 출력.