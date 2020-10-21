'''
구구단 프로그램 짜보기
함수 이름:GuGu
입력받는값:구구단 몇단인지
출력하는값:입력받은 구구단 단의 결과
결과를 저장할 자료형:리스트
'''
def gugu(dan):
    dan_result = []
    for i in range(1, 10):
        dan_result.append(dan*i)
    return dan_result

print(gugu(2))