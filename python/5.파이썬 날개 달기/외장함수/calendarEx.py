#calendar 모듈 : 파이썬에서 달력을 볼 수 있게 해주는 모듈.
import calendar

#calendar.calendar(연도), calendar.prcal(연도) : 입력한 연도의 전체 달력을 볼 수 있음.
print(calendar.calendar(2020))
calendar.prcal(2020)

#calendar.prmonth(연도, 월) : 입력한 연도와 월의 달력을 보여 줌.
calendar.prmonth(2020, 10)

#calendar.weekday(연도, 월, 일) : 그 날짜에 해당하는 요일 정보를 리턴.
#0:월요일, 1:화요일, ..., 5:토요일, 6:일요일
print(calendar.weekday(2020, 10, 21))

#calendar.monthrange(연도, 월) : 입력받은 달의 1일이 무슨 요일인지와 입력받은 달이 며칠까지 있는지를 튜플 형태로 리턴함.
print(calendar.monthrange(2020, 10))    #출력결과:(3, 31) -> 2020년 10월 1일은 목요일이고, 31일까지 있음.