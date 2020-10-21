#sorted() 함수 : 입력값을 정렬한 후 결과를 리스트로 리턴하는 함수.
print(sorted([3, 1, 2]))    #출력결과:[1, 2, 3]
print(sorted(['a', 'c', 'b']))    #출력결과:['a', 'b', 'c']
print(sorted("zero"))   #sorted함수는 결과를 리스트로 리턴하기 때문에 출력결과는 ['e', 'o', 'r', 'z']이다.
print(sorted((3, 2, 1)))    #입력값은 튜플이지만 sorted 함수는 결과값을 리스트로 리턴하기 때문에 (1, 2, 3)이 아닌 [1, 2, 3]이 리턴됨.

#리스트 자료형의 sort() 함수와 sorted() 함수의 차이점
#sort() 함수와 sorted() 함수 모두 정렬을 해주는 함수이지만 sort() 함수는 오직 리스트만 가능하고 정렬된 결과를 리턴하지 않음.
a = [3, 1, 2]
sort_result = a.sort()
sorted_result = sorted(a)
print(sort_result)  #출력결과:None
print(sorted_result)    #출력결과:[1, 2, 3]