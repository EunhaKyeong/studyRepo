'''
간단한 메모장 만들기
원하는 메모를 파일에 저장하고 추가 및 조회가 가능한 간단한 메모장을 만들어 보자.
'''
def notePad(name, mode):
    if mode=='w' or mode=='a':
        text = input("메모장에 작성할 내용을 입력해주세요\n")
        with open(name+".txt", mode) as f:
            f.write(text+"\n")
    elif mode=='r':
        with open(name+".txt", mode) as f:
            print(f.read())
    else:
        print("해당 모드는 지원하지 않는 모드입니다.")
        return

notePad("notePadTest", 'r')