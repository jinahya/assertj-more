package com.github.jinahya.assertj.extended;

import com.github.jinahya.assertj.extended.time.temporal.AbstractTemporalAccessorAssert;
import com.github.jinahya.assertj.extended.time.temporal.AbstractValueRangeAssert;
import com.github.jinahya.assertj.extended.time.temporal.DefaultTemporalAccessorAssert;
import com.github.jinahya.assertj.extended.time.temporal.DefaultTemporalAssert;
import com.github.jinahya.assertj.extended.time.temporal.ValueRangeAssert;
import org.assertj.core.api.InstanceOfAssertFactories;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ValueRange;

public class MoreAssertions
        implements InstanceOfAssertFactories {

    public static AbstractTemporalAccessorAssert<?, TemporalAccessor> assertThat(final TemporalAccessor actual) {
        return DefaultTemporalAccessorAssert.assertThat(actual);
    }

    public static AbstractTemporalAccessorAssert<?, Temporal> assertThat(final Temporal actual) {
        return DefaultTemporalAssert.assertThat(actual);
    }

    public static AbstractValueRangeAssert<?> assertThat(final ValueRange actual) {
        return ValueRangeAssert.assertThat(actual);
    }

    protected MoreAssertions() {
        super();
    }
}
