package com.github.jinahya.assertj.more.java.time.chrono;

import com.github.jinahya.assertj.more.api.ComparableAssertProxy;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAccessorAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoZonedDateTime;

public interface MoreChronoZonedDateTimeAssert<
        S extends MoreChronoZonedDateTimeAssert<S, A, D>,
        A extends ChronoZonedDateTime<D>,
        D extends ChronoLocalDate>
        extends MoreJavaTimeChronoAssert<S, A>,
                ComparableAssertProxy<S, ChronoZonedDateTime<?>>,
                MoreTemporalAssert<S, A>,
                MoreTemporalAccessorAssert<S, A> {

}
