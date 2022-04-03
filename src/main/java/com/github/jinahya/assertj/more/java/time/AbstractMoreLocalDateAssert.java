package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.api.ComparableAssertProxy;
import org.assertj.core.api.AbstractLocalDateAssert;

import java.time.LocalDate;

/**
 * An extended {@link AbstractLocalDateAssert} implements {@link MoreLocalDateAssertImpl} interface.
 *
 * @param <S> self type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public abstract class AbstractMoreLocalDateAssert<S extends AbstractMoreLocalDateAssert<S>>
        extends AbstractLocalDateAssert<S>
        implements MoreLocalDateAssert<S>,
                   ComparableAssertProxy<S, LocalDate> {

    /**
     * Creates a new instance with specified actual.
     *
     * @param actual   the actual.
     * @param selfType self type.
     */
    protected AbstractMoreLocalDateAssert(final LocalDate actual, Class<S> selfType) {
        super(actual, selfType);
    }
}
