package co.jp.mamol.myapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.RequestForm;
import co.jp.mamol.myapp.service.BuyRequestService;

@Results({
		@Result(name = "requestinit", location = "/WEB-INF/jsp/requestList.jsp"),
		@Result(name="requestdelete",location="/requestList/init",type="redirect")
})
public class RequestAction extends BaseAction {

	private RequestForm requestF = new RequestForm();

	@Autowired
	private BuyRequestService buyRequestS;

	@Action("/requestList/init")
	public String requestInit() {

		//requestログイン状態チェック
		if (!requestLoginCheck()) {
			return "error";
		}

		//現時点の年月日を取得
		LocalDate nowDate = LocalDate.now();
		//日付フォーマット"yyyy-MM-dd" を定義する
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//(現在日付)文字列に交換する
		String toTime = nowDate.format(formatter);

		//先月日付の年月日を取得
		LocalDate minusMonths = nowDate.minusMonths(1);
		//(先月日付)文字列に交換する
		String fromTime = minusMonths.format(formatter);

		requestF.setToTime(toTime);
		requestF.setFromTime(fromTime);

		List<SizaiDto> sizaiDtoList = buyRequestS.getUserRequsetList(
				requestF.getFromTime(),
				requestF.getToTime(),
				getLoginUser().getId());
		if (sizaiDtoList == null || sizaiDtoList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}

		requestF.setSizaiDtoList(sizaiDtoList);

		return "requestinit";
	}

	@Action("/requestList/search")
	public String requestShow() {
		//requestログイン状態チェック
		if (!requestLoginCheck()) {
			return "error";
		}

		List<SizaiDto> sizaiDtoList = buyRequestS.getUserRequsetList(
				requestF.getFromTime(),
				requestF.getToTime(),
				getLoginUser().getId());
		if (sizaiDtoList == null || sizaiDtoList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}

		requestF.setSizaiDtoList(sizaiDtoList);
		
		return "requestinit";
	}

	@Action("/requestList/delete")
	public String requestDelete() {
		//requestログイン状態チェック
		if (!requestLoginCheck()) {
			return "error";
		}
		
		int request_id = requestF.getRequest_id();
		
		buyRequestS.deleteRequest(request_id);
		
		/*if(!deleteRequest) {
			setMessage("削除失敗しました！", false);
		}*/
		
		return "requestdelete";
	}

	public RequestForm getRequestF() {
		return requestF;
	}

	public void setRequestF(RequestForm requestF) {
		this.requestF = requestF;
	}

}
