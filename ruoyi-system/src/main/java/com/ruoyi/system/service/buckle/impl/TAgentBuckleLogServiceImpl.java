package com.ruoyi.system.service.buckle.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.buckle.TAgentBuckleLog;
import com.ruoyi.system.service.buckle.ITAgentBuckleLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TAgentBuckleLogMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 扣量记录Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-21
 */
@Service
public class TAgentBuckleLogServiceImpl implements ITAgentBuckleLogService
{
    @Autowired
    private TAgentBuckleLogMapper tAgentBuckleLogMapper;

    /**
     * 查询扣量记录
     *
     * @param id 扣量记录ID
     * @return 扣量记录
     */
    @Override
    public TAgentBuckleLog selectTAgentBuckleLogById(Long id)
    {
        return tAgentBuckleLogMapper.selectTAgentBuckleLogById(id);
    }

    /**
     * 查询扣量记录列表
     *
     * @param tAgentBuckleLog 扣量记录
     * @return 扣量记录
     */
    @Override
    public List<TAgentBuckleLog> selectTAgentBuckleLogList(TAgentBuckleLog tAgentBuckleLog)
    {
        return tAgentBuckleLogMapper.selectTAgentBuckleLogList(tAgentBuckleLog);
    }

    /**
     * 新增扣量记录
     *
     * @param tAgentBuckleLog 扣量记录
     * @return 结果
     */
    @Override
    public int insertTAgentBuckleLog(TAgentBuckleLog tAgentBuckleLog)
    {
        tAgentBuckleLog.setCreateTime(DateUtils.getNowDate());
        return tAgentBuckleLogMapper.insertTAgentBuckleLog(tAgentBuckleLog);
    }

    /**
     * 修改扣量记录
     *
     * @param tAgentBuckleLog 扣量记录
     * @return 结果
     */
    @Override
    public int updateTAgentBuckleLog(TAgentBuckleLog tAgentBuckleLog)
    {
        tAgentBuckleLog.setUpdateTime(DateUtils.getNowDate());
        return tAgentBuckleLogMapper.updateTAgentBuckleLog(tAgentBuckleLog);
    }

    /**
     * 删除扣量记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAgentBuckleLogByIds(String ids)
    {
        return tAgentBuckleLogMapper.deleteTAgentBuckleLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除扣量记录信息
     *
     * @param id 扣量记录ID
     * @return 结果
     */
    @Override
    public int deleteTAgentBuckleLogById(Long id)
    {
        return tAgentBuckleLogMapper.deleteTAgentBuckleLogById(id);
    }
}
