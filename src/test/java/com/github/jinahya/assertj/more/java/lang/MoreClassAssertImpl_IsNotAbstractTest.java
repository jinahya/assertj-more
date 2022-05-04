package com.github.jinahya.assertj.more.java.lang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoreClassAssertImpl_IsNotAbstractTest
        extends MoreClassAssertImpl_Test {

    @Test
    void isNotAbstract_Fail_AbstractClass() {
        abstract class Actual {

        }
        final var assertInstance = assertInstance(Actual.class);
        assertThatThrownBy(assertInstance::isNotAbstract)
                .isInstanceOf(AssertionError.class);
    }

    @Test
    void isNotAbstract_Pass_ConcreteClass() {
        class Actual {

        }
        final var assertInstance = assertInstance(Actual.class);
        assertThatCode(assertInstance::isNotAbstract)
                .doesNotThrowAnyException();
    }
}