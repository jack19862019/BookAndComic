package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.comic.TComic;

import java.util.List;

/**
 * 漫画管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-22
 */
public interface TComicMapper 
{
    /**
     * 查询漫画管理
     * 
     * @param id 漫画管理ID
     * @return 漫画管理
     *
     */
    public TComic selectTComicById(Long id);

    /**
     * 查询漫画管理列表
     * 
     * @param tComic 漫画管理
     * @return 漫画管理集合
     */
    public List<TComic> selectTComicList(TComic tComic);

    /**
     * 新增漫画管理
     * 
     * @param tComic 漫画管理
     * @return 结果
     */
    public int insertTComic(TComic tComic);

    /**
     * 修改漫画管理
     * 
     * @param tComic 漫画管理
     * @return 结果
     */
    public int updateTComic(TComic tComic);

    /**
     * 删除漫画管理
     * 
     * @param id 漫画管理ID
     * @return 结果
     */
    public int deleteTComicById(Long id);

    /**
     * 批量删除漫画管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTComicByIds(String[] ids);
}
