'''
연습문제1. 문자열 압축하기
문자열을 입력 받아 같은 문자가 연속적으로 반복되는 경우에 그 반복 횟수를 표시해 문자열을 압축하여 표시해 보자.
>>입력예시:aaabbcccccca
>>출력예시:a3b2c6a1
'''
def compressStr(text):
    result = ""
    ch = text[0]
    cnt = 1
    for i in range(1, len(text)):
        if ch==text[i]:
            cnt += 1
        else:
            result = result + ch + str(cnt)
            ch = text[i]
            cnt = 1
    result = result + ch + str(cnt)
    return result

print(compressStr('aaabbcccccca'))