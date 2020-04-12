package com.ruoyi.web.controller.system.site;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.site.TRechargeConfig;
import com.ruoyi.system.service.site.ITRechargeConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 充值赠送配置Controller
 *
 * @author ruoyi
 * @date 2020-04-11
 */
@Controller
@RequestMapping("/change/config")
public class TRechargeConfigController extends BaseController {
    private String prefix = "change/config";

    @Autowired
    private ITRechargeConfigService tRechargeConfigService;

    @RequiresPermissions("change:config:view")
    @GetMapping()
    public String config() {
        return prefix + "/config";
    }

    /**
     * 查询充值赠送配置列表
     */
    @RequiresPermissions("change:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TRechargeConfig tRechargeConfig) {
        startPage();
        List<TRechargeConfig> list = tRechargeConfigService.selectTRechargeConfigList(tRechargeConfig);
        return getDataTable(list);
    }

    /**
     * 新增充值赠送配置
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存充值赠送配置
     */
    @RequiresPermissions("change:config:add")
    @Log(title = "充值赠送配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TRechargeConfig tRechargeConfig) {
        return toAjax(tRechargeConfigService.insertTRechargeConfig(tRechargeConfig));
    }

    /**
     * 修改充值赠送配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TRechargeConfig tRechargeConfig = tRechargeConfigService.selectTRechargeConfigById(id);
        mmap.put("tRechargeConfig", tRechargeConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存充值赠送配置
     */
    @RequiresPermissions("change:config:edit")
    @Log(title = "充值赠送配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TRechargeConfig tRechargeConfig) {
        return toAjax(tRechargeConfigService.updateTRechargeConfig(tRechargeConfig));
    }

    /**
     * 删除充值赠送配置
     */
    @RequiresPermissions("change:config:remove")
    @Log(title = "充值赠送配置", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tRechargeConfigService.deleteTRechargeConfigByIds(ids));
    }
}
