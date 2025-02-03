package co.jp.mamol.myapp.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import co.jp.mamol.myapp.dto.UserDto;

@Results({ @Result(name = "error", location = "/WEB-INF/jsp/error.jsp") })
public class BaseAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private String message;

	private boolean messageflag;

	// requestログイン状態確認
	public boolean requestLoginCheck() {
		UserDto loginUser = getLoginUser();

		if (loginUser == null) {
			return false;
		} else if (loginUser.getRole_class().equals("1")) {
			return true;
		} else {
			return false;
		}

	}

	// approvalログイン状態確認
	public boolean approvalLoginCheck() {
		UserDto loginUser = getLoginUser();

		if (loginUser == null) {
			return false;
		} else if (loginUser.getRole_class().equals("2")) {
			return true;
		} else {
			return false;
		}

	}

	// orderログイン状態確認
	public boolean orderLoginCheck() {
		UserDto loginUser = getLoginUser();

		if (loginUser == null) {
			return false;
		} else if (loginUser.getRole_class().equals("3")) {
			return true;
		} else if (loginUser.getRole_class().equals("5")) {
			return true;
		} else {
			return false;
		}
	}

	// storeログイン状態確認
	public boolean storeLoginCheck() {
		UserDto loginUser = getLoginUser();

		if (loginUser == null) {
			return false;
		} else if (loginUser.getRole_class().equals("4")) {
			return true;
		} else {
			return false;
		}
	}

	// セッション設定
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// セッション取得
	public Map<String, Object> getSession() {
		return session;
	}

	// 表示メッセージ取得
	public String getMessage() {
		return message;
	}

	// 表示メッセージ設定
	public void setMessage(String message, boolean messageflag) {
		this.message = message;
		this.messageflag = messageflag;
	}

	// ログインユーザ情報取得
	public UserDto getLoginUser() {
		UserDto loginInfo = (UserDto) session.get("loginInfo");
		return loginInfo;
	}

	// ログインユーザ情報設定
	public void setLoginInfo(UserDto loginInfo) {
		session.put("loginInfo", loginInfo);
	}

	public boolean isMessageflag() {
		return messageflag;
	}
}
