package com.ruoyi.web.controller.system;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.agent.TAgent;
import com.ruoyi.system.domain.withdrawal.TAgentWithdrawalLog;
import com.ruoyi.system.service.agent.ITAgentService;
import com.ruoyi.system.service.withdrawal.ITAgentWithdrawalLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 提现记录Controller
 *
 * @author ruoyi
 * @date 2020-04-22
 */
@Controller
@RequestMapping("/agent/proxy")
public class TAgentProxyWithdrawalLogController extends BaseController
{
    private String prefix = "proxy";

    @Autowired
    private ITAgentWithdrawalLogService tAgentWithdrawalLogService;
    @Autowired
    private ITAgentService tAgentService;

    @RequiresPermissions("agent:proxy:view")
    @GetMapping()
    public String proxy(String id, ModelMap mmap)
    {
        mmap.put("agentId", id);
        return prefix + "/list";
    }

    /**
     * 查询提现记录列表
     */
    @RequiresPermissions("agent:proxy:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAgentWithdrawalLog tAgentWithdrawalLog)
    {
        startPage();
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        if(tAgent!=null){
            tAgentWithdrawalLog.setProxyId(tAgent.getId());
        }
        List<TAgentWithdrawalLog> list = tAgentWithdrawalLogService.selectTAgentWithdrawalLogList(tAgentWithdrawalLog);
        return getDataTable(list);
    }

    /**
     * 新增提现记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        if (tAgent!=null){
            mmap.put("balance", tAgent.getBalance());
            mmap.put("proxyId", tAgent.getId());
        }else{
            mmap.put("balance", 0);
            mmap.put("proxyId", 0);
        }
        return prefix + "/add";
    }

    /**
     * 新增保存提现记录
     */
    @RequiresPermissions("agent:proxy:add")
    @Log(title = "新增提现", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAgentWithdrawalLog tAgentWithdrawalLog)
    {
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        if (tAgent!=null){
            tAgentWithdrawalLog.setProxyId(tAgent.getId());
        }
        tAgentWithdrawalLog.setOrderNo("No"+System.currentTimeMillis());
        tAgentWithdrawalLog.setStatus(Long.valueOf(0));
        return toAjax(tAgentWithdrawalLogService.insertTAgentWithdrawalLog(tAgentWithdrawalLog));
    }
}
