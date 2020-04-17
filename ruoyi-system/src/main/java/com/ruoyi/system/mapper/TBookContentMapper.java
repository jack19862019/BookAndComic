package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TBookContent;

/**
 * 小说章节Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
public interface TBookContentMapper 
{
    /**
     * 查询小说章节
     * 
     * @param id 小说章节ID
     * @return 小说章节
     */
    public TBookContent selectTBookContentById(Long id);

    /**
     * 查询小说章节列表
     * 
     * @param tBookContent 小说章节
     * @return 小说章节集合
     */
    public List<TBookContent> selectTBookContentList(TBookContent tBookContent);

    /**
     * 新增小说章节
     * 
     * @param tBookContent 小说章节
     * @return 结果
     */
    public int insertTBookContent(TBookContent tBookContent);

    /**
     * 修改小说章节
     * 
     * @param tBookContent 小说章节
     * @return 结果
     */
    public int updateTBookContent(TBookContent tBookContent);

    /**
     * 删除小说章节
     * 
     * @param id 小说章节ID
     * @return 结果
     */
    public int deleteTBookContentById(Long id);

    /**
     * 批量删除小说章节
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBookContentByIds(String[] ids);

    /**
     * 批量新增小说章节
     * @return 结果
     */
    public void insertBatch(List<TBookContent> newContentList);
}
