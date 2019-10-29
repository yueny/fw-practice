package com.yueny.fw.practice.threadlocal;

/**
 * MDC上下文传递
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-25 15:09
 */
public interface MDCAdapter {
    void put(String val);

    String get();

    void remove();

    /**
     * Clear all entries in the MDC.
     */
    public void clear();
}
