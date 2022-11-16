 package youngjun.section01;

/**
 * 함수형 인터페이스(추상 메서드 하나만 존재)
 * 정적 메서드 or 기본 메서드를 가질 수 있음
 */
@FunctionalInterface
public interface FunctionalInterfaceExample {

    /**
     * 추상 메서드(abstract 생략)
     */
    void doIt();

    /**
     * 정적 메서드 가능(java8에서 추가)
     */
    static void printName() {
        System.out.println("YoungJun");
    }

    /**
     * 기본 메서드 가능(java8에서 추가)
     */
    default void printAge() {
        System.out.println("28");
    }
}
