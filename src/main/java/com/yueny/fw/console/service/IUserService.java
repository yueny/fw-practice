package com.yueny.fw.console.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yueny.fw.console.entry.UserEntry;

import java.util.List;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-31 19:09
 */
public interface IUserService extends IService<UserEntry> {
     List<UserEntry> getList();

     IPage<UserEntry> page();
}
