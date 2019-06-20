package cn.byau.controller.admin;

import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.byau.pojo.Loginfo;
import cn.byau.service.LogInfoService;

@Controller
@RequestMapping("/admin/loginfo")
public class LoginfoController {

	@Resource(name="loginfoService")
	private LogInfoService logInfoService;
	
	@RequestMapping("/listByPage")
	public String listByPage(@RequestParam(defaultValue="1",required=false)Integer pageNum,
			@RequestParam(defaultValue="5",required=false)Integer pageSize,Model model,String startTime,String endTime,HttpServletRequest request) throws ParseException {
		PageInfo<Loginfo> pageInfo = logInfoService.listByPage(pageNum, pageSize, startTime, endTime);
		model.addAttribute("pageInfo", pageInfo);
		HttpSession session = request.getSession();
		session.setAttribute("startTime", startTime);
		session.setAttribute("endTime", endTime);
		return "/admin/loginfo/list.jsp";
		
	}
}
