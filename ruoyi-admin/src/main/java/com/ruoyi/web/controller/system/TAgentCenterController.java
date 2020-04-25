package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.agent.TAgent;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.agent.ITAgentService;
import com.ruoyi.web.controller.system.resp.TAgentParams;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/business/center")
public class TAgentCenterController extends BaseController
{
    private String prefix = "/center";

    @Autowired
    private ITAgentService tAgentService;

    @RequiresPermissions("business:center:view")
    @GetMapping()
    public String agent( ModelMap mmap)
    {
        SysUser user = ShiroUtils.getSysUser();
        TAgent tAgent =tAgentService.selectTAgentByProxyNickName(user.getLoginName());
        if (tAgent!=null){
            mmap.put("tAgent", tAgent);
        }else{
            mmap.put("tAgent", new TAgent());
        }
        return prefix + "/list";
    }


    @RequiresPermissions("business:center:edit")
    @Log(title = "代理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAgent tAgent)
    {
        return toAjax(tAgentService.updateTAgent(tAgent));
    }
}
