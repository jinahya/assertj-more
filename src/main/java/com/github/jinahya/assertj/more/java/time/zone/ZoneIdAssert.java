package com.github.jinahya.assertj.more.java.time.zone;

import java.time.ZoneId;

/**
 * An assertion class for verifying values of {@link ZoneId}.
 *
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public class ZoneIdAssert
        extends AbstractZoneIdAssert<ZoneIdAssert, ZoneId> {

    public static AbstractZoneIdAssert<?, ZoneId> assertMore(final ZoneId actual) {
        return new ZoneIdAssert(actual);
    }

    /**
     * Creates a new instance for verifying specified value.
     *
     * @param actual the actual value to verify.
     */
    public ZoneIdAssert(final ZoneId actual) {
        super(actual, ZoneIdAssert.class);
    }
}
