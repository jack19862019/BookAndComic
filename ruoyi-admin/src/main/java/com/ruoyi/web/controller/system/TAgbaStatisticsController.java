package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.agent.TAgentBalanceLog;
import com.ruoyi.system.service.agent.ITAgentBalanceLogService;
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

    @RequiresPermissions("statistics:agba:view")
    @GetMapping()
    public String log( ModelMap mmap)
    {
        mmap.put("topUpDay", tAgentBalanceLogService.topUpDay());
        mmap.put("topUpYesterday", tAgentBalanceLogService.topUpYesterday());
        mmap.put("topUpMonth", tAgentBalanceLogService.topUpMonth());
        mmap.put("topUpTotal", tAgentBalanceLogService.topUpTotal());
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
        List<TAgentBalanceLog> list = tAgentBalanceLogService.selectTAgentBalanceLogList(tAgentBalanceLog);
        return getDataTable(list);
    }

}
