package com.github.jinahya.assertj.more.java.time;

import com.github.jinahya.assertj.more.api.ComparableAssertProxy;
import org.assertj.core.api.AbstractLocalDateTimeAssert;

import java.time.LocalDateTime;

/**
 * An extended {@link AbstractLocalDateTimeAssert} implements {@link MoreLocalDateTimeAssertImpl} interface.
 *
 * @param <S> self type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public abstract class AbstractMoreLocalDateTimeAssert<S extends AbstractMoreLocalDateTimeAssert<S>>
        extends AbstractLocalDateTimeAssert<S>
        implements MoreLocalDateTimeAssert<S>,
                   ComparableAssertProxy<S, LocalDateTime> {

    /**
     * Creates a new instance with specified actual.
     *
     * @param actual   the actual.
     * @param selfType self type.
     */
    protected AbstractMoreLocalDateTimeAssert(final LocalDateTime actual, final Class<S> selfType) {
        super(actual, selfType);
    }
}
