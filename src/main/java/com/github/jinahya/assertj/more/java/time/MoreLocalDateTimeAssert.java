package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoLocalDateTimeAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface MoreLocalDateTimeAssert<S extends MoreLocalDateTimeAssert<S>>
        extends MoreJavaTimeAssert<S, LocalDateTime>,
                MoreChronoLocalDateTimeAssert<S, LocalDateTime, LocalDate>,
                MoreTemporalAssert<S, LocalDateTime> {

}
