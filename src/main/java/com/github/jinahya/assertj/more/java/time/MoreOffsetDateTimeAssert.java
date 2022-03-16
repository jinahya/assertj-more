package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAccessorAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;

import java.time.OffsetDateTime;

public interface MoreOffsetDateTimeAssert<S extends MoreOffsetDateTimeAssert<S>>
        extends MoreJavaTimeAssert<S, OffsetDateTime>,
                MoreTemporalAccessorAssert<S, OffsetDateTime>,
                MoreTemporalAdjusterAssert<S, OffsetDateTime> {

}
