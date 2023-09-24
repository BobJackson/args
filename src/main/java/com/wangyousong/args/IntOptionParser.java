package com.wangyousong.args;

import java.util.List;

class IntOptionParser implements OptionParser {

    @Override
    public Object parse(List<String> arguments, Option option) {
        String value = arguments.get(arguments.indexOf("-" + option.value()) + 1);
        return parseValue(value);
    }

    protected Object parseValue(String value) {
        return Integer.parseInt(value);
    }
}
