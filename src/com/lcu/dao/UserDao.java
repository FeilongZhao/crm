package com.lcu.dao;

import com.lcu.domain.User;

public interface UserDao {

    User getByUserCode(String user_code);

}
