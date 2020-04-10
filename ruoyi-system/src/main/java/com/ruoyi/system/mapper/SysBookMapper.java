package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysBook;

import java.util.List;

/**
 * 小说表 数据层
 * 
 * @author ruoyi
 */
public interface SysBookMapper
{
    /**
     * 根据条件分页查询用户列表
     * 
     * @param sysBook 小说信息
     * @return 小说信息集合信息
     */
    public List<SysBook> selectBookList(SysBook sysBook);

    /**
     * 通过用户ID查询小说
     *
     * @param id 用户ID
     * @return 小说对象信息
     */
    public SysBook selectBookById(String id);

    /**
     * 通过小说ID删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
    public int deleteBookById(String id);


    /**
     * 新增小说信息
     * 
     * @param sysBook 小说信息
     * @return 结果
     */
    public int insertBook(SysBook sysBook);

    /**
     * 校验小说名称是否唯一
     * 
     * @param title 登录名称
     * @return 结果
     */
    public int checkTitleUnique(String title);


}
