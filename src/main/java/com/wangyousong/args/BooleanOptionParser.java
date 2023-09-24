package com.wangyousong.args;

import java.util.List;

class BooleanOptionParser implements OptionParser<Boolean> {
    @Override
    public Boolean parse(List<String> arguments, Option option) {
        return arguments.contains("-" + option.value());
    }
}
