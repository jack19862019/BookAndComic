package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.site.TExceptionalConfig;
import com.ruoyi.system.service.site.ITExceptionalConfigService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 打赏配置Controller
 *
 * @author ruoyi
 * @date 2020-04-11
 */
@Controller
@RequestMapping("/exceptional/config")
public class TExceptionalConfigController extends BaseController
{
    private String prefix = "exceptional/config";

    @Autowired
    private ITExceptionalConfigService tExceptionalConfigService;

    @RequiresPermissions("exceptional:config:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/config";
    }

    /**
     * 查询打赏配置列表
     */
    @RequiresPermissions("exceptional:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TExceptionalConfig tExceptionalConfig)
    {
        startPage();
        List<TExceptionalConfig> list = tExceptionalConfigService.selectTExceptionalConfigList(tExceptionalConfig);
        return getDataTable(list);
    }

    /**
     * 导出打赏配置列表
     */
    @RequiresPermissions("exceptional:config:export")
    @Log(title = "打赏配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TExceptionalConfig tExceptionalConfig)
    {
        List<TExceptionalConfig> list = tExceptionalConfigService.selectTExceptionalConfigList(tExceptionalConfig);
        ExcelUtil<TExceptionalConfig> util = new ExcelUtil<TExceptionalConfig>(TExceptionalConfig.class);
        return util.exportExcel(list, "config");
    }

    /**
     * 新增打赏配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存打赏配置
     */
    @RequiresPermissions("exceptional:config:add")
    @Log(title = "打赏配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TExceptionalConfig tExceptionalConfig)
    {
        return toAjax(tExceptionalConfigService.insertTExceptionalConfig(tExceptionalConfig));
    }

    /**
     * 修改打赏配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TExceptionalConfig tExceptionalConfig = tExceptionalConfigService.selectTExceptionalConfigById(id);
        mmap.put("tExceptionalConfig", tExceptionalConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存打赏配置
     */
    @RequiresPermissions("exceptional:config:edit")
    @Log(title = "打赏配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TExceptionalConfig tExceptionalConfig)
    {
        return toAjax(tExceptionalConfigService.updateTExceptionalConfig(tExceptionalConfig));
    }

    /**
     * 删除打赏配置
     */
    @RequiresPermissions("exceptional:config:remove")
    @Log(title = "打赏配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tExceptionalConfigService.deleteTExceptionalConfigByIds(ids));
    }
}
