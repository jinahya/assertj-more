package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractAssert;

import java.time.Clock;

/**
 * An assertion class for verifying values of {@link Clock}.
 *
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
class DefaultMoreClockAssert
        extends AbstractAssert<DefaultMoreClockAssert, Clock>
        implements MoreClockAssert<DefaultMoreClockAssert, Clock> {

    /**
     * Creates a new instance for verifying specified value.
     *
     * @param actual the actual value to verify.
     */
    DefaultMoreClockAssert(final Clock actual) {
        super(actual, DefaultMoreClockAssert.class);
    }
}
