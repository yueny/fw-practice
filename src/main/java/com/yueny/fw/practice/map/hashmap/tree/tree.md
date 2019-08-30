# 测试map从链表转变成红黑树的过程以及扩容
```
在使用IDEA查看map的数据时，要设置view as Object。
```

## 第一阶段
这个时候桶中bin的数量小于TREEIFY_THRESHOLD 。
此阶段执行之后，HashMap中除了table长度之外，没有任何变化。

## 第二阶段:
此时还是链表的数据结构.
但是会进行一次扩容。



