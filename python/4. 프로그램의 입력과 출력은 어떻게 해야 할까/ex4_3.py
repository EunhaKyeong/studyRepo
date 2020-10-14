#파일 생성하기 - oepn() 함수
#파일 열기 모드 - r, w, a
#r : 읽기 모드 - 파일을 읽기만 할 때 사용
#w : 쓰기 모드 - 파일에 내용을 쓸 때 사용
#a : 추가 모드 - 파일의 마지막에 새로운 내용을 추가할 때 사용.
f = open("newfile1.txt", 'w')
f.close()   #close() : 파일 객체를 닫아주는 함수. 이 문장은 생략해도 됨. 프로그램을 종료할 때 파이썬이 자동으로 열려 있는 파일 객체를 닫아주기 때문.

#파일을 쓰기 모드로 열어 출력값 적기
f = open("newfile2.txt", 'w')
for i in range(1, 11):
    data = "%d번째 출입니다.\n" %i
    f.write(data)   #data를 파일 객체에 써라.
f.close();

#readline() 함수를 이용하여 외부에 저장된 파일 읽기 - 첫번째 줄 읽기
f = open("newfile2.txt", 'r')
line = f.readline() #newfile2.txt의 첫번째 줄 내용을 읽음.
print(line) #newfile2.txt.의 첫번째 줄 내용을 출력.->출력 결과 : 1번째 줄입니다.
f.close()

#readline() 함수를 이용하여 외부에 저장된 파일 읽기 - 모든 내용을 읽어서 출력하기
f = open("newfile2.txt", 'r')
while True:
    line = f.readline()
    if not line:
        break
    print(line)
f.close()

#readlines() 함수를 이용하여 외부에 저장된 파일 읽기.
f = open("newfile2.txt", 'r')
lines = f.readlines()   #readlines() 함수는 파일의 모든 내용을 읽어서 각각의 줄을 하나의 요소로 갖는 리스트 형태로 반환함.
for line in lines:
    print(line)
f.close()

#read() 함수를 이용하여 외부에 저장된 파일 읽기.
f = open("newfile2.txt", 'r')
data = f.read() #read() 함수는 파일의 내용 전체를 문자열로 리턴함.
print(data)
f.close()

#파일에 새로운 내용 추가하기 - a 모드
# f = open("newfile2.txt", 'a')
# for i in range(11, 20):
#     data = "%d번째 줄입니다.\n" %i
#     f.write(data)
# f.close()

#with문과 함께 사용하기
#with문은 파일을 자동으로 열고 닫게 해준다.
with open("newfile3.txt", 'w') as f:
    f.write("Life is too short, you need python\n")
#with 블록을 벗어나는 순간 자동으로 파일 객체 f가 close됨.