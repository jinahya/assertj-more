package com.github.jinahya.assertj.more.java.time.temporal;

import org.assertj.core.api.AbstractLocalDateTimeAssert;

import java.time.LocalDateTime;

/**
 * An extended {@link AbstractLocalDateTimeAssert} implements {@link MoreLocalDateTimeAssertImpl} interface.
 *
 * @param <SELF> self type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class AbstractMoreLocalDateTimeAssert<SELF extends AbstractMoreLocalDateTimeAssert<SELF>>
        extends AbstractLocalDateTimeAssert<SELF>
        implements MoreLocalDateTimeAssert<SELF> {

    /**
     * Creates a new instance with specified actual.
     *
     * @param actual the actual.
     */
    protected AbstractMoreLocalDateTimeAssert(final LocalDateTime actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }
}
