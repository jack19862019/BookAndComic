package com.ruoyi.system.service.comic.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.comic.TComic;
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
}
