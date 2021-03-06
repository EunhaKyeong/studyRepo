#리스트 자료형
#리스트 안에는 어떠한 자료형도 포함될 수 있다. (숫자형 리스트, 문자형 리스트, 숫자형+문자형 리스트 등등)

a = [1, 2, 3]
#리스트에서 하나의 값 수정하기
a[2] = 4
print(a)    #출력 결과 : [1, 2, 4]

#리스트에서 연속된 범위의 값 수정하기
a[1:2] = ['a', 'b', 'c']    #a[1] = ['a', 'b', 'c']와 결과가 다름.
print(a)    #출력 결과 : [1, 'a', 'b', 'c', 4]

#[] 사용해 리스트 요소 삭제하기
a[1:3] = []
print(a)    #출력결과 : [1, 'c', 4]

#del 함수를 사용해 리스트 요소 삭제하기
del a[1]    
print(a)    #출력결과 : [1, 4]

#리스트에 요소 추가 : append()
a = [1, 2, 3]
a.append(4)
print(a)    #출력 결과 : [1, 2, 3, 4]
a.append([5, 6])
print(a)    #출력 결과 [1, 2, 3, 4, [5, 6]]

#리스트 정렬 : sort()
a = [1, 4, 3, 2]
a.sort()
print(a)    #출력 결과 : [1, 2, 3, 4]
b = ['a', 'c', 'b']
b.sort()
print(b)    #출력 결과 : ['a', 'b', 'c']

#리스트 뒤집기 : reverse() 
a = ['a', 'c', 'b']
a.reverse()
print(a)    #출력 결과 : ['b', 'c', 'a']

#위치 반환 : index()
a = [1, 2, 3]
print(a.index(3))   #출력 결과 : 2
print(a.index(1))   #출력 결과 : 0

#리스트에 요소 삽입 : insert()
a = [1, 2, 3]
a.insert(0, 4)  #a 리스트 0번째 위치에 4 삽입
print(a)    #출력 결과 : [4, 1, 2, 3]
a.insert(3, 5)  #a 리스트 3번째 위치에 5 삽입
print(a)    #출력 결과 : [4, 1, 2, 5, 3]

#리스트 요소 제거 : remove()
a = [1, 2, 3, 1, 2, 3]
a.remove(3) #a 리스트에서 3이 나오는 첫번째 요소 제거
print(a)    #출력 결과 : [1, 2, 1, 2, 3]
a.remove(3)
print(a)    #출력 결과 : [1, 2, 1, 2]

#리스트 요소 끄집어내기 : pop()
a = [1, 2, 3]
print(a.pop()) #리스트의 맨 마지막을 출력하고, 이후에 맨 마지막 요소 삭제. -> 출력 결과 : 3
print(a)    #출력 결과 : [1, 2]
a = [1, 2, 3]
print(a.pop(1)) #a 리스트에서 1번째 요소를 출력하고, 이후에 1번째 요소 삭제. -> 출력 결과 : 2
print(a)    #출력 결과 : [1, 3]

#리스트에 포함된 요소 x의 개수 세기 : count()
a = [1, 2, 3, 1]
print(a.count(1))  #a 리스트에 1 요소가 몇 개 있는지 카운트. -> 출력 결과 : 2

#리스트 확장 : extend()
a = [1, 2, 3]
a.extend([4, 5])    #a 리스트에 [4, 5] 리스트 더함. a+[4, 5]
print(a)    #출력 결과 : [1, 2, 3, 4, 5]
b = [6, 7]
a.extend(b) #a리스트+b리스트
print(a)    #출력 결과 : [1, 2, 3, 4, 5, 6, 7]