package com.yueny.fw.console.bo;

import com.yueny.fw.console.entry.CarType;
import com.yueny.superclub.api.pojo.instance.AbstractBo;
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
@Getter
@Setter
@ToString
public class CarBo extends AbstractBo {
    private String make;
    private int seatCount;
    private CarType type;

}
