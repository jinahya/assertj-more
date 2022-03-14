package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.TemporalAmount;

/**
 * An abstract assert class for verifying values of {@link TemporalAmount}.
 *
 * @param <SELF>   self type parameter.
 * @param <ACTUAL> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractMoreTemporalAmountAssert<
        SELF extends AbstractMoreTemporalAmountAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalAmount>
        extends AbstractAssert<SELF, ACTUAL>
        implements MoreTemporalAmountAssert<SELF, ACTUAL> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractMoreTemporalAmountAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
