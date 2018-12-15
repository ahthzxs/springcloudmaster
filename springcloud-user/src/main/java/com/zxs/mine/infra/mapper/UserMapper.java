package com.zxs.mine.infra.mapper;

import com.zxs.mine.domain.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    //注解方式
    @Select("select * from user where login_name = #{login_name}")
    List selectByLoginName(String login_name);

    //select * from user where id in ( ${ids} )

    //xml文件方式
    List selectByLoginName2(String login_name);

    List<User> selectByIds(List keys);

    User findById(int id);
}
