# @ForceInline 애너테이션 왜 쓸까

이펙티브자바 서적에 "아이템49. 매개변수가 유효한지 검사하라" 스터디 진행 중에 
Java9에서 추가된 Objects 클래스의 `checkIndex` 메서드를 확인해보다가 
처음보는 애너테이션이 있어 궁금증에 찾아보았다.

```java
// Object class (In openjdk-18.0.2.1)
@ForceInline
public static int checkIndex(int index, int length) {
    return Preconditions.checkIndex(index, length, null);
}
```

참고로 java 버전은 [openjdk-18.0.2.1](https://jdk.java.net/18/)이다.

## javadoc 읽어보기

> A method or constructor may be annotated as "force inline" if the standard inlining metrics are to be ignored when the HotSpot VM inlines the method or constructor.
>   
> This annotation must be used sparingly.  It is useful when the only reasonable alternative is to bind the name of a specific method or constructor into the HotSpot VM for special handling by the inlining policy.
>    
> This annotation must not be relied on as an alternative to avoid tuning the VM's inlining policy.
>   
> In a few cases, it may act as a temporary workaround until the profiling and inlining performed by the HotSpot VM is sufficiently improved.

- HotSpot VM이 메서드 또는 생성자를 인라인화할 때 표준 인라인 메트릭을 무시할 경우 메서드 또는 생성자에 "인라인화 강제"라는 주석을 달 수 있다.
- 최대한 사용하지 말아라.
  - Inline 정책에 의한 특별한 처리를 위해 HotSpot VM에 바인딩하는 것이 유일한 방법일 때 사용해라
- VM의 inlining 정책을 피하기 위한 대안으로 사용하면 안된다.
- 드문 경우에, HotSpot VM의 inlining이 개선될 때까지 임시 해결 방법으로 사용할 수 있다.

## Inline이란

- 코드 내부에 들어간 함수
- 성능때문에 보통 C++에서 많이 다뤘었다.
- 함수가 호출될 때마다 발생하는 오버헤드를 줄이기 위해 `inline` 키워드를 사용한다.
- 최근 C++ 컴파일러는 함수를 적절하게 inline 해주기 때문에 키워드 불필요

```c++
void PrintHello() {
    cout << "Hello, World!" << endl;
}

int main() {
    PrintHello();
    PrintHello();
    return 0;
}
```

위 코드를 inline 하면 아래와 같아진다.

```c++
int main() {
    cout << "Hello, World!" << endl;
    cout << "Hello, World!" << endl;
    return 0;
}
```

## Java에서의 inline

찾아보니 inline의 필요성과 동작방식에 대한 논의는 여러차례 stack overlow에서 다뤄졌다.

- https://stackoverflow.com/questions/1159087/inlining-in-java
- https://stackoverflow.com/questions/7744210/force-inline-in-java

결론은 함수 호출의 오버헤드까지 최적화하려 하지 말고, JIT 컴파일러의 최적화를 믿으면 될 것 같다.

## 그럼 왜 `@ForceInline`을 선언했나

설명이 있을까 싶어 Oracle docs와 baeldung, SOF를 찾아봤지만 궁금증을 해결하지 못했다.

- [Oracle java9](https://docs.oracle.com/javase/9/docs/api/java/util/Objects.html#checkIndex-int-int-)
- [Baeldung : Java 9 java.util.Objects Additions](https://www.baeldung.com/java-9-objects-new)

추측하기로는 HostSpot VM 최적화 과정에 성능 이점을 누리기 위한 조치일 것 같은데 정확한 이유는 모르겠다.

현재는 어떻게 더 조사하면 좋을지 잘 모르겠으니, [stack overflow에 질문](https://stackoverflow.com/questions/74502755/why-does-the-java-util-objects-checkindex-method-need-forceinline)을 남겼다.

답변이 오면 정리해보겠다.
