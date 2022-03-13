package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.TemporalUnit;

/**
 * An abstract assert class for verifying values of {@link TemporalUnit}.
 *
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public class DefaultTemporalUnitAssert
        extends AbstractMoreTemporalUnitAssert<DefaultTemporalUnitAssert, TemporalUnit> {

    public static AbstractMoreTemporalUnitAssert<?, TemporalUnit> assertMore(final TemporalUnit actual) {
        return new DefaultTemporalUnitAssert(actual);
    }

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual the actual value to verify.
     */
    public DefaultTemporalUnitAssert(final TemporalUnit actual) {
        super(actual, DefaultTemporalUnitAssert.class);
    }
}
