package com.wangyousong.args;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class BooleanOptionParserTest {

    @Test
    void should_not_accept_extra_argument_for_boolean_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            new BooleanOptionParser().parse(asList("-l", "t"), option("l"));
        });

        assertEquals("l", e.getOption());
    }

    // Default Value
    @Test
    void should_set_default_value_to_false_if_option_not_present() {
        assertFalse(new BooleanOptionParser().parse(List.of(), option("l")));
    }

    // Happy Path
    @Test
    void should_set_boolean_option_to_true_if_flag_present() {
        assertTrue(new BooleanOptionParser().parse(List.of("-l"), option("l")));
    }


    static Option option(String value) {
        return new Option() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Option.class;
            }

            @Override
            public String value() {
                return value;
            }
        };
    }
}