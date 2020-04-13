package com.ruoyi.system.service.site.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TWebSiteMapper;
import com.ruoyi.system.domain.site.TWebSite;
import com.ruoyi.system.service.site.ITWebSiteService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.util.CollectionUtils;

/**
 * 站点配置Service业务层处理
 *
 * @author lucifer
 * @date 2020-04-11
 */
@Service
public class TWebSiteServiceImpl implements ITWebSiteService
{
    @Autowired
    private TWebSiteMapper tWebSiteMapper;

    /**
     * 查询站点配置
     *
     * @param id 站点配置ID
     * @return 站点配置
     */
    @Override
    public TWebSite selectTWebSiteById(Long id)
    {
        return tWebSiteMapper.selectTWebSiteById(id);
    }

    /**
     * 查询站点配置列表
     *
     * @param tWebSite 站点配置
     * @return 站点配置
     */
    @Override
    public List<TWebSite> selectTWebSiteList(TWebSite tWebSite)
    {
        return tWebSiteMapper.selectTWebSiteList(tWebSite);
    }

    /**
     * 新增站点配置
     *
     * @param tWebSite 站点配置
     * @return 结果
     */
    @Override
    public int insertTWebSite(TWebSite tWebSite)
    {
        List<TWebSite> tWebSites = tWebSiteMapper.selectTWebSiteList(null);
        if (!CollectionUtils.isEmpty(tWebSites)){
            throw new BusinessException("站点配置已经存在，不允许新增第二条！");
        }
        tWebSite.setCreateTime(DateUtils.getNowDate());
        return tWebSiteMapper.insertTWebSite(tWebSite);
    }

    /**
     * 修改站点配置
     *
     * @param tWebSite 站点配置
     * @return 结果
     */
    @Override
    public int updateTWebSite(TWebSite tWebSite)
    {
        tWebSite.setUpdateTime(DateUtils.getNowDate());
        return tWebSiteMapper.updateTWebSite(tWebSite);
    }

    /**
     * 删除站点配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTWebSiteByIds(String ids)
    {
        return tWebSiteMapper.deleteTWebSiteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除站点配置信息
     *
     * @param id 站点配置ID
     * @return 结果
     */
    @Override
    public int deleteTWebSiteById(Long id)
    {
        return tWebSiteMapper.deleteTWebSiteById(id);
    }
}
