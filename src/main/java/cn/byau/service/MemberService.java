package cn.byau.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.byau.dao.MemberMapper;
import cn.byau.pojo.Member;
import cn.byau.pojo.MemberExample;

@Service("memberService")

public class MemberService {

	@Resource
	private MemberMapper memberdao;
	
	public PageInfo<Member> getMemberBycontactsNo(int pageNum,int pageSize,String contactsNo,String keyword){
		PageHelper.startPage(pageNum, pageSize);
		List<Member> list = memberdao.MemberAndContacts(keyword);
		PageInfo<Member>  pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	public PageInfo<Member> getJiaoshiAll(int pageNum,int pageSize,String keyword){
		PageHelper.startPage(pageNum, pageSize);
		List<Member> list = memberdao.MemberAndContacts(keyword);
		PageInfo<Member>  pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	public Member getMember(String memberid) {
		return memberdao.selectByPrimaryKey(Integer.parseInt(memberid));
	}
	
	public boolean insertJiaoshi(Member member) {
		return memberdao.insertSelective(member)==1;
	}
	
	public boolean updateJiaoshi(Member member) {
		return memberdao.updateByPrimaryKeySelective(member)==1;
	}
	
	public boolean batchdeletemember(String[] memberids) {
		int sum=0;
		for(int i=0;i<memberids.length;i++) {
			if(memberdao.deleteByPrimaryKey(Integer.parseInt(memberids[i]))==1) {
				sum++;
			}
		}
		return memberids.length==sum;
		
	}
	
	public HSSFWorkbook getHSSFWorkbook(String keyword) {
		List<Member> memberList = memberdao.MemberAndContacts(keyword);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("member");
		String[] title = { "信息编号", "用户名", "标题", "邮件", "内容", "日期", "会员编号"};
		HSSFRow titleRow = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		for(int i=0;i<title.length;i++) {
			HSSFCell titleCell=titleRow.createCell(i);
			titleCell.setCellValue(title[i]);
			titleCell.setCellStyle(style);
		}		
		for(int i=0;i<memberList.size();i++) {
			HSSFRow row = sheet.createRow(i+1);
			row.createCell(0).setCellValue(i+1);
			row.createCell(1).setCellValue(memberList.get(i).getMemberid());
            row.createCell(2).setCellValue(memberList.get(i).getUsername());
            row.createCell(3).setCellValue(memberList.get(i).getTitle());
            row.createCell(4).setCellValue(memberList.get(i).getEmail());
            row.createCell(5).setCellValue(memberList.get(i).getContext());
            row.createCell(6).setCellValue(memberList.get(i).getMagdate());
            row.createCell(7).setCellValue(memberList.get(i).getContactsNo());
		}		
		for (int i = 0; i < title.length; i++) {
			sheet.autoSizeColumn(i, true);
			sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 15 / 10);
		}		
		return workbook;
	}
	
	@Transactional
	public boolean importMemberFromExcel(File f) {
		boolean flag = true;
		try {
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(f));
			HSSFSheet memberSheet = wb.getSheetAt(0);
			for (Row row : memberSheet) {
				if (row.getRowNum() < 1) {
					continue;
				}
				int memberid = (int) row.getCell(1).getNumericCellValue();
				String username = row.getCell(2).toString().trim();
				String title = row.getCell(3).toString().trim();
				String email = row.getCell(4).toString().trim();
				String context = row.getCell(5).toString().trim();
				String magdate = row.getCell(6).toString().trim();
				String contactsNo = row.getCell(7).toString().trim();
				Member member = new Member(memberid,username,title,email,context,magdate,contactsNo);
				if(insertJiaoshi(member)) {
					
				}else {
					flag = false;
				}
			}
			wb.close();
		} catch (Exception e) {
			
			flag = false;
		}
		
		return flag;

	}
}
