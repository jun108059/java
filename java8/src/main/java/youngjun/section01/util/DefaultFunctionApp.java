package youngjun.section01.util;

import java.util.function.Function;

/**
 * 기본 제공 함수형 인터페이스 예제
 */
public class DefaultFunctionApp {
    public static void main(String[] args) {

        /*
          [1] Function<T, R> -> apply 함수 활용
         */
        // [1-1] 함수형 인터페이스 활용
        FunctionExample functionExample = new FunctionExample();
        Integer applyByFunctionalInterface = functionExample.apply(10);
        assert applyByFunctionalInterface == 20;

        // [1-2] 람다 활용
        Function<Integer, Integer> plus10 = (num) -> num + 10;
        Integer applyByLambda = plus10.apply(10);
        assert applyByLambda == 20;

        // [1-3] 함수 조합 - andThen & compose
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        multiply2AndPlus10.apply(2); // 14

        plus10.compose(multiply2).apply(2); // 14

    }
}
