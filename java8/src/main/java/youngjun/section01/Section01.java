package youngjun.section01;

/**
 * 자바에서 제대로 함수형 프로그래밍을 하기 위해 주의해야 할 포인트
 * <p>
 * 1. 함수형 인터페이스와 람다 표현식은 함수형 프로그래밍과 상관없이 사용 가능
 * 2. 순수 함수(Side-effect 없고, 상태가 없음)로 만들자
 * 3. 불변성을 보장하자
 */
public class Section01 {
    public static void main(String[] args) {

        // [1-1] 익명 내부 클래스(anonymous inner class)
        FunctionalInterfaceExample example = new FunctionalInterfaceExample() {
            @Override
            public void doIt() {
                System.out.println("Anonymous Inner Class");
            }
        };

        // [1-2] 람다 표현식
        FunctionalInterfaceExample example2 = () -> System.out.println("Lambda");

        // [1-3] 함수를 First class object로 받기 때문에 객체의 메서드 호출 가능
        example2.doIt();

        // [1-4] 항상 같은 값 return 보장(불변성)
        example2.doIt();

        // [1-5] 불변성을 보장하지 않는 경우(상태값에 의존한다)
        String outScopeOne = "External";
        FunctionalInterfaceExample example3 = new FunctionalInterfaceExample() {
            String outScopeTwo = "Second External";

            @Override
            public void doIt() {
                System.out.println(outScopeOne + outScopeTwo);
            }
        };

        // [1-6] 불변성을 보장하지 않는 경우 두번째(외부 값을 변경)
        FunctionalInterfaceExample example4 = new FunctionalInterfaceExample() {
            String status = "Second External"; // 외부 값

            @Override
            public void doIt() {
                status = "Change"; // 외부 값을 변경(불변성 보장x)
                System.out.println(status);
            }
        };

    }
}
