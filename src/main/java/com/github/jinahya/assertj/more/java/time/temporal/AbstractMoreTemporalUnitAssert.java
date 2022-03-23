package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.TemporalUnit;

/**
 * An abstract assert class for verifying values of {@link TemporalUnit}.
 *
 * @param <S> self type parameter.
 * @param <A> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractMoreTemporalUnitAssert<
        S extends AbstractMoreTemporalUnitAssert<S, A>,
        A extends TemporalUnit>
        extends AbstractAssert<S, A>
        implements MoreTemporalUnitAssert<S, A> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractMoreTemporalUnitAssert(final A actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
