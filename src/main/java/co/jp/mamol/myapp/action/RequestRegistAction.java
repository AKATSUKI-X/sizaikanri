package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.UserDto;
import co.jp.mamol.myapp.form.RequestRegistForm;
import co.jp.mamol.myapp.service.BuyRequestService;

@Results({
		@Result(name = "requestRegistInit", location = "/WEB-INF/jsp/requestRegist.jsp")
})
public class RequestRegistAction extends BaseAction {

	private RequestRegistForm requestRF = new RequestRegistForm();

	@Autowired
	private BuyRequestService buyRequestS;

	@Action("/requestRegist/init")
	public String requestRegistInit() {
		//requestログイン状態チェック
		if (!requestLoginCheck()) {
			return "error";
		}

		List<CategoryDto> categoryList = buyRequestS.getCategory();
		requestRF.setCategoryList(categoryList);

		return "requestRegistInit";
	}

	@Action("/requestRegist/regist")
	public String requestRegist() {
		//requestログイン状態チェック
		if (!requestLoginCheck()) {
			return "error";
		}

		SizaiDto sizaiDto = requestRF.getSizaiDto();

		if (sizaiDto == null) {
			setMessage("購入依頼を登録してください。", false);
		} else if (StringUtils.isBlank(sizaiDto.getName())) {
			setMessage("資材名を入力してください。", false);
		} else if (sizaiDto.getNum() == 0) {
			setMessage("数量を入力してください。", false);
		}else if (sizaiDto.getNum() < 1 || sizaiDto.getNum() > 999) {
			setMessage("0～999までご記入ください！", false);
		} else {
			
			UserDto loginUser = getLoginUser();
			
			sizaiDto.setRequest_user_id(loginUser.getId());
			sizaiDto.setRequest_dept_id(loginUser.getDepid());
			
			buyRequestS.requestRegist(sizaiDto);
			
			setMessage("登録完了しました。", true);
		}

		List<CategoryDto> categoryList = buyRequestS.getCategory();
		requestRF.setCategoryList(categoryList);

		return "requestRegistInit";
	}

	public RequestRegistForm getRequestRF() {
		return requestRF;
	}

	public void setRequestRF(RequestRegistForm requestRF) {
		this.requestRF = requestRF;
	}

}
