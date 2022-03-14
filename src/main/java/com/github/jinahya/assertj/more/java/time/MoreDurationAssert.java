package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAmountAssert;

import java.time.Duration;

public interface MoreDurationAssert<SELF extends MoreDurationAssert<SELF>>
        extends MoreJavaTimeAssert<SELF, Duration>,
                MoreTemporalAmountAssert<SELF, Duration> {

}
