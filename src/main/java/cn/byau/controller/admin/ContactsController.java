package cn.byau.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

import cn.byau.pojo.Contacts;
import cn.byau.service.ContactsService;
import cn.byau.util.Result;

@Controller
@RequestMapping("/admin/contacts")
public class ContactsController {
	@Resource(name="contactsService")
	private ContactsService contactsService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Contacts> list = contactsService.list();
		model.addAttribute("list",list);
		return "/admin/contacts/list.jsp";
	}
	
	@RequestMapping("/getDataGrid")
	public void datagrid(Integer page, Integer rows, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");   //请求跨域
        response.setContentType("text/json;charset=UTF-8");
		PageInfo<Contacts> pageInfo=contactsService.listByPage(page, rows);
		long total=pageInfo.getTotal();
		ObjectMapper mapper = new ObjectMapper();
		// 返回JSON格式的响应
			try {
				String json = "{\"total\":"+total+",\"rows\":" + mapper.writeValueAsString(pageInfo.getList())  + "}";
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	
	
	@RequestMapping("/save")
	@ResponseBody
	public Result save(Contacts contacts) {
		Result result = new Result();
		if(contactsService.getContacts(contacts.getContactsNo())==null){
			
				if(contactsService.insertContacts(contacts)) {
					result.setMsg("OK");
				}else {
					 result.setMsg("FAIL"); 
				}
			
		}else {
			 result.setMsg("院系ID重复");
		}
		return result;
	

	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Result update(Contacts contacts) {
		Result result = new Result();
		
			if(contactsService.updateContacts(contacts)) {
				result.setMsg("OK");
			}else {
				 result.setMsg("FAIL"); 
			}
  
		return result;
		

	}
	

	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(String contactsNo) {
		Result result = new Result();
	
			if(contactsService.deleteContacts(contactsNo)) {
				result.setMsg("OK");
			}else {
				result.setMsg("FAIL");
			}
		
		return result;
	}
	
	@RequestMapping("/toupdate/{contactsNo}")
	public String toupdate(@PathVariable("contactsNo") String contactsNo,Model model) {
		Contacts d = contactsService.getContacts(contactsNo);
		model.addAttribute("c", d);
		return "/admin/contacts/update.jsp";
	}
}
