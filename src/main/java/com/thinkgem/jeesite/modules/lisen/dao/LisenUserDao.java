/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.lisen.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.lisen.entity.LisenUser;

/**
 * 立森用户DAO接口
 * @author cw
 * @version 2018-05-11
 */
@MyBatisDao
public interface LisenUserDao extends CrudDao<LisenUser> {
	
}