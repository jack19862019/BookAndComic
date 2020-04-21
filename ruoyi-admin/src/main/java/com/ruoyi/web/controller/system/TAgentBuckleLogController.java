package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.buckle.TAgentBuckleLog;
import com.ruoyi.system.service.buckle.ITAgentBuckleLogService;
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
 * 扣量记录Controller
 *
 * @author ruoyi
 * @date 2020-04-21
 */
@Controller
@RequestMapping("/buckle/log")
public class TAgentBuckleLogController extends BaseController
{
    private String prefix = "buckle";

    @Autowired
    private ITAgentBuckleLogService tAgentBuckleLogService;

    @RequiresPermissions("buckle:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询扣量记录列表
     */
    @RequiresPermissions("buckle:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAgentBuckleLog tAgentBuckleLog)
    {
        startPage();
        List<TAgentBuckleLog> list = tAgentBuckleLogService.selectTAgentBuckleLogList(tAgentBuckleLog);
        return getDataTable(list);
    }

    /**
     * 导出扣量记录列表
     */
    @RequiresPermissions("buckle:log:export")
    @Log(title = "扣量记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TAgentBuckleLog tAgentBuckleLog)
    {
        List<TAgentBuckleLog> list = tAgentBuckleLogService.selectTAgentBuckleLogList(tAgentBuckleLog);
        ExcelUtil<TAgentBuckleLog> util = new ExcelUtil<TAgentBuckleLog>(TAgentBuckleLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增扣量记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存扣量记录
     */
    @RequiresPermissions("buckle:log:add")
    @Log(title = "扣量记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAgentBuckleLog tAgentBuckleLog)
    {
        return toAjax(tAgentBuckleLogService.insertTAgentBuckleLog(tAgentBuckleLog));
    }

    /**
     * 修改扣量记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TAgentBuckleLog tAgentBuckleLog = tAgentBuckleLogService.selectTAgentBuckleLogById(id);
        mmap.put("tAgentBuckleLog", tAgentBuckleLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存扣量记录
     */
    @RequiresPermissions("buckle:log:edit")
    @Log(title = "扣量记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAgentBuckleLog tAgentBuckleLog)
    {
        return toAjax(tAgentBuckleLogService.updateTAgentBuckleLog(tAgentBuckleLog));
    }

    /**
     * 删除扣量记录
     */
    @RequiresPermissions("buckle:log:remove")
    @Log(title = "扣量记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tAgentBuckleLogService.deleteTAgentBuckleLogByIds(ids));
    }
}
