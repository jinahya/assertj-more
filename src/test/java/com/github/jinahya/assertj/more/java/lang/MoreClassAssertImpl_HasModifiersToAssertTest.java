package com.github.jinahya.assertj.more.java.lang;

class MoreClassAssertImpl_HasModifiersToAssertTest
        extends MoreJavaLangAssertTest<MoreClassAssertImpl, Class<?>> {

    @SuppressWarnings({"unchecked"})
    MoreClassAssertImpl_HasModifiersToAssertTest() {
        super(MoreClassAssertImpl.class, (Class<Class<?>>) (Object) Class.class);
    }
}