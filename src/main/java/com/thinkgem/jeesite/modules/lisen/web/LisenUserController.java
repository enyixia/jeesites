/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.lisen.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.lisen.entity.LisenUser;
import com.thinkgem.jeesite.modules.lisen.service.LisenUserService;

/**
 * 立森用户Controller
 * @author cw
 * @version 2018-05-11
 */
@Controller
@RequestMapping(value = "${adminPath}/lisen/lisenUser")
public class LisenUserController extends BaseController {

	@Autowired
	private LisenUserService lisenUserService;
	
	@ModelAttribute
	public LisenUser get(@RequestParam(required=false) String id) {
		LisenUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = lisenUserService.get(id);
		}
		if (entity == null){
			entity = new LisenUser();
		}
		return entity;
	}
	
	@RequiresPermissions("lisen:lisenUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(LisenUser lisenUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<LisenUser> page = lisenUserService.findPage(new Page<LisenUser>(request, response), lisenUser); 
		model.addAttribute("page", page);
		return "modules/lisen/lisenUserList";
	}

	@RequiresPermissions("lisen:lisenUser:view")
	@RequestMapping(value = "form")
	public String form(LisenUser lisenUser, Model model) {
		model.addAttribute("lisenUser", lisenUser);
		return "modules/lisen/lisenUserForm";
	}

	@RequiresPermissions("lisen:lisenUser:edit")
	@RequestMapping(value = "save")
	public String save(LisenUser lisenUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, lisenUser)){
			return form(lisenUser, model);
		}
		lisenUserService.save(lisenUser);
		addMessage(redirectAttributes, "保存用户信息成功");
		return "redirect:"+Global.getAdminPath()+"/lisen/lisenUser/?repage";
	}
	
	@RequiresPermissions("lisen:lisenUser:edit")
	@RequestMapping(value = "delete")
	public String delete(LisenUser lisenUser, RedirectAttributes redirectAttributes) {
		lisenUserService.delete(lisenUser);
		addMessage(redirectAttributes, "删除用户信息成功");
		return "redirect:"+Global.getAdminPath()+"/lisen/lisenUser/?repage";
	}

}