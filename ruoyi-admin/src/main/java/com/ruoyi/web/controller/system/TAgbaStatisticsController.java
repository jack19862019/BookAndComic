package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.agent.TAgbaParams;
import com.ruoyi.system.domain.agent.TAgent;
import com.ruoyi.system.domain.agent.TAgentBalanceLog;
import com.ruoyi.system.domain.share.TAgentShareLog;
import com.ruoyi.system.service.agent.ITAgentBalanceLogService;
import com.ruoyi.system.service.agent.ITAgentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 代理用户充值记录Controller
 *
 * @author ruoyi
 * @date 2020-04-19
 */
@Controller
@RequestMapping("/statistics/agba")
public class TAgbaStatisticsController extends BaseController
{
    private String prefix = "agbaStatistics";

    @Autowired
    private ITAgentBalanceLogService tAgentBalanceLogService;
    @Autowired
    private ITAgentService tAgentService;

    @RequiresPermissions("statistics:agba:view")
    @GetMapping()
    public String log( ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        TAgentBalanceLog tAgentBalanceLog = new TAgentBalanceLog();
        if(tAgent!=null){
            tAgentBalanceLog.setProxyId(tAgent.getId());
        }
        List<TAgbaParams> topUpDay = tAgentBalanceLogService.topUpDay(tAgentBalanceLog);
        for (int i = 0; i < topUpDay.size(); i++) {
            double ceil = Math.ceil(topUpDay.get(i).getMoney() * (1 - tAgent.getRatio()));
           topUpDay.get(i).setMoney(ceil);
        }
        List<TAgbaParams> topUpYesterday = tAgentBalanceLogService.topUpYesterday(tAgentBalanceLog);
        for (int i = 0; i < topUpYesterday.size(); i++) {
            double ceil = Math.ceil(topUpYesterday.get(i).getMoney() * (1 - tAgent.getRatio()));
            topUpYesterday.get(i).setMoney(ceil);
        }
        List<TAgbaParams> topUpMonth =  tAgentBalanceLogService.topUpMonth(tAgentBalanceLog);
        for (int i = 0; i < topUpMonth.size(); i++) {
            double ceil = Math.ceil(topUpMonth.get(i).getMoney() * (1 - tAgent.getRatio()));
            topUpMonth.get(i).setMoney(ceil);
        }
        List<TAgbaParams> topUpTotal= tAgentBalanceLogService.topUpTotal(tAgentBalanceLog);
        for (int i = 0; i < topUpTotal.size(); i++) {
            double ceil = Math.ceil(topUpTotal.get(i).getMoney() * (1 - tAgent.getRatio()));
            topUpTotal.get(i).setMoney(ceil);
        }
        mmap.put("topUpDay", topUpDay);
        mmap.put("topUpYesterday", topUpYesterday);
        mmap.put("topUpMonth", topUpMonth);
        mmap.put("topUpTotal", topUpTotal);
        return prefix + "/list";
    }

    /**
     * 查询充值记录列表
     */
    @RequiresPermissions("statistics:agba:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAgentBalanceLog tAgentBalanceLog)
    {
        startPage();
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        if(tAgent!=null){
            tAgentBalanceLog.setProxyId(tAgent.getId());
        }

        List<TAgentBalanceLog> list = tAgentBalanceLogService.selectTAgentBalanceLogList(tAgentBalanceLog);
        for (int i = 0; i < list.size(); i++) {
            TAgentBalanceLog log = list.get(i);
            double ceil = Math.ceil(list.get(i).getMoney() * (1 - tAgent.getRatio()));
            log.setMoney(ceil);
        }
        return getDataTable(list);
    }

}
