package example.messages.simd;


import framework.Message;

public record DotProductFailure(String reason)  implements Message {
}
