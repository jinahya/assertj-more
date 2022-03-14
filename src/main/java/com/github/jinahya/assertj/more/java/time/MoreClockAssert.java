package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertFactory;
import org.assertj.core.api.Assertions;

import java.time.Clock;
import java.time.ZoneId;
import java.util.Objects;
import java.util.function.Function;

public interface MoreClockAssert<SELF extends MoreClockAssert<SELF, ACTUAL>, ACTUAL extends Clock>
        extends MoreJavaTimeAssert<SELF, ACTUAL> {

    // ------------------------------------------------------------------------------------------------- getZone()ZoneId
    default <A extends Assert<?, ZoneId>> A extractingZoneApplying(
            final Function<? super ZoneId, ? extends A> function) {
        Objects.requireNonNull(function, "function is null");
        return MoreClockAssertHelper.<SELF, ACTUAL, A>getZone((SELF) this, s -> function);
    }

    default <A extends Assert<?, ZoneId>> A extractingZoneCreating(
            final AssertFactory<? super ZoneId, ? extends A> factory) {
        Objects.requireNonNull(factory, "factory is null");
        return extractingZoneApplying(factory::createAssert);
    }

    @SuppressWarnings({"unchecked"})
    default SELF hasZone(final ZoneId expected) {
        return MoreClockAssertHelper.getZone((SELF) this, s -> r -> {
            Assertions.assertThat(r)
                    .isEqualTo(expected);
            return s;
        });
    }

    // TODO: 2022/03/14 Add more!
}
