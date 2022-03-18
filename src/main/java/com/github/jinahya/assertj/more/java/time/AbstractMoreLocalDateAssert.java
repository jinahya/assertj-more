package com.github.jinahya.assertj.more.java.time;

import org.assertj.core.api.AbstractLocalDateAssert;

import java.time.LocalDate;

/**
 * An extended {@link AbstractLocalDateAssert} implements {@link MoreLocalDateAssertImpl} interface.
 *
 * @param <SELF> self type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public abstract class AbstractMoreLocalDateAssert<SELF extends AbstractMoreLocalDateAssert<SELF>>
        extends AbstractLocalDateAssert<SELF>
        implements MoreLocalDateAssert<SELF> {

    /**
     * Creates a new instance with specified actual.
     *
     * @param actual   the actual.
     * @param selfType self type.
     */
    protected AbstractMoreLocalDateAssert(final LocalDate actual, Class<SELF> selfType) {
        super(actual, selfType);
    }
}
