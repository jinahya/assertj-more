package io.github.jinahya.assertj.more.api;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static io.github.jinahya.assertj.more.api.JinahyaInstantConditions.NotInThePast;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JinahyaInstantConditionsTest {

    @Nested
    class IsNotInThePastTest {

        @Test
        void _Pass_() {
            final var actual = Instant.now().plus(Duration.ofDays(1L));
            assertThat(actual).is(NotInThePast);
        }

        @Test
        void _Fail_() {
            final var actual = Instant.now().minus(Duration.ofNanos(1L));
            assertThatThrownBy(() -> {
                assertThat(actual).is(NotInThePast);
            }).isInstanceOf(AssertionError.class);
        }
    }
}
