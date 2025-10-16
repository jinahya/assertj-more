package io.github.jinahya.assertj.more.api;

import org.assertj.core.api.Condition;

import java.time.Instant;

public class JinahyaInstantConditions {

    public static final Condition<Instant> NotInThePast = new Condition<>() {
        @Override
        public boolean matches(final Instant value) {
            return !value.isBefore(Instant.now());
        }
    };

    protected JinahyaInstantConditions() {
        super();
    }
}
