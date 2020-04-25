package com.ruoyi.web.controller.system;

import java.util.List;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提现记录Controller
 *
 * @author ruoyi
 * @date 2020-04-22
 */
@Controller
@RequestMapping("/agent/withdrawal")
public class TAgentWithdrawalLogController extends BaseController
{
    private String prefix = "withdrawal";

    @Autowired
    private ITAgentWithdrawalLogService tAgentWithdrawalLogService;
    @Autowired
    private ITAgentService tAgentService;
    @RequiresPermissions("agent:withdrawal:view")
    @GetMapping()
    public String withdrawal(String id, ModelMap mmap)
    {
        mmap.put("agentId", id);
        return prefix + "/withdrawal";
    }

    /**
     * 查询提现记录列表
     */
    @RequiresPermissions("agent:withdrawal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAgentWithdrawalLog tAgentWithdrawalLog)
    {
        startPage();
        List<TAgentWithdrawalLog> list = tAgentWithdrawalLogService.selectTAgentWithdrawalLogList(tAgentWithdrawalLog);
        return getDataTable(list);
    }

    /**
     * 导出提现记录列表
     */
    @RequiresPermissions("agent:withdrawal:export")
    @Log(title = "提现记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TAgentWithdrawalLog tAgentWithdrawalLog)
    {
        List<TAgentWithdrawalLog> list = tAgentWithdrawalLogService.selectTAgentWithdrawalLogList(tAgentWithdrawalLog);
        ExcelUtil<TAgentWithdrawalLog> util = new ExcelUtil<TAgentWithdrawalLog>(TAgentWithdrawalLog.class);
        return util.exportExcel(list, "withdrawal");
    }

    /**
     * 新增提现记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存提现记录
     */
    @RequiresPermissions("agent:withdrawal:add")
    @Log(title = "提现记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAgentWithdrawalLog tAgentWithdrawalLog)
    {
        return toAjax(tAgentWithdrawalLogService.insertTAgentWithdrawalLog(tAgentWithdrawalLog));
    }

    /**
     * 修改提现记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TAgentWithdrawalLog tAgentWithdrawalLog = tAgentWithdrawalLogService.selectTAgentWithdrawalLogById(id);
        mmap.put("tAgentWithdrawalLog", tAgentWithdrawalLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存提现记录
     */
    @RequiresPermissions("agent:withdrawal:edit")
    @Log(title = "提现记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAgentWithdrawalLog tAgentWithdrawalLog)
    {
        TAgent tAgent =tAgentService.selectTAgentById(tAgentWithdrawalLog.getProxyId());
        if (tAgent!=null){
            TAgent t = new TAgent();
            t.setBalance(tAgent.getBalance()-tAgentWithdrawalLog.getMoney());
            t.setId(tAgent.getId());
            tAgentService.updateTAgent(t);
        }
        return toAjax(tAgentWithdrawalLogService.updateTAgentWithdrawalLog(tAgentWithdrawalLog));
    }

    /**
     * 删除提现记录
     */
    @RequiresPermissions("agent:withdrawal:remove")
    @Log(title = "提现记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tAgentWithdrawalLogService.deleteTAgentWithdrawalLogByIds(ids));
    }
}
