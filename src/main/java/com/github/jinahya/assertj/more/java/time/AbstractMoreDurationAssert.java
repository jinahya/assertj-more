package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractDurationAssert;

import java.time.Duration;

/**
 * An abstract assert class for verifying values of {@link Duration}.
 *
 * @param <SELF> self type parameter.
 * @author Jin Kwon &lt;onacit_at_wemakeprice.com&gt;
 */
public abstract class AbstractMoreDurationAssert<SELF extends AbstractMoreDurationAssert<SELF>>
        extends AbstractDurationAssert<SELF>
        implements MoreDurationAssert<SELF> {

    /**
     * Creates a new instance with specified actual value and self type.
     *
     * @param actual   the actual value to verify.
     * @param selfType the self type.
     */
    protected AbstractMoreDurationAssert(final Duration actual, final Class<?> selfType) {
        super(actual, selfType);
    }
}