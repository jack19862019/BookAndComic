package com.ruoyi.system.service.site.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.site.TArticle;
import com.ruoyi.system.service.site.ITArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TArticleMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 消息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
@Service
public class TArticleServiceImpl implements ITArticleService
{
    @Autowired
    private TArticleMapper tArticleMapper;

    /**
     * 查询消息管理
     * 
     * @param id 消息管理ID
     * @return 消息管理
     */
    @Override
    public TArticle selectTArticleById(Long id)
    {
        return tArticleMapper.selectTArticleById(id);
    }

    /**
     * 查询消息管理列表
     * 
     * @param tArticle 消息管理
     * @return 消息管理
     */
    @Override
    public List<TArticle> selectTArticleList(TArticle tArticle)
    {
        return tArticleMapper.selectTArticleList(tArticle);
    }

    /**
     * 新增消息管理
     * 
     * @param tArticle 消息管理
     * @return 结果
     */
    @Override
    public int insertTArticle(TArticle tArticle)
    {
        tArticle.setCreateTime(DateUtils.getNowDate());
        return tArticleMapper.insertTArticle(tArticle);
    }

    /**
     * 修改消息管理
     * 
     * @param tArticle 消息管理
     * @return 结果
     */
    @Override
    public int updateTArticle(TArticle tArticle)
    {
        tArticle.setUpdateTime(DateUtils.getNowDate());
        return tArticleMapper.updateTArticle(tArticle);
    }

    /**
     * 删除消息管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTArticleByIds(String ids)
    {
        return tArticleMapper.deleteTArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除消息管理信息
     * 
     * @param id 消息管理ID
     * @return 结果
     */
    @Override
    public int deleteTArticleById(Long id)
    {
        return tArticleMapper.deleteTArticleById(id);
    }
}
