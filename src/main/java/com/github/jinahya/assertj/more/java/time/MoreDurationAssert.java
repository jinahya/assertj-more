package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAmountAssert;

import java.time.Duration;

public interface MoreDurationAssert<S extends MoreDurationAssert<S>>
        extends MoreJavaTimeAssert<S, Duration>,
                MoreTemporalAmountAssert<S, Duration> {

}
