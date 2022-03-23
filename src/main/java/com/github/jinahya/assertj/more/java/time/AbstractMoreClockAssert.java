package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractAssert;

import java.time.Clock;

/**
 * An abstract assert class for verifying values of {@link Clock}.
 *
 * @param <S> self type parameter.
 * @param <A> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractMoreClockAssert<S extends AbstractMoreClockAssert<S, A>, A extends Clock>
        extends AbstractAssert<S, A>
        implements MoreClockAssert<S, A> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractMoreClockAssert(final A actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
