package com.ruoyi.system.service.comic.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.book.TBookParams;
import com.ruoyi.system.domain.comic.ComicParams;
import com.ruoyi.system.domain.comic.TComicEpisodes;
import com.ruoyi.system.service.comic.ITComicEpisodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TComicEpisodesMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 漫画章节Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-26
 */
@Service
public class TComicEpisodesServiceImpl implements ITComicEpisodesService
{
    @Autowired
    private TComicEpisodesMapper tComicEpisodesMapper;

    /**
     * 查询漫画章节
     * 
     * @param id 漫画章节ID
     * @return 漫画章节
     */
    @Override
    public TComicEpisodes selectTComicEpisodesById(Long id)
    {
        return tComicEpisodesMapper.selectTComicEpisodesById(id);
    }

    /**
     * 查询漫画章节列表
     * 
     * @param tComicEpisodes 漫画章节
     * @return 漫画章节
     */
    @Override
    public List<TComicEpisodes> selectTComicEpisodesList(TComicEpisodes tComicEpisodes)
    {
        return tComicEpisodesMapper.selectTComicEpisodesList(tComicEpisodes);
    }

    /**
     * 新增漫画章节
     * 
     * @param tComicEpisodes 漫画章节
     * @return 结果
     */
    @Override
    public int insertTComicEpisodes(TComicEpisodes tComicEpisodes)
    {
        tComicEpisodes.setCreateTime(DateUtils.getNowDate());
        return tComicEpisodesMapper.insertTComicEpisodes(tComicEpisodes);
    }

    /**
     * 修改漫画章节
     * 
     * @param tComicEpisodes 漫画章节
     * @return 结果
     */
    @Override
    public int updateTComicEpisodes(TComicEpisodes tComicEpisodes)
    {
        tComicEpisodes.setUpdateTime(DateUtils.getNowDate());
        return tComicEpisodesMapper.updateTComicEpisodes(tComicEpisodes);
    }

    /**
     * 删除漫画章节对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTComicEpisodesByIds(String ids)
    {
        return tComicEpisodesMapper.deleteTComicEpisodesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除漫画章节信息
     * 
     * @param id 漫画章节ID
     * @return 结果
     */
    @Override
    public int deleteTComicEpisodesById(Long id)
    {
        return tComicEpisodesMapper.deleteTComicEpisodesById(id);
    }

    @Override
    public ComicParams comicSetUp(Long comicId) {
        return tComicEpisodesMapper.comicSetUp(comicId);
    }

    @Override
    public Long count(Long comicId) {
        return tComicEpisodesMapper.count(comicId);
    }
}
