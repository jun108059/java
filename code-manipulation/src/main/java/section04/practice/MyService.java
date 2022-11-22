package section04.practice;

public class MyService {
    @MyAnnotation
    public void method1() {
        System.out.println("실행내용1");
    }
    @MyAnnotation("*")
    public void method2() {
        System.out.println("실행내용2");
    }
    @MyAnnotation(value = "*", number = 20)
    public void method3() {
        System.out.println("실행내용3");
    }
}