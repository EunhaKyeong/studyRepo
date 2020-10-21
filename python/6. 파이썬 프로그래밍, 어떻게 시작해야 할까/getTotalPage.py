'''
게시판 페이징하기
게시물의 총 건수와 한 페이지에 보여줄 게시물 수를 입력으로 주었을 때 총 페이지수를 출력하는 프로그램 만들어보기
예를 들어 게시물의 총 건수는 5, 페이지당 보여줄 게시물수는 10이라 하면 총 페이지수는 1
'''

def getTotalPage(total, one_page):
    if total%one_page==0:
        return int(total/one_page)
    else:
        return int(total/one_page)+1

print(getTotalPage(5, 10))
print(getTotalPage(15, 10))
print(getTotalPage(25, 10))
print(getTotalPage(30, 10))