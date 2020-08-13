package com.yueny.fw.console.dao.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-05 11:13
 */
public class MysqlMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 在插入的时候自动填充 createDate
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("modifyTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 在插入的时候自动更新 modifyTime
        this.setFieldValByName("modifyTime", new Date(), metaObject);// 不允许手动设置更新时间
    }
}