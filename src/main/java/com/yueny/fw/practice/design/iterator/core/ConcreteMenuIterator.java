package com.yueny.fw.practice.design.iterator.core;

/**
 * 具体迭代器, 忽略线程安全问题
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-16 14:05
 */
public class ConcreteMenuIterator implements Iterator {
    String[] foods;
    int      position = 0;

    public ConcreteMenuIterator(String[] foods){
        this.foods = foods;
    }

    @Override
    public boolean hasNext() {
        return position != foods.length;
    }

    @Override
    public Object next() {
        String food = foods[position];
        position += 1;

        return food;
    }
}
