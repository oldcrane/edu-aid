/**
 * Copyright (c) 2019 xstgongyi.org
 * All rights reserved.
 */
package org.xstgongyi.eduaid;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author oldcrane<br/>
 * @created 2019-03-27
 */
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("org", "xstgongyi.org");
		model.put("name", "小石头公益");
		return "home";
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "Test：Controller直接返回responseBody，无需jsp/模板文件。";
	}

}
