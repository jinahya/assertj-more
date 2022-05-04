package com.github.jinahya.assertj.more.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoreClassAssertImpl_IsAbstractTest
        extends MoreClassAssertImpl_Test {

    @Test
    void isAbstract_Pass_AbstractClass() {
        abstract class Actual {

        }
        final var assertInstance = assertInstance(Actual.class);
        assertThatCode(assertInstance::isAbstract)
                .doesNotThrowAnyException();
    }

    @Test
    void isAbstract_Fail_ConcreteClass() {
        class Actual {

        }
        final var assertInstance = assertInstance(Actual.class);
        assertThatThrownBy(assertInstance::isAbstract)
                .isInstanceOf(AssertionError.class);
    }
}