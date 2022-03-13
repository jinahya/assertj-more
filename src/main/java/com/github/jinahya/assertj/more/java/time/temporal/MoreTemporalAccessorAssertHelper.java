package com.github.jinahya.assertj.more.java.time.temporal;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQuery;
import java.time.temporal.ValueRange;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

class MoreTemporalAccessorAssertHelper {

    // --------------------------------------------------------------------------------------------- get(TemporalField)I
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends TemporalAccessor, R> R get(
            final TemporalField field,
            final SELF self,
            final Function<? super SELF, ? extends IntFunction<? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).get(field));
    }

    // ----------------------------------------------------------------------------------------- getLong(TemporalField)J
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends TemporalAccessor, R> R getLong(
            final TemporalField field,
            final SELF self,
            final Function<? super SELF, ? extends LongFunction<? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).getLong(field));
    }

    // ------------------------------------------------------------------------------------- isSupported(TemporalField)Z
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends TemporalAccessor, R> R isSupported(
            final TemporalField field,
            final SELF self,
            final Function<? super SELF, ? extends Function<? super Boolean, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).isSupported(field));
    }

    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends TemporalAccessor, R> R extractingIsSupported(
            final TemporalField field, final SELF self,
            final Function<? super SELF, ? extends Function<? super AbstractBooleanAssert<?>, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return isSupported(field, self, s -> r -> function.apply(s).apply(Assertions.assertThat(r)));
    }

    // -------------------------------------------------------------------------------------- query(TemporalQuery)Object
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends TemporalAccessor, R, X> X query(
            final TemporalQuery<R> query,
            final SELF self,
            final Function<? super SELF, ? extends Function<? super R, ? extends X>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).query(query));
    }

    //    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends TemporalAccessor, R> R extractingIsSupported(
//            final TemporalField field, final SELF self,
//            final Function<? super SELF, ? extends Function<? super AbstractBooleanAssert<?>, ? extends R>> function) {
//        Objects.requireNonNull(function, "function is null");
//        return isSupported(field, self, s -> r -> function.apply(s).apply(Assertions.assertThat(r)));
//    }

    // ---------------------------------------------------------------------------------- range(TemporalField)ValueRange

    /**
     * Returns the result of specified function applied with the result of {@link TemporalAccessor#range(TemporalField)}
     * method invoked on specified assertion's {@code actual} with specified field.
     *
     * @param field    the field.
     * @param self     the assertion.
     * @param function the function.
     * @param <SELF>   self type parameter
     * @param <ACTUAL> actual type parameter
     * @param <R>      result type parameter
     * @return the result of the {@code functione.}
     */
    static <SELF extends Assert<SELF, ACTUAL>, ACTUAL extends TemporalAccessor, R> R range(
            final TemporalField field,
            final SELF self,
            final Function<? super SELF, ? extends Function<? super ValueRange, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(ForAssert.invokeIsNotNull(self))
                .apply(ForAssert.getActual(self).range(field));
    }

    private MoreTemporalAccessorAssertHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
