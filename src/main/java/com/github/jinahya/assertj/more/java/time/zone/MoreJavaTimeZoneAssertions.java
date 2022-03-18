package com.github.jinahya.assertj.more.java.time.zone;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;

import java.time.ZoneId;
import java.time.zone.ZoneRules;

public class MoreJavaTimeZoneAssertions
        extends AbstractMoreAssertions {

    public static AbstractZoneIdAssert<?, ZoneId> assertMore(final ZoneId actual) {
        return new MoreZoneIdAssertImpl(actual);
    }

    public static AbstractZoneRulesAssert<?, ZoneRules> assertMore(final ZoneRules actual) {
        return ZoneRulesAssert.assertMore(actual);
    }

    protected MoreJavaTimeZoneAssertions() {
        super();
    }
}
