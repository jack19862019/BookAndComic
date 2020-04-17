package com.ruoyi.system.service.book.impl;

import com.ruoyi.system.domain.TBookContent;
import com.ruoyi.system.mapper.TBookContentMapper;
import com.ruoyi.system.service.book.ITBookContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

import java.util.List;

/**
 * 小说章节Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
@Service
public class TBookContentServiceImpl implements ITBookContentService
{
    @Autowired
    private TBookContentMapper tBookContentMapper;

    /**
     * 查询小说章节
     * 
     * @param id 小说章节ID
     * @return 小说章节
     */
    @Override
    public TBookContent selectTBookContentById(Long id)
    {
        return tBookContentMapper.selectTBookContentById(id);
    }

    /**
     * 查询小说章节列表
     * 
     * @param tBookContent 小说章节
     * @return 小说章节
     */
    @Override
    public List<TBookContent> selectTBookContentList(TBookContent tBookContent)
    {
        return tBookContentMapper.selectTBookContentList(tBookContent);
    }

    /**
     * 新增小说章节
     * 
     * @param tBookContent 小说章节
     * @return 结果
     */
    @Override
    public int insertTBookContent(TBookContent tBookContent)
    {
        return tBookContentMapper.insertTBookContent(tBookContent);
    }

    /**
     * 修改小说章节
     * 
     * @param tBookContent 小说章节
     * @return 结果
     */
    @Override
    public int updateTBookContent(TBookContent tBookContent)
    {
        return tBookContentMapper.updateTBookContent(tBookContent);
    }

    /**
     * 删除小说章节对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBookContentByIds(String ids)
    {
        return tBookContentMapper.deleteTBookContentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小说章节信息
     * 
     * @param id 小说章节ID
     * @return 结果
     */
    @Override
    public int deleteTBookContentById(Long id)
    {
        return tBookContentMapper.deleteTBookContentById(id);
    }

    @Override
    public void insertBatch(List<TBookContent> newContentList) {
        tBookContentMapper.insertBatch(newContentList);
    }
}
