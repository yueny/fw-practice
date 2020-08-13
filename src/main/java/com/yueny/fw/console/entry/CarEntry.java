package com.yueny.fw.console.entry;

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
public class CarEntry {
    private String make;
    private int numberOfSeats;
    private CarType type;

}
