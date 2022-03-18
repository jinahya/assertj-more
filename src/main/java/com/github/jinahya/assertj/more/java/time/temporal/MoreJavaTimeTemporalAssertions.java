package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.AbstractMoreAssertions;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.ByteBuddy;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;

public class MoreJavaTimeTemporalAssertions
        extends AbstractMoreAssertions {

    public static AbstractMoreTemporalAccessorAssert<?> assertMore(final TemporalAccessor actual) {
        return new MoreTemporalAccessorAssertImpl(actual);
    }

    public static AbstractMoreTemporalAssert<?> assertMore(final Temporal actual) {
        return new MoreTemporalAssertImpl(actual);
    }

    // --------------------------------------------------------------------------------- java.time.temporal.TemporalUnit
    public static AbstractMoreTemporalUnitAssert<?, TemporalUnit> assertMore(final TemporalUnit actual) {
        return new MoreTemporalUnitAssertImpl(actual);
    }

    public static AbstractMoreChronoUnitAssert<?> assertMore(final ChronoUnit actual) {
        return new MoreChronoUnitAssertImpl(actual);
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static <
            ASSERT extends Assert<ASSERT, ACTUAL> & MoreJavaTimeTemporalAssert<ASSERT, ACTUAL>,
            ACTUAL extends Temporal>
    ASSERT assertMore(final ACTUAL actual, final Class<ACTUAL> type) {
        try {
            Assertions.assertThat(LocalDate.now());
            final MethodHandle handle = MethodHandles.lookup().findStatic(
                    Assertions.class, "assertThat", MethodType.methodType(AbstractTemporalAssert.class, type));
            try {
                final Class<?> core = handle.invoke(actual).getClass();
                final Class<?> more = new ByteBuddy()
                        .subclass(core)
                        .implement(MoreJavaTimeTemporalAssert.class)
                        .make()
                        .load(MoreJavaTimeTemporalAssertions.class.getClassLoader())
                        .getLoaded();
                return (ASSERT) more.getConstructor(type).newInstance(actual);
            } catch (final Throwable t) {
                throw new RuntimeException(t);
            }
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    public static AbstractMoreValueRangeAssert<?> assertMore(final ValueRange actual) {
        return new MoreValueRangeAssertImpl(actual);
    }

    protected MoreJavaTimeTemporalAssertions() {
        super();
    }
}
