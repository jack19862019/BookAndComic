package com.ruoyi.system.service.site;

import com.ruoyi.system.domain.site.TArticle;

import java.util.List;

/**
 * 消息管理Service接口
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
public interface ITArticleService 
{
    /**
     * 查询消息管理
     * 
     * @param id 消息管理ID
     * @return 消息管理
     */
    public TArticle selectTArticleById(Long id);

    /**
     * 查询消息管理列表
     * 
     * @param tArticle 消息管理
     * @return 消息管理集合
     */
    public List<TArticle> selectTArticleList(TArticle tArticle);

    /**
     * 新增消息管理
     * 
     * @param tArticle 消息管理
     * @return 结果
     */
    public int insertTArticle(TArticle tArticle);

    /**
     * 修改消息管理
     * 
     * @param tArticle 消息管理
     * @return 结果
     */
    public int updateTArticle(TArticle tArticle);

    /**
     * 批量删除消息管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTArticleByIds(String ids);

    /**
     * 删除消息管理信息
     * 
     * @param id 消息管理ID
     * @return 结果
     */
    public int deleteTArticleById(Long id);
}
