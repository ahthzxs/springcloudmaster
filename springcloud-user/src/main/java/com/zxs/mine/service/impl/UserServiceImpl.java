package com.zxs.mine.service.impl;

import com.zxs.mine.api.dto.UserDto;
import com.zxs.mine.domain.User;
import com.zxs.mine.infra.mapper.UserMapper;
import com.zxs.mine.service.UserService;
import com.zxs.mine.service.impl.utils.ParamsUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@CacheConfig(cacheNames="users")
public class UserServiceImpl  implements UserService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> searchByCondition(User user) {

        List<User> data =  userMapper.select(user);
        return   data;
//        return userMapper.selectByLoginName("abc23");
//        return userMapper.selectByLoginName2("abc");
    }

    @Override
    public List<User> search(User user) {
        return userMapper.select(user);
    }

    @Cacheable(key="'userCache'")
    @Override
    public int create(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        return this.create(user);
    }

    @Cacheable(key="'userCache'")
    public User findById(int id){
        System.out.println("无缓存的时候调用这里");
        return userMapper.findById(id);
    }

    public int create(User user) {
        if(user == null){
            return 0;
        }
        if (!"".equals(user.getId())) {
            user.setId(null);
        }

        if("".equals(user.getPasswd()) || user.getPasswd()==null){
            user.setPasswd("123456");//设置初始密码123456
        }

        //加密
        String pwd =  DigestUtils.md5DigestAsHex(user.getPasswd().getBytes());
        user.setPasswd(pwd);
        Date date = new Date();
        user.setInputTime(date);
        user.setUpdateTime(date);
        return userMapper.insert(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public Map saveList(List<User> userList) {
        for(User user:userList){
            System.out.println(user);
            this.create(user);
        }
        return null;
    }

    @CacheEvict(key="'userCache'")
    @Override
    public int removeByIds(String[] idArray) {
        if(idArray.length==0){
            return 0 ;
        }

        User user = new User() ;
        for(String i : idArray){
            user.setId(Integer.valueOf(i));
            userMapper.delete(user);
        }

        return 1 ;
    }

    @Override
    public List<User> findByIds(String ids) {
        if("".equals(ids) || ids==null){
            return this.findAll();
        }

        List keys= (List) ParamsUtils.getKeyListByIdStr(ids);
        return userMapper.selectByIds(keys);
    }

    @CachePut(key="'userCache'")
    @Override
    public int updateUser(User user) {
        if("".equals(user.getId())){
            return 0;
        }

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", user.getId());

        return userMapper.updateByExampleSelective(user,example);
    }




}
