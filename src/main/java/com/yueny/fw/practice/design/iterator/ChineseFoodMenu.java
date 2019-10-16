package com.yueny.fw.practice.design.iterator;

import com.yueny.fw.practice.design.iterator.core.ConcreteMenuIterator;
import com.yueny.fw.practice.design.iterator.core.Iterator;

/**
 * 一个 Concrete Aggregate， 具体容器
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-16 14:07
 */
public class ChineseFoodMenu implements  AggregateMenu {
    private String[] foods    = new String[4];
    private int      position = 0;

    @Override
    public void add(String name) {
        foods[position] = name;
        position += 1;
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteMenuIterator(this.foods);
    }
}
