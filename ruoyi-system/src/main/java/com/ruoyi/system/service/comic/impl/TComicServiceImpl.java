package com.ruoyi.system.service.comic.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.comic.ComicParams;
import com.ruoyi.system.domain.comic.TComic;
import com.ruoyi.system.domain.comic.TComicEpisodes;
import com.ruoyi.system.service.book.ITBookEpisodesService;
import com.ruoyi.system.service.comic.ITComicEpisodesService;
import com.ruoyi.system.service.comic.ITComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TComicMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 漫画管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-22
 */
@Service
public class TComicServiceImpl implements ITComicService
{
    @Autowired
    private TComicMapper tComicMapper;

    /**
     * 查询漫画管理
     * 
     * @param id 漫画管理ID
     * @return 漫画管理
     */
    @Override
    public TComic selectTComicById(Long id)
    {
        return tComicMapper.selectTComicById(id);
    }

    /**
     * 查询漫画管理列表
     * 
     * @param tComic 漫画管理
     * @return 漫画管理
     */
    @Override
    public List<TComic> selectTComicList(TComic tComic)
    {
        return tComicMapper.selectTComicList(tComic);
    }

    /**
     * 新增漫画管理
     * 
     * @param tComic 漫画管理
     * @return 结果
     */
    @Override
    public int insertTComic(TComic tComic)
    {
        tComic.setCreateTime(DateUtils.getNowDate());
        return tComicMapper.insertTComic(tComic);
    }

    /**
     * 修改漫画管理
     * 
     * @param tComic 漫画管理
     * @return 结果
     */
    @Override
    public int updateTComic(TComic tComic)
    {
        tComic.setUpdateTime(DateUtils.getNowDate());
        return tComicMapper.updateTComic(tComic);
    }

    /**
     * 删除漫画管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTComicByIds(String ids)
    {
        return tComicMapper.deleteTComicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除漫画管理信息
     * 
     * @param id 漫画管理ID
     * @return 结果
     */
    @Override
    public int deleteTComicById(Long id)
    {
        return tComicMapper.deleteTComicById(id);
    }
    @Autowired
    private ITComicEpisodesService itComicEpisodesService;
    @Override
    public void comicUpdate(ComicParams comicParams) {
        try {
            TComicEpisodes tComicEpisodes =new TComicEpisodes();
            tComicEpisodes.setComicId(comicParams.getComicId());

            List<TComicEpisodes> list = itComicEpisodesService.selectTComicEpisodesList(tComicEpisodes);
            for (int i = 0; i < list.size(); i++) {
                if(i>=comicParams.getJiNo()){
                    tComicEpisodes.setMoney(comicParams.getMoney());
                }else{
                    tComicEpisodes.setMoney(0.00);
                }
                tComicEpisodes.setId(list.get(i).getId());
                itComicEpisodesService.updateTComicEpisodes(tComicEpisodes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
