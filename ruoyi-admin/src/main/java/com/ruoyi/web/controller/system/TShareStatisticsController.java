package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.share.TAgentShareLog;
import com.ruoyi.system.service.share.ITAgentShareLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分佣记录Controller
 *
 * @author ruoyi
 * @date 2020-04-21
 */
@Controller
@RequestMapping("/statistics/share")
public class TShareStatisticsController extends BaseController
{
    private String prefix = "shareStatistics";

    @Autowired
    private ITAgentShareLogService tAgentShareLogService;

    @RequiresPermissions("statistics:share:view")
    @GetMapping()
    public String log(String id, ModelMap mmap)
    {
        mmap.put("agentId", id);
        mmap.put("shareDay", tAgentShareLogService.shareDay());
        mmap.put("shareYesterday", tAgentShareLogService.shareYesterday());
        mmap.put("shareMonth", tAgentShareLogService.shareMonth());
        mmap.put("shareTotal", tAgentShareLogService.shareTotal());
        return prefix + "/list";
    }

    /**
     * 查询分佣记录列表
     */
    @RequiresPermissions("statistics:share:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAgentShareLog tAgentShareLog)
    {
        startPage();
        List<TAgentShareLog> list = tAgentShareLogService.selectTAgentShareLogList(tAgentShareLog);
        return getDataTable(list);
    }

}
