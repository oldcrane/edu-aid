/**
 * Copyright (c) 2019 xstgongyi.org
 * All rights reserved.
 */
package org.xstgongyi.eduaid.master.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xstgongyi.eduaid.masterdata.dataobject.SchoolYearDO;
import org.xstgongyi.eduaid.masterdata.service.SchoolYearService;

/**
 * @author oldcrane<br/>
 * @created 2019-03-27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolYearServiceTest {
	
	@Autowired
	private SchoolYearService schoolYearService;

	@Test
	public void checkIfCacheEnabled( ) {
		int id = 2;
		SchoolYearDO obj01 = schoolYearService.getById(id);
		// 执行第二遍，看是否执行sql
		schoolYearService.getById(id);
		
		List<SchoolYearDO> allList01 = schoolYearService.listAll();
		// 执行第二遍，看是否执行sql
		schoolYearService.listAll();

		SchoolYearDO objFromList = allList01.get(0);
		System.out.println("list.get(0):" + objFromList);
		System.out.println("getById:" + obj01);
		System.out.println("用==比较：" + (obj01==objFromList));
		
		// update某一条记录，应清除所有缓存
		int updateObjId = 1;
		String active = "N";
		SchoolYearDO updateObj = schoolYearService.getById(updateObjId);	
		schoolYearService.update(updateObjId, updateObj.getName(), active);
		
		// 检查sql是否被执行
		schoolYearService.getById(id);
		schoolYearService.listAll();
	}

}
