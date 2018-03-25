package com.lcu.dao.Impl;



import org.hibernate.Query;
import org.hibernate.Session;
import com.lcu.dao.UserDao;
import com.lcu.domain.User;
import com.lcu.utils.HibernateUtil;

public class UserDaoImpl implements UserDao {

    private User uniqueResult;

    public User getByUserCode(String user_code) {

        
        Session session = HibernateUtil.getCurrentSession();
        String hql = "from User where user_code = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, user_code);
        uniqueResult = (User) query.uniqueResult();
        
        return uniqueResult;
    }

}
