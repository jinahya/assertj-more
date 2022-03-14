package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAdjusterAssert;
import com.github.jinahya.assertj.more.java.time.temporal.MoreTemporalAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.Instant;

public interface MoreInstantAssert<SELF extends MoreInstantAssert<SELF>>
        extends MoreJavaTimeAssert<SELF, Instant>,
                MoreTemporalAssert<SELF, Instant>,
                MoreTemporalAdjusterAssert<SELF, Instant> {

    // ----------------------------------------------------------------------------------------------- getEpochSecond()J
    default AbstractLongAssert<?> extractingEpochSecond() {
        return MoreInstantAssertHelper.getEpochSecond((SELF) this, s -> Assertions::assertThat);
    }

    default SELF hasEpochSecond(final long expected) {
        return MoreInstantAssertHelper.getEpochSecond((SELF) this, s -> r -> {
            Assertions.assertThat(r).isEqualTo(expected);
            return s;
        });
    }
}
