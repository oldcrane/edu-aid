/**
 * Copyright (c) 2019 xstgongyi.org
 * All rights reserved.
 */
package org.xstgongyi.eduaid.masterdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xstgongyi.eduaid.masterdata.service.SchoolYearService;

/**
 * @author oldcrane<br/>
 * @created 2019-03-27
 */
@Controller
public class SchoolYearController {
	@Autowired
	private SchoolYearService schoolYearService;
	
	@RequestMapping("/masterdata/schoolyear/entry")
	public String entryPage(ModelMap map) {
		map.put("title", "This is a test title");
		map.put("schoolYearList", schoolYearService.listAll());
		
		return "masterdata/school_year";
	}
	
	// TODO 是否需要VO？
	
	// list整合为1个
	
	// add
	
	// upate
}
