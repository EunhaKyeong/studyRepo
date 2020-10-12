#딕셔너리 자료형
#딕셔너리는 Key와 Value를 한 쌍으로 갖는 자료형이다.
#딕셔너리는 Key를 통해 Value를 얻는다.
#딕셔너리는 순서를 따지지 않는다.
#딕셔너리에서는 중복되는 Key를 사용하지 말아야 함.
#딕셔너리에서 value값으로 리스트 자료형을 가질 수 있지만 key에서는 불가능함.

#딕셔너리 쌍 추가하기
a = {1:'a'}
a[2] = 'b'  #{2:'b'} 쌍 추가
print(a)    #출력 결과 : {1:'a', 2:'b'}
a['name'] = 'pey'
print(a)    #출력 결과 : {1:'a', 2:'b', 'name':'pey'}
a[3] = [1, 2, 3]
print(a)    #출력 결과 : {1:'a', 2:'b', 'name':'pey', 3:[1, 2, 3]}

#딕셔너리 요소 삭제하기
del a[1]    #a 딕셔너리에서 key가 1인 요소 삭제
print(a)    #출력 결과 : {2:'b', 'name':'pey', 3:[1, 2, 3]}

#딕셔너리에서 Key 사용해 Value 얻기
grade = {'pey':10, 'juliet':99}
print(grade['pey']) #key가 pey인 요소의 value 출력->출력 결과 : 10
print(grade['juliet'])  #출력 결과 : 99

a = {'name':'pey', 'phone':'0119993323', 'birth':'1118'}
#Key 리스트 만들기 : keys()
print(a.keys()) #a 딕셔너리에 존재하는 key값을 리스트 형식으로 출력.->출력 결과 : dict_keys(['name', 'phone', 'birth'])
print(list(a.keys()))   #완전한 list 자료형으로 출력하기 위해서는 list()를 이용하여 형 변환.->출력 결과 : ['name', 'phone', 'birth']

#Value 리스트 만들기 : values()
print(a.values())   #value값만 모아서 출력.->출력 결과 : dict_values(['pey', '0119993323', '1118'])
print(list(a.values())) #value값만 모아서 리스트 형태로 출력하고 싶으면 list()를 이용해 형 변환.->출력 결과 : ['pey', '0119993323', '1118']

#Key, Value 쌍 얻기 : items()
print(a.items())    #key와 value의 쌍을 튜플로 묶은 값을 dict_items 객체로 반환.->출력 결과 : dict_items([('name', 'pey'), ('phone', '0119993323'), ('birth', '1118')])

#Key, Value 쌍 모두 지우기 : clear()
a.clear()
print(a)    #출력 결과 : {}

a = {'name':'pey', 'phone':'0119993323', 'birth':'1118'}
#Key로 Value 얻기 : get()
print(a.get('name'))    #key값인 name의 value를 출력.->출력 결과 : 'pey'
print(a.get('phone'))   #출력 결과 : '0119993323'

#print(a['nokey'])와 print(a.get('nokey'))의 차이
#print(a['nokey'])  #key 오류
print(a.get('nokey'))   #출력 결과 : None 리턴
print(a.get('foo', 'bar'))  #a 딕셔너리에 foo라는 key값이 없으면 None 대신에 bar를 출력(디폴트값 지정).->출력 결과 : 'bar'

#해당 Key가 딕셔너리 안에 있는지 조사하기 : in
print('name' in a)  #a 딕셔너리에 'name'이란 key가 존재하면 True, 아니면 False.->출력 결과 : True
print('email' in a) #출력 결과 : False