 package youngjun.section01.lambda;

import java.util.function.IntConsumer;

public class LambdaExample {
    public static void main(String[] args) {
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.scopeCheck();
    }
    void scopeCheck() {
        int localScope = 10; // Local 변수

        // localScope 변수가 캡처(Capture) 됨
        // 익명 클래스(or 로컬 클래스)에서
        IntConsumer printInt = (num) -> System.out.println(num + localScope);
        printInt.accept(7);
    }
}
