package cn.byau.controller.admin;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import cn.byau.pojo.User;
import cn.byau.service.UserService;
import cn.byau.util.CommonUtils;

@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController {

	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/updatePassword",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String updatePassword(HttpServletRequest request,String password,String oldPassword ) throws NoSuchAlgorithmException {
		HttpSession session  = request.getSession();
		User user =(User) session.getAttribute("user");
		if((CommonUtils.getMD5(oldPassword)).equals(user.getPassword())) {
			User u  = new User();
			u.setPassword(CommonUtils.getMD5(password));
			u.setUserID(user.getUserID());
			
			if(userService.updateUser(u)) {
				user.setPassword(CommonUtils.getMD5(password));
				session.setAttribute("user", user);
				return "修改密码成功";
			}else {
				return "修改密码失败";
			}
		} else {
			return "原密码错误";
		}
		
	}
	
	@RequestMapping("/listUserAndContacts")
	public String listUserAndContacts(Model model) {
		List<User> list = userService.listUserAndContacts();
		model.addAttribute("list", list);
		return "/admin/user/list.jsp";
	}
	
	
}
