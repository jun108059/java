package youngjun.section01.util;

import java.util.function.Function;

public class FunctionExample implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
