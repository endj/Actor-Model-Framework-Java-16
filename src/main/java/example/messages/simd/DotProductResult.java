package example.messages.simd;


import framework.Message;

import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public record DotProductResult(long resultSimd, long durationSimd, long resultReg, long durationRegular) implements Message {
    @Override
    public String toString() {
        return new StringJoiner(", ", DotProductResult.class.getSimpleName() + "[", "]")
                .add("simd: "+ resultSimd)
                .add("regular: "+ resultReg)
                .add("durationSimd Ms=" + TimeUnit.NANOSECONDS.toMillis(durationSimd))
                .add("durationRegular  Ms=" + TimeUnit.NANOSECONDS.toMillis(durationRegular))
                .toString();
    }
}
