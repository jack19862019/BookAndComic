package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysBook;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserRole;

import java.util.List;

/**
 * 小说 业务层
 * 
 * @author ruoyi
 */
public interface ISysBookService
{
    /**
     * 根据条件分页查询小说列表
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
     * 通过用户ID删除小说
     * 
     * @param  id 小说ID
     * @return 结果
     */
    public int deleteBookById(String id);


    /**
     * 保存小说信息
     * 
     * @param sysBook 小说信息
     * @return 结果
     */
    public int insertBook(SysBook sysBook);


    /**
     * 校验小说名称是否唯一
     * 
     * @param title 小说名称
     * @return 结果
     */
    public int checkTitleUnique(String title);

}
