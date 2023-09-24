package com.wangyousong.args;

import java.util.List;

class IntOptionParser implements OptionParser {
    @Override
    public Object parse(List<String> arguments, Option option) {
        return Integer.parseInt(arguments.get(arguments.indexOf("-" + option.value()) + 1));
    }
}
