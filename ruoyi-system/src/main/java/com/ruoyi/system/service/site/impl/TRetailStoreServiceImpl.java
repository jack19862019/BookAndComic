package com.ruoyi.system.service.site.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.site.TWebSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TRetailStoreMapper;
import com.ruoyi.system.domain.site.TRetailStore;
import com.ruoyi.system.service.site.ITRetailStoreService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.util.CollectionUtils;

/**
 * 分销配置Service业务层处理
 *
 * @author lucifer
 * @date 2020-04-11
 */
@Service
public class TRetailStoreServiceImpl implements ITRetailStoreService
{
    @Autowired
    private TRetailStoreMapper tRetailStoreMapper;

    /**
     * 查询分销配置
     *
     * @param id 分销配置ID
     * @return 分销配置
     */
    @Override
    public TRetailStore selectTRetailStoreById(Long id)
    {
        return tRetailStoreMapper.selectTRetailStoreById(id);
    }

    /**
     * 查询分销配置列表
     *
     * @param tRetailStore 分销配置
     * @return 分销配置
     */
    @Override
    public List<TRetailStore> selectTRetailStoreList(TRetailStore tRetailStore)
    {
        return tRetailStoreMapper.selectTRetailStoreList(tRetailStore);
    }

    /**
     * 新增分销配置
     *
     * @param tRetailStore 分销配置
     * @return 结果
     */
    @Override
    public int insertTRetailStore(TRetailStore tRetailStore)
    {
        int countNum = tRetailStoreMapper.countList();
        if (countNum>0){
            throw new BusinessException("分销配置已经存在，不允许新增第二条！");
        }
        tRetailStore.setCreateTime(DateUtils.getNowDate());
        return tRetailStoreMapper.insertTRetailStore(tRetailStore);
    }

    /**
     * 修改分销配置
     *
     * @param tRetailStore 分销配置
     * @return 结果
     */
    @Override
    public int updateTRetailStore(TRetailStore tRetailStore)
    {
        tRetailStore.setUpdateTime(DateUtils.getNowDate());
        return tRetailStoreMapper.updateTRetailStore(tRetailStore);
    }

    /**
     * 删除分销配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTRetailStoreByIds(String ids)
    {
        return tRetailStoreMapper.deleteTRetailStoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分销配置信息
     *
     * @param id 分销配置ID
     * @return 结果
     */
    @Override
    public int deleteTRetailStoreById(Long id)
    {
        return tRetailStoreMapper.deleteTRetailStoreById(id);
    }
}
