package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;

public interface MoreChronoLocalDateTimeAssert<
        S extends MoreChronoLocalDateTimeAssert<S, A, D>,
        A extends ChronoLocalDateTime<D>,
        D extends ChronoLocalDate>
        extends MoreJavaTimeChronoAssert<S, A>,
                MoreTemporalAssert<S, A>,
                MoreTemporalAdjusterAssert<S, A> {

}
