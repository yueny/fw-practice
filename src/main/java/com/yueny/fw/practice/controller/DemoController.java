package com.yueny.fw.practice.controller;

import com.yueny.fw.practice.manager.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年2月16日 下午8:23:11
 *
 */
@RestController
public class DemoController {
	@Autowired
	private IUserLoginManager userLoginManager;

	/**
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String bar() {
		boolean rs = userLoginManager.login("hello");

//		// allocate 4M space
//		byte[] b = new byte[4 * 1024 * 1024];
//		System.out.println("first allocate");


		return "welcome:" + rs;
	}

}
