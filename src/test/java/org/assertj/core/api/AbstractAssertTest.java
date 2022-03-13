package org.assertj.core.api;

public abstract class AbstractAssertTest<ASSERT extends AbstractAssert<ASSERT, ACTUAL>, ACTUAL>
        extends AssertTest<ASSERT, ACTUAL> {

    protected AbstractAssertTest(final Class<ASSERT> assertClass, final Class<ACTUAL> actualClass) {
        super(assertClass, actualClass);
    }
}
