package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.vo.UsersVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.UsersMapper;
import com.msyq.psetshop.pojo.Users;

import java.util.List;

@Service
public class UsersService {

    @Resource
    private UsersMapper usersMapper;


    public int deleteByPrimaryKey(Integer uId) {
        return usersMapper.deleteByPrimaryKey(uId);
    }


    public int insert(Users record) {
        return usersMapper.insert(record);
    }


    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }


    public Users selectByPrimaryKey(Integer uId) {
//        UsersVO usersVO =
        return usersMapper.selectByPrimaryKey(uId);
    }


    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

    public List<Users> listByUNote(String uNote) {
        return usersMapper.listByUNote(uNote);
    }


    public PageInfo<Users> findByAll(Users users, Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(usersMapper.findByAll(users));
    }

    public PageInfo<Users> listByAll(Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(usersMapper.listByAll());
    }
}

