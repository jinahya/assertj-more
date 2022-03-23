package org.assertj.core.api;

public abstract class AbstractAssertTest<S extends AbstractAssert<S, A>, A>
        extends AssertTest<S, A> {

    protected AbstractAssertTest(final Class<S> assertClass, final Class<A> actualClass) {
        super(assertClass, actualClass);
    }
}
