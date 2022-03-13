package com.github.jinahya.assertj.more.java.time.zone;

import org.assertj.core.api.AbstractAssert;

import java.time.zone.ZoneRules;

/**
 * An abstract assert class for verifying values of {@link ZoneRules}.
 *
 * @param <SELF>   self type parameter.
 * @param <ACTUAL> actual type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractZoneRulesAssert<
        SELF extends AbstractZoneRulesAssert<SELF, ACTUAL>,
        ACTUAL extends ZoneRules>
        extends AbstractAssert<SELF, ACTUAL> {

    /**
     * Creates a new instance with specified value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractZoneRulesAssert(final ACTUAL actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}
