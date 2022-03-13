package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.java.time.zone.AbstractZoneIdAssert;
import com.github.jinahya.assertj.more.java.time.zone.ZoneIdAssert;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractInstantAssert;
import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.api.Assertions;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.LongFunction;

/**
 * An abstract assert class for verifying values of {@link Clock}.
 *
 * @param <SELF>   self type parameter.
 * @param <ACTUAL> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
@Deprecated
public abstract class AbstractMoreClockAssert<SELF extends AbstractMoreClockAssert<SELF, ACTUAL>, ACTUAL extends Clock>
        extends AbstractAssert<SELF, ACTUAL>
        implements MoreClockAssert<SELF, ACTUAL> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractMoreClockAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    // ------------------------------------------------------------------------------------------------- getZone()ZoneId
//    protected <R> R getZone(final Function<? super SELF, ? extends Function<? super ZoneId, ? extends R>> function) {
//        return function.apply(isNotNull())
//                .apply(actual.getZone());
//    }
//
//    public <A extends Assert<?, ZoneId>> A extractingZoneApplying(
//            final Function<? super ZoneId, ? extends A> function) {
//        Objects.requireNonNull(function, "function is null");
//        return getZone(s -> function);
//    }
//
//    public <A extends Assert<?, ZoneId>> A extractingZoneCreating(
//            final AssertFactory<? super ZoneId, ? extends A> factory) {
//        Objects.requireNonNull(factory, "factory is null");
//        return extractingZoneApplying(factory::createAssert);
//    }

    public AbstractZoneIdAssert<?, ZoneId> extractingZone() {
        return extractingZoneCreating(ZoneIdAssert::assertMore);
    }

    // ------------------------------------------------------------------------------------------------ instant()Instant
    protected <R> R instant(final Function<? super SELF, ? extends Function<? super Instant, ? extends R>> function) {
        return function.apply(isNotNull())
                .apply(actual.instant());
    }

    public AbstractInstantAssert<?> extractingInstant() {
        return instant(s -> Assertions::assertThat);
    }

    // ------------------------------------------------------------------------------------------------------- millis()J
    protected <R> R millis(final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.millis());
    }

    public AbstractLongAssert<?> extractingMillis() {
        return millis(s -> Assertions::assertThat);
    }
}
