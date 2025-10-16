package io.github.jinahya.assertj.more.api;

import org.assertj.core.api.AbstractInstantAssert;

import java.time.Instant;

public abstract class JinahyaInstantAssert<SELF extends JinahyaInstantAssert<SELF>>
        extends AbstractInstantAssert<SELF> {

    protected JinahyaInstantAssert(final Instant actual, final Class<SELF> selfType) {
        super(actual, selfType);
    }

    public SELF isNotInTheFuture() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public SELF isNotInThePast() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
