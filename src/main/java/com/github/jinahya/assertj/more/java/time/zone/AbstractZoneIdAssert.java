package com.github.jinahya.assertj.more.java.time.zone;

import com.github.jinahya.assertj.more.hidden.ForAssert;
import org.assertj.core.api.AbstractAssert;

import java.time.ZoneId;
import java.time.zone.ZoneRules;
import java.util.Objects;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * An abstract assert class for verifying values of {@link ZoneId}.
 *
 * @param <S> self type parameter.
 * @param <A> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractZoneIdAssert<S extends AbstractZoneIdAssert<S, A>, A extends ZoneId>
        extends AbstractAssert<S, A>
        implements MoreZoneIdAssert<S, A> {

    /**
     * Creates a new instance with specified value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractZoneIdAssert(final A actual, final Class<?> selfType) {
        super(actual, selfType);
    }

    // - ------------------------------------------------------------------------------------------------- getId()String
    protected <R> R getId(final Function<? super S, ? extends Function<? super String, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.getId());
    }

    public S hasId(final String expected) {
        return getId(s -> v -> {
            assertThat(v).isEqualTo(expected);
            return s;
        });
    }

    // --------------------------------------------------------------------------------------------- getRules()ZoneRules
    protected <R> R getRules(final Function<? super S, ? extends Function<? super ZoneRules, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.getRules());
    }

    public AbstractZoneRulesAssert<?, ZoneRules> extractingRules() {
        return getRules(s -> ZoneRulesAssert::assertMore);
    }

    // ---------------------------------------------------------------------------------------------- normalized()ZoneId
    protected <R> R normalized(final Function<? super S, ? extends Function<? super ZoneId, ? extends R>> function) {
        Objects.requireNonNull(function, "function is null");
        return function.apply(isNotNull())
                .apply(actual.normalized());
    }

    public AbstractZoneIdAssert<?, ZoneId> extractingNormalized() {
        return ForAssert.applyNonNullActual1(isNotNull(), a -> MoreJavaTimeZoneAssertions.assertMore(a.normalized()));
    }
}
