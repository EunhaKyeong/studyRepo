a = [1, 2, 3, 4]
result = [num*3 for num in a]
print(result)

result = [num*3 for num in a if num%2==0]
print(result)

result = [i*j for i in range(2, 10) for j in range(2, 10)]
print(result)