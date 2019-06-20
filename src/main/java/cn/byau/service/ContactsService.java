package cn.byau.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.byau.dao.ContactsMapper;
import cn.byau.pojo.Contacts;
import cn.byau.pojo.ContactsExample;

@Service("contactsService")
public class ContactsService {
	@Resource
	private ContactsMapper contactsdao;
	
	public List<Contacts> list(){
		ContactsExample example = new ContactsExample();
		example.setOrderByClause("contactsNo asc");
		return contactsdao.selectByExample(example);
	}
	
	public boolean deleteContacts(String contactsNo) {
		return contactsdao.deleteByPrimaryKey(contactsNo)==1;
	}
	
	public boolean insertContacts(Contacts contacts) {
		return contactsdao.insertSelective(contacts)==1;
		
	}
	
	public boolean updateContacts(Contacts contacts) {
		return contactsdao.updateByPrimaryKeySelective(contacts)==1;
	}
	
	public Contacts getContacts(String contactsNo) {
		return contactsdao.selectByPrimaryKey(contactsNo);
	}
	
	public PageInfo<Contacts> listByPage(Integer page, Integer rows){
		PageHelper.startPage(page, rows);
		List<Contacts> list = list();
		PageInfo<Contacts> pageInfo = new PageInfo<>(list);
		return pageInfo;
		
	}
	
}
