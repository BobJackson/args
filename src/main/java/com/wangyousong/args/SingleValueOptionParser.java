package com.wangyousong.args;

import java.util.List;
import java.util.function.Function;

class SingleValueOptionParser<T> implements OptionParser<T> {

    Function<String, T> valueParser;

    public SingleValueOptionParser(Function<String, T> valueParser) {
        this.valueParser = valueParser;
    }

    @Override
    public T parse(List<String> arguments, Option option) {
        String value = arguments.get(arguments.indexOf("-" + option.value()) + 1);
        return valueParser.apply(value);
    }

}
