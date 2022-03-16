package com.github.jinahya.assertj.more.java.time.chrono;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public interface MoreZonedDateTimeAssert<S extends MoreZonedDateTimeAssert<S>>
        extends MoreJavaTimeChronoAssert<S, ZonedDateTime>,
                MoreChronoZonedDateTimeAssert<S, ZonedDateTime, LocalDate> {

}
