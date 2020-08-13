package com.yueny.fw.console.entry;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <code>
 *
 * </code>
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/6/5 下午6:00
 */
@TableName("user")
@Getter
@Setter
@ToString
public class UserEntry extends AbstractEntry {
    private String name;
    private Integer age;
    private String email;

}
