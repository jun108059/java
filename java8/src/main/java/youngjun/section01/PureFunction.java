package youngjun.section01;

/**
 * 순수 함수 : 동일 입력 -> 동일 출력 보장
 */
@FunctionalInterface
public interface PureFunction {
    int doIt(int number);
}