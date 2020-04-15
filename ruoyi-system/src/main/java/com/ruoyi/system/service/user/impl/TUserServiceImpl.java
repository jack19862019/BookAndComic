package com.ruoyi.system.service.user.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.user.TUser;
import com.ruoyi.system.mapper.TUserMapper;
import com.ruoyi.system.service.user.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户基本信息Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-15
 */
@Service
public class TUserServiceImpl implements ITUserService
{
    @Autowired
    private TUserMapper tUserMapper;

    /**
     * 查询用户基本信息
     *
     * @param id 用户基本信息ID
     * @return 用户基本信息
     */
    @Override
    public TUser selectTUserById(Long id)
    {
        return tUserMapper.selectTUserById(id);
    }

    /**
     * 查询用户基本信息列表
     *
     * @param tUser 用户基本信息
     * @return 用户基本信息
     */
    @Override
    public List<TUser> selectTUserList(TUser tUser)
    {
        return tUserMapper.selectTUserList(tUser);
    }

    /**
     * 新增用户基本信息
     *
     * @param tUser 用户基本信息
     * @return 结果
     */
    @Override
    public int insertTUser(TUser tUser)
    {
        tUser.setCreateTime(DateUtils.getNowDate());
        return tUserMapper.insertTUser(tUser);
    }

    /**
     * 修改用户基本信息
     *
     * @param tUser 用户基本信息
     * @return 结果
     */
    @Override
    public int updateTUser(TUser tUser)
    {
        tUser.setUpdateTime(DateUtils.getNowDate());
        return tUserMapper.updateTUser(tUser);
    }

    /**
     * 删除用户基本信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTUserByIds(String ids)
    {
        return tUserMapper.deleteTUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户基本信息信息
     *
     * @param id 用户基本信息ID
     * @return 结果
     */
    @Override
    public int deleteTUserById(Long id)
    {
        return tUserMapper.deleteTUserById(id);
    }
}
