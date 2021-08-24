package example.messages.simd;

import framework.Message;

public record DotProduct(int[] numberA,
                         int[] numbersB)  implements Message {

}
