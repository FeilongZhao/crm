package com.lcu.service.Impl;

import com.lcu.dao.UserDao;
import com.lcu.dao.Impl.UserDaoImpl;
import com.lcu.domain.User;
import com.lcu.service.UserService;
import com.lcu.utils.HibernateUtil;

public class UserServiceImpl implements UserService {

    private UserDao ud;

    public User login(User user) {
        
        
        HibernateUtil.getCurrentSession().beginTransaction();
        
        User existU = ud .getByUserCode(user.getUser_code());
        
        HibernateUtil.getCurrentSession().getTransaction().commit();
        if (existU == null) {
            throw new RuntimeException("用户名不存在");
        }
        if (!existU.getUser_password().equals(user.getUser_password()) ) {
            throw new RuntimeException("密码错误");
        }
        return existU;
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    
}
