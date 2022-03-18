package com.github.jinahya.assertj.more.java.time.zone;

import java.time.ZoneId;

/**
 * An assertion class for verifying values of {@link ZoneId}.
 *
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
class MoreZoneIdAssertImpl
        extends AbstractZoneIdAssert<MoreZoneIdAssertImpl, ZoneId> {

    /**
     * Creates a new instance for verifying specified value.
     *
     * @param actual the actual value to verify.
     */
    MoreZoneIdAssertImpl(final ZoneId actual) {
        super(actual, MoreZoneIdAssertImpl.class);
    }
}
