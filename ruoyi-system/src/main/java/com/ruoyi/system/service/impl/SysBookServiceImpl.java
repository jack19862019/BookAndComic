package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.system.domain.SysBook;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISysBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 小说 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysBookServiceImpl implements ISysBookService
{
    private static final Logger log = LoggerFactory.getLogger(SysBookServiceImpl.class);

    @Autowired
    private SysBookMapper sysBookMapper;

    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysBook> selectBookList(SysBook sysBook) {
        return sysBookMapper.selectBookList(sysBook);
    }

    @Override
    public SysBook selectBookById(String id) {
        return sysBookMapper.selectBookById(id);
    }

    @Override
    public int deleteBookById(String id) {
        return sysBookMapper.deleteBookById(id);
    }

    @Override
    public int insertBook(SysBook sysBook) {
        return sysBookMapper.insertBook(sysBook);
    }

    @Override
    public int checkTitleUnique(String title) {
        return sysBookMapper.checkTitleUnique(title);
    }
}
