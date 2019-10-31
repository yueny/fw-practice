package com.yueny.fw.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yueny.fw.dao.UserMapper;
import com.yueny.fw.entry.UserEntry;
import com.yueny.fw.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-31 19:09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntry>
        implements IUserService {
    @Override
    public List<UserEntry> getList() {
        UserEntry user = new UserEntry();
        user.setName("SimpleWu");
        Wrapper<UserEntry> wrapper = new QueryWrapper<>(user);

        return list(wrapper);
    }

    @Override
    public IPage<UserEntry> page() {
        int currentPage = 1 ; //当前页
        int pageSize = 2 ;//每页大小

        IPage<UserEntry> page = new Page<>(currentPage,pageSize);

        page = getBaseMapper().selectPage(page,null);
        return page;
    }
}
