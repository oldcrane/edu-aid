/**
 * Copyright (c) 2019 xstgongyi.org
 * All rights reserved.
 */
package org.xstgongyi.eduaid.masterdata.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xstgongyi.eduaid.masterdata.dataobject.SchoolYearDO;
import org.xstgongyi.eduaid.masterdata.service.SchoolYearService;

/**
 * @author oldcrane<br/>
 * @created 2019-03-27
 */
@Controller
public class SchoolYearController {
	@Autowired
	private SchoolYearService schoolYearService;

	@GetMapping("/masterdata/schoolyear/entry")
	public String entryPage(ModelMap map) {
		// map.put("schoolYearList", schoolYearService.listAll());
		return "masterdata/school_year";
	}

	@GetMapping("/masterdata/schoolyear/list")
	@ResponseBody
	public Map<String, Object> list(@ModelAttribute("active") String active) {
		// check parameter
		active = null == active ? null : active.trim();
		List<SchoolYearDO> schoolYearList = null;

		if (null == active || active.isEmpty()) {
			schoolYearList = schoolYearService.listAll();
		} else {
			schoolYearList = schoolYearService.listByStatus(active);
		}

		return assembleResponse(0, schoolYearList, "");
	}

	@PostMapping("/masterdata/schoolyear/add")
	@ResponseBody
	public Map<String, Object> add(@RequestBody SchoolYearDO schoolYear) {
		if (null == schoolYear) {
			return (assembleResponse(1, null, "非法输入：要添加的学年参数为空对象。"));
		}
		schoolYearService.insert(schoolYear.getName(), schoolYear.getActive());
		return assembleResponse(0, "", "");
	}

	// update
	@PostMapping("/masterdata/schoolyear/update")
	@ResponseBody
	public Map<String, Object> update(@RequestBody SchoolYearDO schoolYear) {
		if (null == schoolYear) {
			return (assembleResponse(1, null, "非法输入：要添加的学年参数为空对象。"));
		}
		schoolYearService.update(schoolYear.getId(), schoolYear.getName(), schoolYear.getActive());
		return assembleResponse(0, "", "");
	}

	private Map<String, Object> assembleResponse(int code, Object result, String message) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("data", result);
		map.put("message", message);
		return map;
	}
}
