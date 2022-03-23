package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.TemporalAmount;

/**
 * An abstract assert class for verifying values of {@link TemporalAmount}.
 *
 * @param <S> self type parameter.
 * @param <A> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractMoreTemporalAmountAssert<
        S extends AbstractMoreTemporalAmountAssert<S, A>,
        A extends TemporalAmount>
        extends AbstractAssert<S, A>
        implements MoreTemporalAmountAssert<S, A> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractMoreTemporalAmountAssert(final A actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
