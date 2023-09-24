package com.wangyousong.args.exception;

public class TooManyArgumentsException extends RuntimeException {

    private final String option;

    public TooManyArgumentsException(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
