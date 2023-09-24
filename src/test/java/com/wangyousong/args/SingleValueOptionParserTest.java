package com.wangyousong.args;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.wangyousong.args.BooleanOptionParserTest.option;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SingleValueOptionParserTest {


    @Test
    void should_not_accept_extra_argument_for_int_single_value_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            (new SingleValueOptionParser<>(0, Integer::parseInt)).parse(asList("-p", "8080", "8081"), option("p"));
        });

        assertEquals("p", e.getOption());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-p -l", "-p"})
    void should_not_accept_insufficient_argument_for_single_value_option(String arguments) {
        InsufficientArgumentsException e = assertThrows(InsufficientArgumentsException.class, () -> {
            (new SingleValueOptionParser<>(0, Integer::parseInt)).parse(List.of(arguments.split(" ")), option("p"));
        });

        assertEquals("p", e.getOption());
    }

    @Test
    void should_set_default_value_to_0_for_int_option() {
        Integer port = ((OptionParser<Integer>) new SingleValueOptionParser<>(0, Integer::parseInt)).parse(List.of(), option("p"));

        assertEquals(0, port);
    }

    @Test
    void should_not_accept_extra_argument_for_string_single_value_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            (new SingleValueOptionParser<>("", String::valueOf)).parse(asList("-d", "/usr/logs", "/usr/vars"), option("d"));
        });

        assertEquals("d", e.getOption());
    }
}