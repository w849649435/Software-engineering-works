package cn.byau.dao;

import cn.byau.pojo.Contacts;
import cn.byau.pojo.ContactsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactsMapper {
    int countByExample(ContactsExample example);

    int deleteByExample(ContactsExample example);

    int deleteByPrimaryKey(String contactsNo);

    int insert(Contacts record);

    int insertSelective(Contacts record);

    List<Contacts> selectByExample(ContactsExample example);

    Contacts selectByPrimaryKey(String contactsNo);

    int updateByExampleSelective(@Param("record") Contacts record, @Param("example") ContactsExample example);

    int updateByExample(@Param("record") Contacts record, @Param("example") ContactsExample example);

    int updateByPrimaryKeySelective(Contacts record);

    int updateByPrimaryKey(Contacts record);
}