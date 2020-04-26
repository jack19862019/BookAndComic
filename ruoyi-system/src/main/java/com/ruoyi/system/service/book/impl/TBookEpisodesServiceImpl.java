package com.ruoyi.system.service.book.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.book.TBookEpisodes;
import com.ruoyi.system.domain.book.TBookParams;
import com.ruoyi.system.service.book.ITBookEpisodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBookEpisodesMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 小说章节Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-18
 */
@Service
public class TBookEpisodesServiceImpl implements ITBookEpisodesService
{
    @Autowired
    private TBookEpisodesMapper tBookEpisodesMapper;

    /**
     * 查询小说章节
     * 
     * @param id 小说章节ID
     * @return 小说章节
     */
    @Override
    public TBookEpisodes selectTBookEpisodesById(Long id)
    {
        return tBookEpisodesMapper.selectTBookEpisodesById(id);
    }

    /**
     * 查询小说章节列表
     * 
     * @param tBookEpisodes 小说章节
     * @return 小说章节
     */
    @Override
    public List<TBookEpisodes> selectTBookEpisodesList(TBookEpisodes tBookEpisodes)
    {
        return tBookEpisodesMapper.selectTBookEpisodesList(tBookEpisodes);
    }

    /**
     * 新增小说章节
     * 
     * @param tBookEpisodes 小说章节
     * @return 结果
     */
    @Override
    public int insertTBookEpisodes(TBookEpisodes tBookEpisodes)
    {
        tBookEpisodes.setCreateTime(DateUtils.getNowDate());
        return tBookEpisodesMapper.insertTBookEpisodes(tBookEpisodes);
    }

    /**
     * 修改小说章节
     * 
     * @param tBookEpisodes 小说章节
     * @return 结果
     */
    @Override
    public int updateTBookEpisodes(TBookEpisodes tBookEpisodes)
    {
        tBookEpisodes.setUpdateTime(DateUtils.getNowDate());
        return tBookEpisodesMapper.updateTBookEpisodes(tBookEpisodes);
    }

    /**
     * 删除小说章节对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTBookEpisodesByIds(String ids)
    {
        return tBookEpisodesMapper.deleteTBookEpisodesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小说章节信息
     * 
     * @param id 小说章节ID
     * @return 结果
     */
    @Override
    public int deleteTBookEpisodesById(Long id)
    {
        return tBookEpisodesMapper.deleteTBookEpisodesById(id);
    }

    @Override
    public TBookParams bookSetUp(Long bid) {
        return tBookEpisodesMapper.bookSetUp(bid);
    }

    @Override
    public Long count(Long bid) {
        return tBookEpisodesMapper.count(bid);
    }
}
