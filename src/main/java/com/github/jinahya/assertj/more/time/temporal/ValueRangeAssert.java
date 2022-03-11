package com.github.jinahya.assertj.more.time.temporal;

import java.time.temporal.ValueRange;

public class ValueRangeAssert
        extends AbstractValueRangeAssert<ValueRangeAssert> {

    public static ValueRangeAssert assertMore(final ValueRange actual) {
        return new ValueRangeAssert(actual);
    }

    public ValueRangeAssert(final ValueRange actual) {
        super(actual, ValueRangeAssert.class);
    }
}
