#pickle : 객체이 형태를 그대로 유지하면서 파일에 저장하고 불러올 수 있게 하는 모듈.
import pickle

#pickle 모듈의 dump 함수를 이용해 딕셔너리 객체인 data를 그대로 파일에 저장
f = open("test.txt", 'wb')
data = {1:'python', 2:'you need'}
pickle.dump(data, f)
f.close()

#pickle 모듈의 load 함수를 이용해 파일에서 데이터 불러오기
f = open("test.txt", 'rb')
data = pickle.load(f)
print(data)