package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.site.TWebSite;

/**
 * 站点配置Mapper接口
 *
 * @author lucifer
 * @date 2020-04-11
 */
public interface TWebSiteMapper
{
    /**
     * 查询站点配置
     *
     * @param id 站点配置ID
     * @return 站点配置
     */
    public TWebSite selectTWebSiteById(Long id);

    /**
     * 查询站点配置列表
     *
     * @param tWebSite 站点配置
     * @return 站点配置集合
     */
    public List<TWebSite> selectTWebSiteList(TWebSite tWebSite);

    /**
     * 新增站点配置
     *
     * @param tWebSite 站点配置
     * @return 结果
     */
    public int insertTWebSite(TWebSite tWebSite);

    /**
     * 修改站点配置
     *
     * @param tWebSite 站点配置
     * @return 结果
     */
    public int updateTWebSite(TWebSite tWebSite);

    /**
     * 删除站点配置
     *
     * @param id 站点配置ID
     * @return 结果
     */
    public int deleteTWebSiteById(Long id);

    /**
     * 批量删除站点配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTWebSiteByIds(String[] ids);

    /**
     * 统计总数
     * @return
     */
    public int countList();

}
