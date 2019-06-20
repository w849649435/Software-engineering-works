package cn.byau.controller.admin;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;


import cn.byau.pojo.Contacts;
import cn.byau.pojo.Member;
import cn.byau.service.ContactsService;
import cn.byau.service.MemberService;
import cn.byau.util.Result;

@Controller("adminMemberController")
@RequestMapping("/admin/member")
public class MemberController {
	@Resource(name="contactsService")
	private ContactsService contactsService;
	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue="1",required=false) Integer pageNum,
					   @RequestParam(defaultValue="6",required=false) Integer pageSize,
					   @RequestParam(defaultValue="",required=false) String keyword,Model model) {
		PageInfo<Member> pageInfo = memberService.getJiaoshiAll(pageNum, pageSize, keyword);
		model.addAttribute("pageInfo",pageInfo);
		HttpSession session = request.getSession();
		session.setAttribute("keyword",keyword);
		return "/admin/member/list.jsp";
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public Result save(Member member) {
		Result result = new Result();

				if(memberService.insertJiaoshi(member)) {
					result.setMsg("OK");
				}else {
					 result.setMsg("FAIL"); 
				}
		return result;
	

	}
	
	@RequestMapping("/tosave")
	public String tosave(Model model) {
		List<Contacts> list = contactsService.list();
		model.addAttribute("list", list);	
		return "/admin/member/save.jsp";
	

	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Result update(Member member) {
		Result result = new Result();
		
			if(memberService.updateJiaoshi(member)) {
				result.setMsg("OK");
			}else {
				 result.setMsg("FAIL"); 
			}
  
		return result;
		

	}
	

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public Result delete(String ids) {
		Result result = new Result();
		String[] s = ids.split(",");
		if(memberService.batchdeletemember(s)) {
			result.setMsg("OK");
		}else {
			result.setMsg("FAIL"); 	
		}

		return result;
	}
	
	@RequestMapping("/toupdate/{memberid}")
	public String toupdate(@PathVariable("memberid") String memberid,Model model) {
		Member member = memberService.getMember(memberid);
		model.addAttribute("m", member);
		List<Contacts> list = contactsService.list();
		model.addAttribute("list", list);
		return "/admin/member/update.jsp";
	}
	
	@RequestMapping("/exportExcel")
	public void exportExcel(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		response.setHeader("content-disposition","attachment;filename=Member.xls");
		HttpSession session = request.getSession();
		String keyword = (String) session.getAttribute("keyword");
		HSSFWorkbook wb = memberService.getHSSFWorkbook(keyword);
		ServletOutputStream out = response.getOutputStream();
		wb.write(out);
		out.close();
	}
	
	@RequestMapping("/importFile")
	public String importFile(MultipartFile file,Model model,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String path = request.getSession().getServletContext().getRealPath("/upload");
		String name = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase()+name.substring(name.lastIndexOf("."));
		String savePath = path+File.separator+fileName;
		File f = new File(savePath);
		System.out.println("上传路径:"+savePath);
		try {
			file.transferTo(f);
			if(memberService.importMemberFromExcel(f)) {
				model.addAttribute("msg", "上传成功！导入数据库成功");
			}else {
				model.addAttribute("msg", "上传成功！导入数据库失败");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "上传出错！");
			e.printStackTrace();
		} 
		
		return "/admin/member/upload.jsp";
	}
	
}
