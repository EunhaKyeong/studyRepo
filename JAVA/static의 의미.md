1. **정적**, 즉 **고정된**이란 의미.
2. static은 객체(=인스턴스)에 소속된 것이 아니라 **클래스에 고정**됨.
3. 클래스에 고정돼 있다 보니 **해당 클래스에 속한 모든 인스턴스는 static 필드 or static 메서드를 공유함.**
<br><br>

예시
```
// Static.class
public class Static {
    static int num1 = 0;
    public int num2 = 0;
}
```
```
// Static_study.class
public class Static_study {
    public static void main(String[] args) {
        Static s1 = new Static();
        Static s2 = new Static();

        s1.num1++;
        s1.num1++;

        System.out.println(s1.num1);
        System.out.println(s1.num2);
        System.out.println(s2.num1);
        System.out.println(s2.num2);
    }
}
```
출력결과
```
1
1
1
0
```
<br>

[출처](https://coding-factory.tistory.com/524)