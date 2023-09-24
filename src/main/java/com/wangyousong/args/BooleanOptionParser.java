package com.wangyousong.args;

import java.util.List;

import static com.wangyousong.args.SingleValueOptionParser.values;

class BooleanOptionParser implements OptionParser<Boolean> {
    @Override
    public Boolean parse(List<String> arguments, Option option) {
        return values(arguments, option, 0).isPresent();
    }
}
