package com.github.jinahya.assertj.more;

import com.github.jinahya.assertj.more.time.AbstractClockAssert;
import com.github.jinahya.assertj.more.time.ClockAssert;
import com.github.jinahya.assertj.more.time.temporal.AbstractTemporalAccessorAssert;
import com.github.jinahya.assertj.more.time.temporal.AbstractTemporalAssert;
import com.github.jinahya.assertj.more.time.temporal.AbstractValueRangeAssert;
import com.github.jinahya.assertj.more.time.temporal.DefaultTemporalAccessorAssert;
import com.github.jinahya.assertj.more.time.temporal.DefaultTemporalAssert;
import com.github.jinahya.assertj.more.time.temporal.ValueRangeAssert;
import com.github.jinahya.assertj.more.time.zone.AbstractZoneIdAssert;
import com.github.jinahya.assertj.more.time.zone.AbstractZoneRulesAssert;
import com.github.jinahya.assertj.more.time.zone.ZoneIdAssert;
import com.github.jinahya.assertj.more.time.zone.ZoneRulesAssert;
import org.assertj.core.api.InstanceOfAssertFactories;

import java.time.Clock;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ValueRange;
import java.time.zone.ZoneRules;

public class MoreAssertions
        implements InstanceOfAssertFactories {

    // ----------------------------------------------------------------------------------------------------------- .time
    public static AbstractClockAssert<?, Clock> assertMore(final Clock actual) {
        return ClockAssert.assertMore(actual);
    }

    // -------------------------------------------------------------------------------------------------- .time.temporal
    public static AbstractTemporalAccessorAssert<?, TemporalAccessor> assertMore(final TemporalAccessor actual) {
        return DefaultTemporalAccessorAssert.assertMore(actual);
    }

    public static AbstractTemporalAssert<?, Temporal> assertMore(final Temporal actual) {
        return DefaultTemporalAssert.assertMore(actual);
    }

    public static AbstractValueRangeAssert<?> assertMore(final ValueRange actual) {
        return ValueRangeAssert.assertMore(actual);
    }

    // ------------------------------------------------------------------------------------------------------ .time.zone
    public static AbstractZoneIdAssert<?, ZoneId> assertMore(final ZoneId actual) {
        return ZoneIdAssert.assertMore(actual);
    }

    public static AbstractZoneRulesAssert<?, ZoneRules> assertMore(final ZoneRules actual) {
        return ZoneRulesAssert.assertMore(actual);
    }

    protected MoreAssertions() {
        super();
    }
}
