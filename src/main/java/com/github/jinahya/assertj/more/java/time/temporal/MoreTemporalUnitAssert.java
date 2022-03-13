package com.github.jinahya.assertj.more.java.time.temporal;

import java.time.temporal.TemporalUnit;

public interface MoreTemporalUnitAssert<
        SELF extends MoreTemporalUnitAssert<SELF, ACTUAL>,
        ACTUAL extends TemporalUnit>
        extends MoreJavaTimeTemporalAssert<SELF, ACTUAL> {

}
