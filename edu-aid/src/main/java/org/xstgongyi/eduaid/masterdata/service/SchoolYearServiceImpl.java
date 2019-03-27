/**
 * Copyright (c) 2019 xstgongyi.org
 * All rights reserved.
 */
package org.xstgongyi.eduaid.masterdata.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.xstgongyi.eduaid.masterdata.dao.SchoolYearMapper;
import org.xstgongyi.eduaid.masterdata.dataobject.SchoolYearDO;

/**
 * @author oldcrane<br/>
 * @created 2019-03-27
 */
@Service
@CacheConfig(cacheNames="schoolyear")
public class SchoolYearServiceImpl implements SchoolYearService {

	@Autowired
	private SchoolYearMapper dao;
	
	@Override
	@CacheEvict(allEntries=true)
	public void insert(String name, String active) {
		// TODO 此处需要增加逻辑，检查name是否重复
		// TODO 需要增加异常处理逻辑
		SchoolYearDO schoolYear = new SchoolYearDO();
		schoolYear.setName(name);
		schoolYear.setActive(active);
		LocalDateTime now = LocalDateTime.now();
		schoolYear.setGmtCreated(now);
		schoolYear.setGmtUpdated(now);
		dao.insert(schoolYear);
	}

	@Override
	@CacheEvict(allEntries=true)
	public void update(Integer id, String name, String active) {
		// TODO name重复检查，异常处理逻辑
		SchoolYearDO schoolYear = new SchoolYearDO();
		schoolYear.setId(id);
		schoolYear.setName(name);
		schoolYear.setActive(active);
		schoolYear.setGmtUpdated(LocalDateTime.now());
		dao.update(schoolYear);
		// TODO 如果no row updated，如何处理？Exception，还是忽略？
	}

	@Override
	@Cacheable(key="'list-all'")
	public List<SchoolYearDO> listAll() {
		return dao.listAll();
	}

	@Override
	@Cacheable(key="'list-' + #active")
	public List<SchoolYearDO> listByStatus(String active) {
		return dao.listAllByStatus(active);
	}

	@Override
	@Cacheable(key="#id")
	public SchoolYearDO getById(Integer id) {
		return dao.getById(id);
	}

	
}
