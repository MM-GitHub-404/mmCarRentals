package com.mm.service.impl;

import com.mm.dao.AdminMapper;
import com.mm.dao.CarInfoMapper;
import com.mm.entity.Admin;
import com.mm.entity.AdminExample;
import com.mm.entity.CarInfo;
import com.mm.service.AdminService;
import com.mm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 茂茂
 * @create 2022-02-11 16:42
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String userName, String passWord) {
        //首先创建对象,封装查询条件
        AdminExample ae = new AdminExample();
        ae.createCriteria().andANameEqualTo(userName);
        List<Admin> list = adminMapper.selectByExample(ae);
        if (list.size() > 0) {
            Admin admin = list.get(0);
            //通过MD5Util加密后与数据库中密码对比
            String pw = MD5Util.getMD5(passWord);
            if (pw.equals(admin.getaPass())) {
                return admin;
            }
        }
        return null;
    }

}
