package example.actors;

import example.messages.simd.DotProduct;
import example.messages.simd.DotProductFailure;
import example.messages.simd.DotProductResult;
import framework.Actor;
import framework.Message;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;

import java.util.UUID;

public class SIMDTest extends Actor {

    @Override
    public void onMessage(Message message, UUID senderId) {
        if(message instanceof DotProduct dotProduct) {

            if(dotProduct.numberA().length != dotProduct.numbersB().length) {
                sendMessage(new DotProductFailure("Bad input"), senderId);
            } else {
                long l = System.nanoTime();
                long simdResult = simpdVersion(dotProduct.numberA(), dotProduct.numbersB());
                long simdDuration = System.nanoTime() - l;

                long l2 = System.nanoTime();
                long regResult = dotProduct(dotProduct.numberA(), dotProduct.numbersB());
                long regDuration = System.nanoTime() - l2;

                sendMessage(
                        new DotProductResult(simdResult, simdDuration, regResult, regDuration),
                        senderId
                );
            }
        }
    }


    @SuppressWarnings("IntegerMultiplicationImplicitCastToLong")
    private static long dotProduct(int[] numbersA, int[] numbersB) {
        var result = 0L;
        for (var i = 0; i < numbersA.length; i++) {
            result += (numbersA[i] * numbersB[i]);
        }
        return result;
    }

    private static long simpdVersion(int[] numbersA, int[] numbersB) {
        VectorSpecies<Integer> species = IntVector.SPECIES_PREFERRED;
        var result = 0L;
        for (var i = 0; i < numbersA.length; i += species.length()) {
            var a = IntVector.fromArray(species, numbersA, i);
            var b = IntVector.fromArray(species, numbersB, i);
            result += a.mul(b).reduceLanesToLong(VectorOperators.ADD);
        }
        return result;
    }
}
