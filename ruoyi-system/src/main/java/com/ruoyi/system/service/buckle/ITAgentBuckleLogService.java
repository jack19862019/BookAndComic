package com.ruoyi.system.service.buckle;

import com.ruoyi.system.domain.buckle.TAgentBuckleLog;

import java.util.List;

/**
 * 扣量记录Service接口
 *
 * @author ruoyi
 * @date 2020-04-21
 */
public interface ITAgentBuckleLogService
{
    /**
     * 查询扣量记录
     *
     * @param id 扣量记录ID
     * @return 扣量记录
     */
    public TAgentBuckleLog selectTAgentBuckleLogById(Long id);

    /**
     * 查询扣量记录列表
     *
     * @param tAgentBuckleLog 扣量记录
     * @return 扣量记录集合
     */
    public List<TAgentBuckleLog> selectTAgentBuckleLogList(TAgentBuckleLog tAgentBuckleLog);

    /**
     * 新增扣量记录
     *
     * @param tAgentBuckleLog 扣量记录
     * @return 结果
     */
    public int insertTAgentBuckleLog(TAgentBuckleLog tAgentBuckleLog);

    /**
     * 修改扣量记录
     *
     * @param tAgentBuckleLog 扣量记录
     * @return 结果
     */
    public int updateTAgentBuckleLog(TAgentBuckleLog tAgentBuckleLog);

    /**
     * 批量删除扣量记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAgentBuckleLogByIds(String ids);

    /**
     * 删除扣量记录信息
     *
     * @param id 扣量记录ID
     * @return 结果
     */
    public int deleteTAgentBuckleLogById(Long id);
}
