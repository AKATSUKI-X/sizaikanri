package co.jp.mamol.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.UserDao;
import co.jp.mamol.myapp.dto.UserDto;
@Service
public class LoginService {
	@Autowired
	UserDao userDao;

	public UserDto findUser(String userid) {
		return userDao.findUserById(userid);
	}

}
