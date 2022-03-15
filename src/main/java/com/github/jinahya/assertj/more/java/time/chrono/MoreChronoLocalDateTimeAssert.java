package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;

public interface MoreChronoLocalDateTimeAssert<
        SELF extends MoreChronoLocalDateTimeAssert<SELF, ACTUAL, D>,
        ACTUAL extends ChronoLocalDateTime<D>,
        D extends ChronoLocalDate>
        extends MoreJavaTimeChronoAssert<SELF, ACTUAL>,
                MoreTemporalAssert<SELF, ACTUAL>,
                MoreTemporalAdjusterAssert<SELF, ACTUAL> {

}
