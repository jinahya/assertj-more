package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.chrono.MoreChronoZonedDateTimeAssert;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public interface MoreZonedDateTimeAssert<S extends MoreZonedDateTimeAssert<S>>
        extends MoreJavaTimeAssert<S, ZonedDateTime>,
                MoreChronoZonedDateTimeAssert<S, ZonedDateTime, LocalDate> {

}
