package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.temporal.AbstractMoreTemporalAmountAssert;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.function.Function;

/**
 * An abstract assert class for verifying values of {@link Duration}.
 *
 * @param <S> self type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
abstract class AbstractTemporalAmountAssert_<S extends AbstractTemporalAmountAssert_<S, A>, A extends TemporalAmount>
        extends AbstractMoreTemporalAmountAssert<S, A> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractTemporalAmountAssert_(final A actual, final Class<?> selfType, final Class<A> actualType) {
        super(actual, selfType);
        this.actualType = Objects.requireNonNull(actualType, "actualType is null");
    }

    // ---------------------------------------------------------------------------------------------- minusDays(J)ACTUAL
    private A minusDays(final long daysToSubtract) {
        try {
            return actualType.cast(
                    actualType.getMethod("minusDays", long.class)
                            .invoke(actual, daysToSubtract)
            );
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    protected <R> R minusDays(
            long daysToSubtract,
            final Function<? super S, ? extends Function<? super A, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(minusDays(daysToSubtract));
    }

//    // ------------------------------------------------------------------------------------------- multipliedBy(I)ACTUAL
//    private ACTUAL multipliedBy(final long arg) {
//        try {
//            return actualType.cast(
//                    actualType.getMethod("multipliedBy", int.class)
//                            .invoke(actual, arg)
//            );
//        } catch (final ReflectiveOperationException roe) {
//            throw new RuntimeException(roe);
//        }
//    }
//
//    protected <R> R multipliedBy(
//            final int arg,
//            final Function<? super SELF, ? extends Function<? super ACTUAL, ? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(multipliedBy(arg));
//    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<A> actualType;
}
