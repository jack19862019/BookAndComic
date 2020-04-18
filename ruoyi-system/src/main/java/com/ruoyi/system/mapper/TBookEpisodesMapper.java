package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.book.TBookEpisodes;

import java.util.List;

/**
 * 小说章节Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-18
 */
public interface TBookEpisodesMapper 
{
    /**
     * 查询小说章节
     * 
     * @param id 小说章节ID
     * @return 小说章节
     */
    public TBookEpisodes selectTBookEpisodesById(Long id);

    /**
     * 查询小说章节列表
     * 
     * @param tBookEpisodes 小说章节
     * @return 小说章节集合
     */
    public List<TBookEpisodes> selectTBookEpisodesList(TBookEpisodes tBookEpisodes);

    /**
     * 新增小说章节
     * 
     * @param tBookEpisodes 小说章节
     * @return 结果
     */
    public int insertTBookEpisodes(TBookEpisodes tBookEpisodes);

    /**
     * 修改小说章节
     * 
     * @param tBookEpisodes 小说章节
     * @return 结果
     */
    public int updateTBookEpisodes(TBookEpisodes tBookEpisodes);

    /**
     * 删除小说章节
     * 
     * @param id 小说章节ID
     * @return 结果
     */
    public int deleteTBookEpisodesById(Long id);

    /**
     * 批量删除小说章节
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTBookEpisodesByIds(String[] ids);
}
