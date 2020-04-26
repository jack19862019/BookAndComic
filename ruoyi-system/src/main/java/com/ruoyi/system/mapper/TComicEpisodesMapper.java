package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.comic.ComicParams;
import com.ruoyi.system.domain.comic.TComicEpisodes;
import org.apache.ibatis.annotations.Param;

/**
 * 漫画章节Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-26
 */
public interface TComicEpisodesMapper 
{
    /**
     * 查询漫画章节
     * 
     * @param id 漫画章节ID
     * @return 漫画章节
     */
    public TComicEpisodes selectTComicEpisodesById(Long id);

    /**
     * 查询漫画章节列表
     * 
     * @param tComicEpisodes 漫画章节
     * @return 漫画章节集合
     */
    public List<TComicEpisodes> selectTComicEpisodesList(TComicEpisodes tComicEpisodes);

    /**
     * 新增漫画章节
     * 
     * @param tComicEpisodes 漫画章节
     * @return 结果
     */
    public int insertTComicEpisodes(TComicEpisodes tComicEpisodes);

    /**
     * 修改漫画章节
     * 
     * @param tComicEpisodes 漫画章节
     * @return 结果
     */
    public int updateTComicEpisodes(TComicEpisodes tComicEpisodes);

    /**
     * 删除漫画章节
     * 
     * @param id 漫画章节ID
     * @return 结果
     */
    public int deleteTComicEpisodesById(Long id);

    /**
     * 批量删除漫画章节
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTComicEpisodesByIds(String[] ids);

    public ComicParams comicSetUp(Long comicId);

    public Long count(@Param("comicId") Long comicId);
}
