package com.github.jinahya.assertj.more.time;

import java.time.Clock;

/**
 * An assert class for verifying values of {@link Clock}.
 *
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public class ClockAssert
        extends AbstractClockAssert<ClockAssert, Clock> {

    public static AbstractClockAssert<?, Clock> assertMore(final Clock actual) {
        return new ClockAssert(actual);
    }

    /**
     * Creates a new instance for verifying specified value.
     *
     * @param actual the actual value to verify.
     */
    public ClockAssert(final Clock actual) {
        super(actual, ClockAssert.class);
    }
}
