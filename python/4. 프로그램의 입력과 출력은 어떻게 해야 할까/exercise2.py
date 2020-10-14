#연습문제2.
#오른쪽과 같이 총 10줄로 이루어진 sample.txt 파일이 있다. 
# sample.txt 파일의 숫자값을 모두 읽어 총합과 평균값을 구한 후 평균값을 result.txt라는 파일에 쓰는 프로그램을 작성해 보자.

sum = 0

f = open("sample.txt", 'r')
nums = f.readlines()
for num in nums:
    sum += int(num)
f.close()
avg = sum / len(nums)

f = open("result.txt", 'w')
f.write(str(avg))
f.close()