package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.api.ComparableAssertProxy;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAccessorAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;

import java.time.OffsetTime;

public interface MoreOffsetTimeAssert<S extends MoreOffsetTimeAssert<S>>
        extends MoreJavaTimeAssert<S, OffsetTime>,
                ComparableAssertProxy<S, OffsetTime>,
                MoreTemporalAccessorAssert<S, OffsetTime>,
                MoreTemporalAdjusterAssert<S, OffsetTime> {

}
