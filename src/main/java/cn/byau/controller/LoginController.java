package cn.byau.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.byau.pojo.Loginfo;
import cn.byau.pojo.User;
import cn.byau.service.LogInfoService;
import cn.byau.service.UserService;
import cn.byau.util.CommonUtils;

@Controller
public class LoginController {

	@Resource(name="userService")
	private UserService userService;
	@Resource(name="loginfoService")
	private LogInfoService loginfoService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userName, String password, HttpServletRequest request, HttpServletResponse response,Model model)
			throws IOException, NoSuchAlgorithmException {
		HashMap<String, String> map = new HashMap<String, String>();
		HttpSession session = request.getSession();
		map.put("userName", userName);
		map.put("password", password);
        String r1=""; 
		User user = userService.getUserByUserNameAndPassword(map);
		if (user != null) {
		if (user.getUserType().equals(CommonUtils.ADMIN_ROLE)) {
			session.setAttribute("user", user);
			session.setAttribute("loginFlag", "adminLogin");
			r1= "redirect:/admin/index.jsp";
		} else if (user.getUserType().equals(CommonUtils.USER_ROlE)){
			session.setAttribute("user", user);
			session.setAttribute("loginFlag", "userLogin");
			r1= "redirect:/user/index.jsp";
		}
			String ua = request.getHeader("User-Agent");
			String shebei ="未知设备登录";
			if (ua.indexOf("Android") != -1) {
				shebei="安卓端登录";
		        
			} else if (ua.indexOf("iPhone") != -1 || ua.indexOf("iPad") != -1) {
				shebei="苹果端登录";
		    
			} else {   
				shebei="PC端登录";
			}
			Date date = new Date();
			loginfoService.save(new Loginfo(userName,date,shebei,"进行登录",CommonUtils.getRemortIP(request)));
		}else {
				model.addAttribute("msg", "用户名或密码错误");
				r1="redirect:/login.jsp";
			  }
			return r1;
		}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		// 清除Session
		HttpSession session = request.getSession();
		session.invalidate();
		// 重定向到登录页面的跳转方法
		return "redirect:/login.jsp";
	}
	/**
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	public String loginPage() {
		return "redirect:/login.jsp";
	}
}
