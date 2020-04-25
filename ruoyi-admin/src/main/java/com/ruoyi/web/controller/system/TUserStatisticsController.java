package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.agent.TAgent;
import com.ruoyi.system.domain.user.TUser;
import com.ruoyi.system.service.agent.ITAgentService;
import com.ruoyi.system.service.user.ITUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户基本信息Controller
 *
 * @author ruoyi
 * @date 2020-04-15
 */
@Controller
@RequestMapping("/statistics/user")
public class TUserStatisticsController extends BaseController
{
    private String prefix = "/userStatistics";

    @Autowired
    private ITUserService tUserService;
    @Autowired
    private ITAgentService tAgentService;

    @RequiresPermissions("statistics:user:view")
    @GetMapping()
    public String user(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        TUser tUser = new TUser();
        if(tAgent!=null){
            tUser.setProxyId(tAgent.getId());
        }
        mmap.put("userDay", tUserService.userDay(tUser));
        mmap.put("userYesterday", tUserService.userYesterday(tUser));
        mmap.put("userMonth", tUserService.userMonth(tUser));
        mmap.put("userTotal", tUserService.userTotal(tUser));
        return prefix + "/list";
    }

    /**
     * 查询用户基本信息列表
     */
    @RequiresPermissions("statistics:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TUser tUser)
    {
        startPage();
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        if(tAgent!=null){
            tUser.setProxyId(tAgent.getId());
        }
        List<TUser> list = tUserService.selectTUserList(tUser);
        return getDataTable(list);
    }

}
