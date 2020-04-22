package com.ruoyi.system.service.user.impl;

import com.ruoyi.system.domain.user.TUser;
import com.ruoyi.system.domain.user.params.TUserDetail;
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
public class TUserServiceImpl implements ITUserService {
    @Autowired
    private TUserMapper tUserMapper;

    /**
     * 查询用户基本信息
     *
     * @param id 用户基本信息ID
     * @return 用户基本信息
     */
    @Override
    public TUser selectTUserById(Long id) {
        return tUserMapper.selectTUserById(id);
    }

    @Override
    public String selectUserUpOneLevel(Long id) {
        return tUserMapper.selectUserUpOneLevel(id);
    }


    @Override
    public String selectUserUpTwoLevel(Long id) {
        return tUserMapper.selectUserUpTwoLevel(id);
    }
    /**
     * 查询用户基本信息列表
     *
     * @param tUser 用户基本信息
     * @return 用户基本信息
     */
    @Override
    public List<TUser> selectTUserList(TUser tUser) {
        return tUserMapper.selectTUserList(tUser);
    }

    @Override
    public Integer userDay() {
        return tUserMapper.userDay();
    }

    @Override
    public Integer userYesterday() {
        return tUserMapper.userYesterday();
    }

    @Override
    public Integer userMonth() {
        return tUserMapper.userMonth();
    }

    @Override
    public Integer userTotal() {
        return tUserMapper.userTotal();
    }

}
