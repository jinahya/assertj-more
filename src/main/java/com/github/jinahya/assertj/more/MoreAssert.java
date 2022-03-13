package com.github.jinahya.assertj.more;

import org.assertj.core.api.Assert;

public interface MoreAssert<SELF extends MoreAssert<SELF, ACTUAL>, ACTUAL>
        extends Assert<SELF, ACTUAL> {

}
