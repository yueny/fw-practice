package com.yueny.fw.entry;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-05 11:10
 */
@Getter
@Setter
@ToString
public abstract class AbstractEntry {

    /** 自然主键 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 表创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** 表修改时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;
}