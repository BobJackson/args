package com.wangyousong.args;

import com.wangyousong.args.exception.TooManyArgumentsException;

import java.util.List;

class BooleanOptionParser implements OptionParser<Boolean> {
    @Override
    public Boolean parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        if (index == -1) return false;
        List<String> values = SingleValueOptionParser.values(arguments, index);
        if (values.size() > 0) throw new TooManyArgumentsException(option.value());
        return true;
    }
}
