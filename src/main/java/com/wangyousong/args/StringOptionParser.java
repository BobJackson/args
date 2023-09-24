package com.wangyousong.args;

import java.util.List;

class StringOptionParser implements OptionParser {
    @Override
    public Object parse(List<String> arguments, Option option) {
        return arguments.get(arguments.indexOf("-" + option.value()) + 1);
    }
}
