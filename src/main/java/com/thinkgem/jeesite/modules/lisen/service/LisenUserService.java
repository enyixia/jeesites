/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.lisen.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.lisen.entity.LisenUser;
import com.thinkgem.jeesite.modules.lisen.dao.LisenUserDao;

/**
 * 立森用户Service
 * @author cw
 * @version 2018-05-11
 */
@Service
@Transactional(readOnly = true)
public class LisenUserService extends CrudService<LisenUserDao, LisenUser> {

	public LisenUser get(String id) {
		return super.get(id);
	}
	
	public List<LisenUser> findList(LisenUser lisenUser) {
		return super.findList(lisenUser);
	}
	
	public Page<LisenUser> findPage(Page<LisenUser> page, LisenUser lisenUser) {
		return super.findPage(page, lisenUser);
	}
	
	@Transactional(readOnly = false)
	public void save(LisenUser lisenUser) {
		super.save(lisenUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(LisenUser lisenUser) {
		super.delete(lisenUser);
	}
	
}