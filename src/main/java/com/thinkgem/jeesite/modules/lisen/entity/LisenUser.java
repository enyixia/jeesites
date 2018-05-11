/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.lisen.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 立森用户Entity
 * @author cw
 * @version 2018-05-11
 */
public class LisenUser extends DataEntity<LisenUser> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String photo; 	//照片

	public LisenUser() {
		super();
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public LisenUser(String id){
		super(id);
	}

	@Length(min=0, max=255, message="name闀垮害蹇呴』浠嬩簬 0 鍜� 255 涔嬮棿")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}