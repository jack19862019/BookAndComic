package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.system.domain.agent.TAgent;
import com.ruoyi.system.service.agent.ITAgentService;
import com.ruoyi.web.controller.system.resp.TAgentParams;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
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
 * 代理Controller
 *
 * @author ruoyi
 * @date 2020-04-19
 */
@Controller
@RequestMapping("/business/agent")
public class TAgentController extends BaseController
{
    private String prefix = "ag";

    @Autowired
    private ITAgentService tAgentService;

    @RequiresPermissions("business:agent:view")
    @GetMapping()
    public String agent()
    {
        return prefix + "/list";
    }

    /**
     * 查询代理列表
     */
    @RequiresPermissions("business:agent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAgent tAgent)
    {
        startPage();
        List<TAgent> list = tAgentService.selectTAgentList(tAgent);
        List<TAgentParams> listParams = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)){
            for (TAgent agent : list){
                TAgentParams params = new TAgentParams();
                BeanUtils.copyProperties(agent, params);
                params.setSeparate(agent.getSeparate()+"%");
                listParams.add(params);
            }
        }
        return getDataTable(listParams);
    }

    /**
     * 导出代理列表
     */
    @RequiresPermissions("business:agent:export")
    @Log(title = "代理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TAgent tAgent)
    {
        List<TAgent> list = tAgentService.selectTAgentList(tAgent);
        ExcelUtil<TAgent> util = new ExcelUtil<TAgent>(TAgent.class);
        return util.exportExcel(list, "agent");
    }

    /**
     * 新增代理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存代理
     */
    @RequiresPermissions("business:agent:add")
    @Log(title = "代理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAgent tAgent)
    {
        return toAjax(tAgentService.insertTAgent(tAgent));
    }

    /**
     * 修改代理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TAgent tAgent = tAgentService.selectTAgentById(id);
        mmap.put("tAgent", tAgent);
        return prefix + "/edit";
    }

    /**
     * 修改保存代理
     */
    @RequiresPermissions("business:agent:edit")
    @Log(title = "代理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAgent tAgent)
    {
        return toAjax(tAgentService.updateTAgent(tAgent));
    }

    /**
     * 删除代理
     */
    @RequiresPermissions("business:agent:remove")
    @Log(title = "代理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tAgentService.deleteTAgentByIds(ids));
    }
}
