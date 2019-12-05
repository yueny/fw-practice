package com.yueny.fw.controller;

import com.yueny.fw.manager.IUserLoginManager;
import com.yueny.fw.practice.files.read.IOReader;
import com.yueny.fw.practice.files.read.NIOReader;
import com.yueny.fw.practice.files.write.IOFileAppender;
import com.yueny.fw.practice.files.write.NIOFileAppender;
import com.yueny.rapid.lang.agent.UserAgentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年2月16日 下午8:23:11
 *
 */
@RestController
// 跨域处理，加下类上则对所有方法生效
@CrossOrigin(origins = "*", maxAge = 3600)
public class DemoController {
	@Autowired
	private IUserLoginManager userLoginManager;

	@Autowired
	private NIOFileAppender nioFileAppender;
	@Autowired
	private IOFileAppender ioFileAppender;
	@Autowired
	private NIOReader nioReader;
	@Autowired
	private IOReader ioReader;

	/**
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String bar(HttpServletRequest request, UserAgentResource currentUserAgentResource) {
		String token = request.getHeader("token");
		boolean rs = userLoginManager.login("hello");

		UserAgentResource userAgent = (UserAgentResource)request.getAttribute("currentUserAgentResource");

//		// allocate 4M space
//		byte[] b = new byte[4 * 1024 * 1024];
//		System.out.println("first allocate");


		return "welcome:" + rs;
	}

	/**
	 * 文件md5
	 */
	@RequestMapping(value = "/file/md5", method = RequestMethod.GET)
	public String md5(HttpServletRequest request, String filePathName) {
		Long count = 100000000L;

		try {
//            write(filePathName, count);

//            reader(filePathName);

		}catch (Exception e){
			e.printStackTrace();
		}


		return ioReader.md5(filePathName);
	}

	/**
	 * 文件写
	 */
	@RequestMapping(value = "/file/write", method = RequestMethod.GET)
	public String write(HttpServletRequest request, String filePathName, Long count) {
		try {
			ioFileAppender.write(filePathName, count);
//            nioFileAppender.write(filePathName, count);
//            reader(filePathName);

		}catch (Exception e){
			e.printStackTrace();
		}

		return "ok";
	}

	/**
	 * 文件读取
	 */
	@RequestMapping(value = "/file/reader", method = RequestMethod.GET)
	public String reader(HttpServletRequest request, String filePathName) {
		Long count = 0L;
		try {
			count = ioReader.read(filePathName);
//			count = nioReader.read(filePathName);
			System.out.println("总数量：" + count);
		}catch (Exception e){
			e.printStackTrace();
		}

		return "总数量：" + count;
	}

}
