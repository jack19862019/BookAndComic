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
import com.ruoyi.system.domain.share.TAgentShareLog;
import com.ruoyi.system.domain.user.TUser;
import com.ruoyi.system.service.agent.ITAgentService;
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
    @Autowired
    private ITAgentService tAgentService;

    @RequiresPermissions("statistics:share:view")
    @GetMapping()
    public String log(String id, ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        TAgentShareLog tAgentShareLog = new TAgentShareLog();
        if(tAgent!=null){
            tAgentShareLog.setProxyId(tAgent.getId());
        }

        mmap.put("agentId", id);
        mmap.put("shareDay", tAgentShareLogService.shareDay(tAgentShareLog));
        mmap.put("shareYesterday", tAgentShareLogService.shareYesterday(tAgentShareLog));
        mmap.put("shareMonth", tAgentShareLogService.shareMonth(tAgentShareLog));
        mmap.put("shareTotal", tAgentShareLogService.shareTotal(tAgentShareLog));
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
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        if(tAgent!=null){
            tAgentShareLog.setProxyId(tAgent.getId());
        }
        List<TAgentShareLog> list = tAgentShareLogService.selectTAgentShareLogList(tAgentShareLog);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setcMoney(Math.ceil(list.get(i).getcMoney()*(1-tAgent.getRatio())));
        }
        return getDataTable(list);
    }

}
