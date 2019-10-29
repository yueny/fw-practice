package com.yueny.fw.practice.threadlocal;


/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-25 15:10
 */
public class NormalMDCAdapter implements MDCAdapter {
    private InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>() {
        @Override
        protected String childValue(String parentValue) {
            if (parentValue == null) {
                return null;
            }
            return parentValue;
        }
    };

    @Override
    public void put(String val) {
        inheritableThreadLocal.set(val);
    }

    @Override
    public String get() {
        return inheritableThreadLocal.get();
    }

    @Override
    public void remove() {
        inheritableThreadLocal.remove();
    }

    @Override
    public void clear() {
        inheritableThreadLocal.remove();
    }
}
