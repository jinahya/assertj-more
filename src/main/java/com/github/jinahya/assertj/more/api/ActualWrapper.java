package com.github.jinahya.assertj.more.api;

public abstract class ActualWrapper<A> {

    public abstract static class IntegerWrapper
            extends ActualWrapper<Integer> {

        protected IntegerWrapper(final Integer actual) {
            super(actual);
        }
    }

    protected ActualWrapper(final A actual) {
        super();
        this.actual = actual;
    }

    public A getActual() {
        return actual;
    }

    protected final A actual;
}
