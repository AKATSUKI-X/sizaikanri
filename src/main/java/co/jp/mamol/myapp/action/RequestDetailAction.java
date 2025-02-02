package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.RequestDetailForm;
import co.jp.mamol.myapp.service.BuyRequestService;

@Results({
		@Result(name = "requestDetailInit", location = "/WEB-INF/jsp/requestDetail.jsp")
})
public class RequestDetailAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private RequestDetailForm requestDF = new RequestDetailForm();

	@Autowired
	private BuyRequestService buyRequestS;

	@Action("/requestDetail/init")
	public String requestDetailInit() {
		//requestログイン状態チェック
		if (!requestLoginCheck()) {
			return "error";
		}

		//BL1004を呼び出し、資材情報を取得する。
		int request_id = requestDF.getRequest_id();
		//try...chathのロジックが後回しに考えとく
		SizaiDto sizaiDto = buyRequestS.getRequest(request_id);
		requestDF.setSizaiDto(sizaiDto);

		//BL1002を呼び出し、カテゴリリストを取得する。
		List<CategoryDto> categoryList = buyRequestS.getCategory();
		requestDF.setCategoryList(categoryList);

		//資材DTO.状態区分チェック
		String status = sizaiDto.getStatus();
		if (status.equals("1") || status.equals("3")) {
			requestDF.setFlag(true);
		} else {
			requestDF.setFlag(false);
			setMessage("承認済の依頼を変更できません。", false);
		}

		return "requestDetailInit";
	}

	@Action("/requestDetail/modify")
	public String requestModify() {
		//requestログイン状態チェック
		if (!requestLoginCheck()) {
			return "error";
		}

		SizaiDto sizaiDto = requestDF.getSizaiDto();
		boolean modifyResult = buyRequestS.modifyRequest(sizaiDto);
		if (modifyResult) {
			setMessage("変更完了しました。", true);
		} else {
			setMessage("変更できませんでした。", false);
		}

		//BL1004を呼び出し、資材情報を取得する。
		int request_id = requestDF.getSizaiDto().getId();
		//try...chathのロジックが後回しに考えとく
		requestDF.setSizaiDto(buyRequestS.getRequest(request_id));

		//BL1002を呼び出し、カテゴリリストを取得する。
		List<CategoryDto> categoryList = buyRequestS.getCategory();
		requestDF.setCategoryList(categoryList);
		
		requestDF.setFlag(true);

		return "requestDetailInit";
	}

	public RequestDetailForm getRequestDF() {
		return requestDF;
	}

	public void setRequestDF(RequestDetailForm requestDF) {
		this.requestDF = requestDF;
	}

}
