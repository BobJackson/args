package com.wangyousong.args;

class StringOptionParser extends IntOptionParser implements OptionParser {

    @Override
    protected Object parseValue(String value) {
        return String.valueOf(value);
    }
}
