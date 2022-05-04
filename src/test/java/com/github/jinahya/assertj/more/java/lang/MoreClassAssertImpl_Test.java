package com.github.jinahya.assertj.more.java.lang;

class MoreClassAssertImpl_Test
        extends MoreJavaLangAssertTest<MoreClassAssertImpl, Class<?>> {

    @SuppressWarnings({"unchecked"})
    MoreClassAssertImpl_Test() {
        super(MoreClassAssertImpl.class, (Class<Class<?>>) (Object) Class.class);
    }
}