package com.zz.simple.sdk.utils.json;

public interface JSONErrorListener {
    void start(String text);
    void error(String message, int column);
    void end();
}
