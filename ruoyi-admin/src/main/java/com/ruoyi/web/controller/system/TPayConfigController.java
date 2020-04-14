package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.site.TPayConfig;
import com.ruoyi.system.service.site.ITPayConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 第三方支付配置Controller
 *
 * @author ruoyi
 * @date 2020-04-11
 */
@Controller
@RequestMapping("/system/tConfig")
public class TPayConfigController extends BaseController {
    private String prefix = "system/tConfig";

    @Autowired
    private ITPayConfigService tPayConfigService;

    @RequiresPermissions("system:tConfig:view")
    @GetMapping()
    public String config() {
        return prefix + "/tConfig";
    }

    /**
     * 查询第三方支付配置列表
     */
    @RequiresPermissions("system:tConfig:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPayConfig tPayConfig) {
        startPage();
        List<TPayConfig> list = tPayConfigService.selectTPayConfigList(tPayConfig);
        return getDataTable(list);
    }

    /**
     * 导出第三方支付配置列表
     */
    @RequiresPermissions("system:tConfig:export")
    @Log(title = "第三方支付配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TPayConfig tPayConfig) {
        List<TPayConfig> list = tPayConfigService.selectTPayConfigList(tPayConfig);
        ExcelUtil<TPayConfig> util = new ExcelUtil<TPayConfig>(TPayConfig.class);
        return util.exportExcel(list, "tConfig");
    }

    /**
     * 新增第三方支付配置
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存第三方支付配置
     */
    @RequiresPermissions("system:tConfig:add")
    @Log(title = "第三方支付配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPayConfig tPayConfig) {
        return toAjax(tPayConfigService.insertTPayConfig(tPayConfig));
    }

    /**
     * 修改第三方支付配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TPayConfig tPayConfig = tPayConfigService.selectTPayConfigById(id);
        mmap.put("tPayConfig", tPayConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存第三方支付配置
     */
    @RequiresPermissions("system:tConfig:edit")
    @Log(title = "第三方支付配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPayConfig tPayConfig) {
        return toAjax(tPayConfigService.updateTPayConfig(tPayConfig));
    }

    /**
     * 删除第三方支付配置
     */
    @RequiresPermissions("system:tConfig:remove")
    @Log(title = "第三方支付配置", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tPayConfigService.deleteTPayConfigByIds(ids));
    }

    /**
     * 用户状态修改
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:tConfig:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(TPayConfig tPayConfig)
    {
        return toAjax(tPayConfigService.changeStatus(tPayConfig));
    }
}
