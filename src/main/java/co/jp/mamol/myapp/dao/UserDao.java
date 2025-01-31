package co.jp.mamol.myapp.dao;

import co.jp.mamol.myapp.dto.UserDto;

public interface UserDao {
	//ユーザ情報取得
	public UserDto findUserById(String userid);

}
