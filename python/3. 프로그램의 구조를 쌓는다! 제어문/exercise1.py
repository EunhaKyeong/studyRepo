#연습문제1. 다음 코드의 결과값은 무엇일까?
a = "Life is too short, you nee python"

if "wife" in a:
    print("wife")
elif "python" in a and "you" not in a:
    print("python")
elif "shirt" not in a:
    print("shirt")
elif "need" in a:
    print("need")
else:
    print("none")

#답 : shirt