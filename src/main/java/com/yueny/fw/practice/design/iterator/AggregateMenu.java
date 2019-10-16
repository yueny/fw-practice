package com.yueny.fw.practice.design.iterator;

import com.yueny.fw.practice.design.iterator.core.Iterator;

/**
 * 抽象容器
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-16 14:06
 */
public interface AggregateMenu {
    void add(String name);

    /**
     * 返回一个迭代器
     *
     * @return
     */
    Iterator getIterator();

}
