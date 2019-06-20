package cn.byau.service;

import cn.byau.dao.UserMapper;
import cn.byau.pojo.User;
import cn.byau.pojo.UserExample;
import cn.byau.util.CommonUtils;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserService {
	@Resource
	private UserMapper userdao;
	
	public User getUserByUserNameAndPassword(Map map) throws NoSuchAlgorithmException{
		User user = userdao.selectByPrimaryKey((String)map.get("userName"));
		if(user.getPassword().equals(CommonUtils.getMD5((String)map.get("password")))) {
			return user;
		}
		return null;			
	}
	
	public boolean updateUser(User user) {
		return userdao.updateByPrimaryKeySelective(user)==1;
	}
	
	public List<User> listUserAndContacts(){
		return userdao.listUserAndContacts();
	}
	
}
