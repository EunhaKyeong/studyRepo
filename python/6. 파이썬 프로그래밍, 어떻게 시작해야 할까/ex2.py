'''
연습문제2. Duplicate Numbers
0~9까지의 문자로 된 숫자를 입력받았을 때, 이 입력값이 0~9까지의 모든 숫자가 각각 한 번씩만 사용된 것인지 확인하는 함수를 작성해 보자.
>>입력예시:01234567789 01234 01234567890 6789012345 012322456789
>>출력예시:true false false true false
'''
def dupNumbers(number):
    print(''.join(sorted(number)))
    if ''.join(sorted(number))=='0123456789':
        return True
    else:
        return False

print(dupNumbers('6789012345'))