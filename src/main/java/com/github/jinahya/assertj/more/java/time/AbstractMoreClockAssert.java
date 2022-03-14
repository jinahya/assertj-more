package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractAssert;

import java.time.Clock;

/**
 * An abstract assert class for verifying values of {@link Clock}.
 *
 * @param <SELF>   self type parameter.
 * @param <ACTUAL> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractMoreClockAssert<SELF extends AbstractMoreClockAssert<SELF, ACTUAL>, ACTUAL extends Clock>
        extends AbstractAssert<SELF, ACTUAL>
        implements MoreClockAssert<SELF, ACTUAL> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractMoreClockAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
