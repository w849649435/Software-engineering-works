package cn.byau.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.byau.dao.LoginfoMapper;
import cn.byau.pojo.Loginfo;
import cn.byau.pojo.LoginfoExample;



@Service("loginfoService")
@Transactional
public class LogInfoService {
	@Resource
	private LoginfoMapper loginfodao;

	public void save(Loginfo loginfo) {
		loginfodao.insertSelective(loginfo);
	}


	  
    /**
     *   这个方法中用到了分页插件pagehelper
     *   很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @param pageNum 开始页数
     * @param pageSize 每页显示的数据条数
     * @param hm 封装了 查询的起始日期和截止额日期
     * @return
     * @throws ParseException 
     */
	
	public PageInfo<Loginfo> listByPage(Integer pageNum, Integer pageSize,String startTime,String endTime) throws ParseException {
		 //将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNum, pageSize);
		List<Loginfo> list = loginfodao.listLoginfoAndUser(startTime,endTime);
		PageInfo<Loginfo> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
