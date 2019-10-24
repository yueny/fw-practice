package com.yueny.fw.practice.manager.impl;

import com.yueny.fw.practice.manager.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-22 14:49
 */
public class ActionServiceImpl implements IService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean doit(String userName) {
        logger.debug("doit {}......", userName);

        return true;
    }
}
