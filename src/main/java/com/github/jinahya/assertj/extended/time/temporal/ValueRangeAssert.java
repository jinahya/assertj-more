package com.github.jinahya.assertj.extended.time.temporal;

import java.time.temporal.ValueRange;

public class ValueRangeAssert
        extends AbstractValueRangeAssert<ValueRangeAssert> {

    public static ValueRangeAssert assertThat(final ValueRange actual) {
        return new ValueRangeAssert(actual);
    }

    public ValueRangeAssert(final ValueRange actual) {
        super(actual, ValueRangeAssert.class);
    }
}
