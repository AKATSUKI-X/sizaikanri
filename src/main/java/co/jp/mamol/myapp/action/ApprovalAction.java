package co.jp.mamol.myapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.ApprovalForm;
import co.jp.mamol.myapp.service.BuyApprovalService;

@Results({ @Result(name = "approvalinit", location = "/WEB-INF/jsp/approvalList.jsp"),
		@Result(name = "approvalredirect", location = "/approvalList/init", type = "redirect") })
public class ApprovalAction extends BaseAction {

	private ApprovalForm approvalF = new ApprovalForm();

	@Autowired
	private BuyApprovalService buyApprovalS;

	@Action("/approvalList/init")
	public String approvalInit() {

		// approvalログイン状態チェック
		if (!approvalLoginCheck()) {
			return "error";
		}

		// 現時点の年月日を取得
		LocalDate nowDate = LocalDate.now();
		// 日付フォーマット"yyyy-MM-dd" を定義する
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// (現在日付)文字列に交換する
		String toTime = nowDate.format(formatter);

		// 先月日付の年月日を取得
		LocalDate minusMonths = nowDate.minusMonths(1);
		// (先月日付)文字列に交換する
		String fromTime = minusMonths.format(formatter);

		approvalF.setToTime(toTime);
		approvalF.setFromTime(fromTime);

		List<SizaiDto> sizaiDtoList = buyApprovalS.getDeptRequsetList(approvalF.getFromTime(), approvalF.getToTime(),
				getLoginUser().getDepid());
		if (sizaiDtoList == null || sizaiDtoList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}

		approvalF.setSizaiDtoList(sizaiDtoList);

		return "approvalinit";
	}

	@Action("/approvalList/search")
	public String approvalShow() {

		// approvalログイン状態チェック
		if (!approvalLoginCheck()) {
			return "error";
		}

		List<SizaiDto> sizaiDtoList = buyApprovalS.getDeptRequsetList(approvalF.getFromTime(), approvalF.getToTime(),
				getLoginUser().getDepid());
		if (sizaiDtoList == null || sizaiDtoList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}

		approvalF.setSizaiDtoList(sizaiDtoList);

		return "approvalinit";
	}

	@Action("/approvalList/approval")
	public String approvalApproval() {

		// approvalログイン状態チェック
		if (!approvalLoginCheck()) {
			return "error";
		}
		int request_id = approvalF.getRequest_id();

		buyApprovalS.approval(request_id);

		return "approvalredirect";
	}

	@Action("/approvalList/regect")
	public String approvalRegect() {

		// approvalログイン状態チェック
		if (!approvalLoginCheck()) {
			return "error";
		}
		int request_id = approvalF.getRequest_id();

		buyApprovalS.regect(request_id);

		return "approvalredirect";
	}

	public ApprovalForm getApprovalF() {
		return approvalF;
	}

	public void setApprovalF(ApprovalForm approvalF) {
		this.approvalF = approvalF;
	}

}
