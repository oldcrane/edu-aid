/**
 * Copyright (c) 2019 xstgongyi.org
 * All rights reserved.
 */
package org.xstgongyi.eduaid.masterdata.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xstgongyi.eduaid.masterdata.dataobject.SchoolYearDO;

/**
 * @author oldcrane
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolYearMapperTest {

	@Autowired
	private SchoolYearMapper dao;

	@Test
	public void listAll() {
		List<SchoolYearDO> schoolYearList = dao.listAll();
		Assert.assertNotNull(schoolYearList);
		for(SchoolYearDO item : schoolYearList) {
			System.out.println(item);
		}
	}

	@Test
	public void insert() {
		SchoolYearDO schoolYear = new SchoolYearDO();
		schoolYear.setActive("Y");
		schoolYear.setName("2016-2017学年");
		LocalDateTime now = LocalDateTime.now();
		schoolYear.setGmtCreated(now);
		schoolYear.setGmtUpdated(now);
		
		int num = dao.insert(schoolYear);
		System.out.println("rows added:" + num);
		System.out.println(schoolYear);
	}

	@Test
	public void update() {
		int id = 1;
		SchoolYearDO schoolYear = dao.getById(id);	
		Assert.assertNotNull(schoolYear);
		
		schoolYear.setActive("N");
		schoolYear.setGmtUpdated(LocalDateTime.now());
		
		int num = dao.update(schoolYear);
		Assert.assertEquals(1, num);		
	}

}
