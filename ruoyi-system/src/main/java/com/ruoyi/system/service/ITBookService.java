package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TBook;

/**
 * 小说Service接口
 * 
 * @author ruoyi
 * @date 2020-04-12
 */
public interface ITBookService 
{
    /**
     * 查询小说
     * 
     * @param id 小说ID
     * @return 小说
     */
    public TBook selectTBookById(Long id);

    /**
     * 查询小说列表
     * 
     * @param tBook 小说
     * @return 小说集合
     */
    public List<TBook> selectTBookList(TBook tBook);

    /**
     * 新增小说
     * 
     * @param tBook 小说
     * @return 结果
     */
    public int insertTBook(TBook tBook);

    /**
     * 修改小说
     * 
     * @param tBook 小说
     * @return 结果
     */
    public int updateTBook(TBook tBook);

    /**
     * 批量删除小说
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBookByIds(String ids);

    /**
     * 删除小说信息
     * 
     * @param id 小说ID
     * @return 结果
     */
    public int deleteTBookById(Long id);
}
