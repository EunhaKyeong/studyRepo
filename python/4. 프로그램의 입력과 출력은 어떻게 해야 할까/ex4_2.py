#print - + 연산은 띄어쓰기 안됨.
print("Life" + "is" + "too" + "short")  #출력 결과 : Lifeistooshort

#print - 콤마(,)는 띄어쓰기 붙음.
print("Life", "is", "too", "short") #출력 결과 : Life is too short

#한 줄에 결과값 출력하기 - 입력 인수 end를 이용해 끝 문자 지정하기
for i in range(10):
    print(i, end=' ')   #출력 결과 : 0 1 2 3 4 5 6 7 8 9