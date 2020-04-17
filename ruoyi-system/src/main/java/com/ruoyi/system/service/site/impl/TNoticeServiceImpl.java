package com.ruoyi.system.service.site.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.site.TNotice;
import com.ruoyi.system.service.site.ITNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TNoticeMapper;
import com.ruoyi.common.core.text.Convert;

import java.util.List;

/**
 * 公告管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-17
 */
@Service
public class TNoticeServiceImpl implements ITNoticeService
{
    @Autowired
    private TNoticeMapper tNoticeMapper;

    /**
     * 查询公告管理
     * 
     * @param id 公告管理ID
     * @return 公告管理
     */
    @Override
    public TNotice selectTNoticeById(Long id)
    {
        return tNoticeMapper.selectTNoticeById(id);
    }

    /**
     * 查询公告管理列表
     * 
     * @param tNotice 公告管理
     * @return 公告管理
     */
    @Override
    public List<TNotice> selectTNoticeList(TNotice tNotice)
    {
        return tNoticeMapper.selectTNoticeList(tNotice);
    }

    /**
     * 新增公告管理
     * 
     * @param tNotice 公告管理
     * @return 结果
     */
    @Override
    public int insertTNotice(TNotice tNotice)
    {
        tNotice.setCreateTime(DateUtils.getNowDate());
        return tNoticeMapper.insertTNotice(tNotice);
    }

    /**
     * 修改公告管理
     * 
     * @param tNotice 公告管理
     * @return 结果
     */
    @Override
    public int updateTNotice(TNotice tNotice)
    {
        tNotice.setUpdateTime(DateUtils.getNowDate());
        return tNoticeMapper.updateTNotice(tNotice);
    }

    /**
     * 删除公告管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTNoticeByIds(String ids)
    {
        return tNoticeMapper.deleteTNoticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公告管理信息
     * 
     * @param id 公告管理ID
     * @return 结果
     */
    @Override
    public int deleteTNoticeById(Long id)
    {
        return tNoticeMapper.deleteTNoticeById(id);
    }
}
