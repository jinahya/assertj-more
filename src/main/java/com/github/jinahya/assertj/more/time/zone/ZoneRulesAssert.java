package com.github.jinahya.assertj.more.time.zone;

import java.time.zone.ZoneRules;

/**
 * An abstract assert class for verifying values of {@link ZoneRules}.
 *
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public class ZoneRulesAssert
        extends AbstractZoneRulesAssert<ZoneRulesAssert, ZoneRules> {

    public static AbstractZoneRulesAssert<?, ZoneRules> assertMore(final ZoneRules actual) {
        return new ZoneRulesAssert(actual);
    }

    /**
     * Creates a new instance for verifying specified value.
     *
     * @param actual the actual value to verify.
     */
    protected ZoneRulesAssert(final ZoneRules actual) {
        super(actual, ZoneRulesAssert.class);
    }
}
