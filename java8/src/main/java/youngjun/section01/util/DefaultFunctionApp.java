package youngjun.section01.util;

import java.util.function.*;

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
        plus10.andThen(multiply2).apply(2); // 24

        /*
          [2] BiFunction<T, U, R> -> apply 함수 활용
         */
        // [2-1] 함수형 인터페이스 활용
        BiFunctionExample biFunctionExample = new BiFunctionExample();
        biFunctionExample.apply(12, 23); // 35

        // [2-2] 람다 활용
        BiFunction<Integer, Integer, Integer> plusTwoNumber = (num1, num2) -> num1 + num2;
        plusTwoNumber.apply(12, 23); // 35

        // [2-3] 함수 조합 - andThen
        plusTwoNumber.andThen(plus10).apply(12, 23); // 45

        /*
          [3] Consumer<T> -> accept 활용
         */
        Consumer<Integer> printT = (num) -> System.out.println("Consumer print : " + num);
        printT.accept(15); // 15

        /*
          [4] Supplier<T> -> get 활용
         */
        Supplier<Integer> get10 = () -> 10;
        get10.get(); // 10

        /*
          [5] Predicate<T> -> test 활용
         */
        // [5-1] 람다 활용(test 메서드)
        Predicate<String> startsWithPark = (str) -> str.startsWith("Park");
        startsWithPark.test("Park YoungJun");// true (boolean)
        startsWithPark.test("ABC");// false (boolean)

        // [5-2] 함수 조합 - And, Or, Negate
        Predicate<String> stringLengthIs13 = (str) -> str.length() == 13;
        startsWithPark.and(stringLengthIs13).test("Park YoungJun"); // true
        startsWithPark.and(stringLengthIs13).test("Park YoungJun22"); // false
        startsWithPark.or(stringLengthIs13).test("Park YoungJun22"); // true

        Predicate<String> negate = startsWithPark.negate();
        negate.test("Park YoungJun"); // false

        /*
          [6] UnaryOperator<T> - Function<T, R>의 T, R이 동일 타입인 경우
         */
        UnaryOperator<Integer> plus20 = (num) -> num + 20;
        plus20.apply(3); // 23

        /*
          [7] BinaryOperator<T> - BiFunction<T, U, R>의 T, U, R이 동일 타입인 경우
         */
        BinaryOperator<Integer> plusTwoNumbers = (num1, num2) -> num1 + num2;
        plusTwoNumbers.apply(3, 9); // 12

    }
}
