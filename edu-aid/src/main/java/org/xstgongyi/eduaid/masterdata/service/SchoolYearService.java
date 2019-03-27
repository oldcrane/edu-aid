/**
 * Copyright (c) 2019 xstgongyi.org
 * All rights reserved.
 */
package org.xstgongyi.eduaid.masterdata.service;

import java.util.List;

import org.xstgongyi.eduaid.masterdata.dataobject.SchoolYearDO;

/**
 * @author oldcrane<br/>
 * @created 2019-03-27
 * 
 * 主数据这类简单业务对象，service层的作用：1.提供面向业务的方法接口，2.缓存。
 * 简单业务对象，业务层和数据层使用同一个POJO，简化处理。根据需要可各建一个数据对象。
 */
public interface SchoolYearService {
	
	void insert(String name, String active);
	
	void update(Integer id, String name, String active);

	List<SchoolYearDO> listAll();
	
	List<SchoolYearDO> listByStatus(String active);
	
	SchoolYearDO getById(Integer id);
}
