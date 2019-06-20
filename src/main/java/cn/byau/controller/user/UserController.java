package cn.byau.controller.user;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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

@Controller
@RequestMapping("/user/user")
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
	
	@RequestMapping("toUpdateUser")
	public String toUpdateUser(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		return "/user/user/update.jsp";
	}
	
	
	@RequestMapping("updateUser")
	@ResponseBody
	public String updateUser(MultipartFile file,User user,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String path = request.getSession().getServletContext().getRealPath("/upload");
		String name = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString().replace("-", "").toUpperCase()+name.substring(name.lastIndexOf("."));
		String savePath = path +File.separator+fileName;
		File f = new File(savePath);
		file.transferTo(f);
		System.out.println("上传地址："+savePath);
		String photo = request.getContextPath()+File.separator+"upload"+File.separator+fileName;
		user.setPhoto(photo);
		if(userService.updateUser(user)) {
			User u = (User)session.getAttribute("user");
			u.setPhoto(photo);
			u.setEmail(user.getEmail());
			u.setUserName(user.getUserName());
			return "OK";
		}else {
			return "";
		}
		
	}
}
