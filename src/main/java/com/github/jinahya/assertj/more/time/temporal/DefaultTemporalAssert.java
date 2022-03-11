package com.github.jinahya.assertj.more.time.temporal;

import java.time.temporal.Temporal;

/**
 * A default assert class for verifying values of {@link Temporal}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class DefaultTemporalAssert
        extends AbstractTemporalAssert<DefaultTemporalAssert, Temporal> {

    public static AbstractTemporalAssert<?, Temporal> assertMore(final Temporal actual) {
        return new DefaultTemporalAssert(actual);
    }

    public DefaultTemporalAssert(final Temporal actual) {
        super(actual, DefaultTemporalAssert.class);
    }
}
