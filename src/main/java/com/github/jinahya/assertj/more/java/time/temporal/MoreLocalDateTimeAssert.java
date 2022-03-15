package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoLocalDateTimeAssert;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface MoreLocalDateTimeAssert<S extends MoreLocalDateTimeAssert<S>>
        extends MoreTemporalAssert<S, LocalDateTime>,
                MoreChronoLocalDateTimeAssert<S, LocalDateTime, LocalDate> {

}
