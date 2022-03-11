package com.github.jinahya.assertj.more.time.temporal;

import org.assertj.core.api.AbstractAssert;

import java.time.temporal.TemporalUnit;

/**
 * An abstract assert class for verifying values of {@link TemporalUnit}.
 *
 * @param <SELF>   self type parameter.
 * @param <ACTUAL> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractTemporalUnitAssert<
        SELF extends AbstractTemporalUnitAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalUnit
        >
        extends AbstractAssert<SELF, ACTUAL> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractTemporalUnitAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
