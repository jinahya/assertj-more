package com.github.jinahya.assertj.more.java.time;

import java.time.Duration;

/**
 * An assertion class for verifying values of {@link Duration}.
 *
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 * @see org.assertj.core.api.DurationAssert
 */
public class DurationAssert
        extends AbstractDurationAssert<DurationAssert> {

    /**
     * Creates a new instance for verifying specified value.
     *
     * @param actual the actual value to verify.
     */
    DurationAssert(final Duration actual) {
        super(actual, DurationAssert.class);
    }
}
