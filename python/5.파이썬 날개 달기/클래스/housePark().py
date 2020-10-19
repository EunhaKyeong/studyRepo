class HousePark():
    lastname = '박'

    def __init__(self, name):
        self.fullname = self.lastname + name
        
    def setname(self, name):
        self.fullname = self.lastname + name
        return self.fullname
    def travel(self, region):
        print("%s, %s여행을 가다." %(self.fullname, region))
    def love(self, other):
        print("%s, %s 사랑에 빠졌네" %(self.fullname, other.fullname))
    #연산자 오버로딩(+연산자) : __add__ 내장 함수 사용.
    def __add__(self, other):
        print("%s, %s 결혼했네" %(self.fullname, other.fullname))
    def fight(self, other):
        print("%s, %s 싸우네" %(self.fullname, other.fullname))
    #연산자 오버로딩(-연산자) : __sub__ 내장 함수 사용.
    def __sub__(self, other):
        print("%s, %s 이혼했네" %(self.fullname, other.fullname))
    
pey = HousePark("응용")
pey.travel("부산")

#상속:박씨네 집에서 김씨네 집으로
class HouseKim(HousePark):
    lastname = '김'

    #method overriding
    def travel(self, region, day):
        print("%s, %s여행 %d일 가네." %(self.fullname, region, day))

juliet = HouseKim("줄리엣")
juliet.travel("독도", 3)

pey.love(juliet)
pey + juliet

'''
[이야기 완성하기]
박응용은 부산에 놀러 가고
김줄리엣도 우연히 3일 동안 부산에 놀러 간다.
둘은 사랑에 빠져서 결혼하게 된다.
그러다가 바로 싸우고 이혼을 하게 된다.
'''
print("\n==================이야기 시작!=====================")
park = HousePark("응용")
park.travel("부산")
kim = HouseKim("줄리엣")
kim.travel("부산", 3)
park.love(kim)
park + kim
park.fight(kim)
park - kim
print("====================이야기 끝!===================")