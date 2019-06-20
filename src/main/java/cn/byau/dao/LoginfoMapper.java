package cn.byau.dao;

import cn.byau.pojo.Loginfo;
import cn.byau.pojo.LoginfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginfoMapper {
    int countByExample(LoginfoExample example);

    int deleteByExample(LoginfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Loginfo record);

    int insertSelective(Loginfo record);

    List<Loginfo> selectByExample(LoginfoExample example);

    Loginfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Loginfo record, @Param("example") LoginfoExample example);

    int updateByExample(@Param("record") Loginfo record, @Param("example") LoginfoExample example);

    int updateByPrimaryKeySelective(Loginfo record);

    int updateByPrimaryKey(Loginfo record);
    
    List<Loginfo> listLoginfoAndUser(@Param("startTime")String startTime,@Param("endTime")String endTime);
}