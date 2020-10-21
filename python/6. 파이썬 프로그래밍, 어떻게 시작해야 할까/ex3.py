'''
연습문제3. 모스 부호 해독
문자열 형식으로 입력받은 모스 부호(dot: . dash:-)를 해독하여 영어 문장으로 출력하는 프로그램을 작성해보자.
글자와 글자 사이는 공백 1개, 단어와 단어 사이는 공백 2개로 구분한다.
'''
morse_code = {'.-':'A', '-...':'B', '-.-.':'C', '-..':'D', '.':'E', '..-.':'F', '--.':'G', '....':'H', '..':'I', '.---':'J', '-.-':'K', '.-..':'L', '--':'M', 
            '-.':'N', '---':'O', '.--.':'P', '--.-':'Q', '.-.':'R', '...':'S', '-':'T', '..-':'U', '...-':'V', '.--':'W', '-..-':'X', '-.--':'Y', '--..':'Z'}
def decipherMorse(morse):
    morse = morse.split("  ")
    morse = [m.split() for m in morse]
    result = ""
    for word in morse:
        for ch in word:
            result += morse_code.get(ch)
        result += " "

    return result

print(decipherMorse('.... .  ... .-.. . . .--. ...  . .- .-. .-.. -.--'))