/**
 * Copyright (c) 2019 xstgongyi.org
 * All rights reserved.
 */
package org.xstgongyi.eduaid.masterdata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.xstgongyi.eduaid.masterdata.dataobject.SchoolYearDO;

/**
 * @author oldcrane
 * @created 2019-03-26
 */
@Mapper
public interface SchoolYearMapper {

	List<SchoolYearDO> listAll();

	List<SchoolYearDO> listAllByStatus(String active);

	SchoolYearDO getById(Integer id);
	
	/**
	 * @return number of rows added.
	 */
	int insert(SchoolYearDO schoolYear);

	/**
	 * @return number of rows modified.
	 */
	int update(SchoolYearDO schoolYear);

}
