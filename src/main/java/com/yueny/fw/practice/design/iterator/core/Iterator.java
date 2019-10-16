package com.yueny.fw.practice.design.iterator.core;

/**
 * 迭代器设计模式
 *
 * 抽象迭代器
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-16 14:00
 */
public interface Iterator<E> {
    /**
     * 返回该迭代器中是否还有未遍历过的元素
     *
     * @return
     */
    boolean hasNext();

    /**
     * 返回迭代器中的下一个元素
     *
     * @return
     */
    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

}
