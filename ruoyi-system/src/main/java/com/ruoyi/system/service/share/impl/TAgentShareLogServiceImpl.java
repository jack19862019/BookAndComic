package com.ruoyi.system.service.share.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.share.TAgentShareLog;
import com.ruoyi.system.service.share.ITAgentShareLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TAgentShareLogMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 分佣记录Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-21
 */
@Service
public class TAgentShareLogServiceImpl implements ITAgentShareLogService
{
    @Autowired
    private TAgentShareLogMapper tAgentShareLogMapper;

    /**
     * 查询分佣记录
     *
     * @param id 分佣记录ID
     * @return 分佣记录
     */
    @Override
    public TAgentShareLog selectTAgentShareLogById(Long id)
    {
        return tAgentShareLogMapper.selectTAgentShareLogById(id);
    }

    /**
     * 查询分佣记录列表
     *
     * @param tAgentShareLog 分佣记录
     * @return 分佣记录
     */
    @Override
    public List<TAgentShareLog> selectTAgentShareLogList(TAgentShareLog tAgentShareLog)
    {
        return tAgentShareLogMapper.selectTAgentShareLogList(tAgentShareLog);
    }

    /**
     * 新增分佣记录
     *
     * @param tAgentShareLog 分佣记录
     * @return 结果
     */
    @Override
    public int insertTAgentShareLog(TAgentShareLog tAgentShareLog)
    {
        tAgentShareLog.setCreateTime(DateUtils.getNowDate());
        return tAgentShareLogMapper.insertTAgentShareLog(tAgentShareLog);
    }

    /**
     * 修改分佣记录
     *
     * @param tAgentShareLog 分佣记录
     * @return 结果
     */
    @Override
    public int updateTAgentShareLog(TAgentShareLog tAgentShareLog)
    {
        tAgentShareLog.setUpdateTime(DateUtils.getNowDate());
        return tAgentShareLogMapper.updateTAgentShareLog(tAgentShareLog);
    }

    /**
     * 删除分佣记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAgentShareLogByIds(String ids)
    {
        return tAgentShareLogMapper.deleteTAgentShareLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分佣记录信息
     *
     * @param id 分佣记录ID
     * @return 结果
     */
    @Override
    public int deleteTAgentShareLogById(Long id)
    {
        return tAgentShareLogMapper.deleteTAgentShareLogById(id);
    }

    @Override
    public Double shareDay() {
        return tAgentShareLogMapper.shareDay();
    }

    @Override
    public Double shareYesterday() {
        return tAgentShareLogMapper.shareYesterday();
    }

    @Override
    public Double shareMonth() {
        return tAgentShareLogMapper.shareMonth();
    }

    @Override
    public Double shareTotal() {
        return tAgentShareLogMapper.shareTotal();
    }
}
