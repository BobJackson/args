package com.wangyousong.args;

import java.util.List;
import java.util.function.Function;

class IntOptionParser implements OptionParser {

    Function<String, Object> valueParser = Integer::parseInt;

    public IntOptionParser() {
    }

    public IntOptionParser(Function<String, Object> valueParser) {
        this.valueParser = valueParser;
    }

    @Override
    public Object parse(List<String> arguments, Option option) {
        String value = arguments.get(arguments.indexOf("-" + option.value()) + 1);
        return valueParser.apply(value);
    }

}
