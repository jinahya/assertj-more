package com.github.jinahya.assertj.more.java.time.zone;

import org.assertj.core.api.AbstractAssert;

import java.time.zone.ZoneRules;

/**
 * An abstract assert class for verifying values of {@link ZoneRules}.
 *
 * @param <S> self type parameter.
 * @param <A> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractZoneRulesAssert<
        S extends AbstractZoneRulesAssert<S, A>,
        A extends ZoneRules>
        extends AbstractAssert<S, A> {

    /**
     * Creates a new instance with specified value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractZoneRulesAssert(final A actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
