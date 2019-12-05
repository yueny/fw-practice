package com.yueny.fw.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-05 11:16
 */
public enum DelEnum {
    /**
     * 正常状态
     */
    NORMAL(1, "正常状态"),
    /**
     * 已删除
     */
    DEL(0, "已删除");


    @EnumValue
    @Getter
    private Integer val;

    @Getter
    private String desc;

    DelEnum(final int val, final String desc) {
        this.val = val;
        this.desc = desc;
    }
}
