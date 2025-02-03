package co.jp.mamol.myapp.action;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.ApprovalDetailForm;
import co.jp.mamol.myapp.service.BuyApprovalService;

@Results({ @Result(name = "approvalDetailInit", location = "/WEB-INF/jsp/approvalDetail.jsp") })
public class ApprovalDetailAction extends BaseAction {

	private ApprovalDetailForm approvalDF = new ApprovalDetailForm();

	@Autowired
	private BuyApprovalService buyApprovalS;

	@Action("/approvalDetail/init")
	public String approvalDetailInit() {

		// approvalログイン状態チェック
		if (!approvalLoginCheck() && !orderLoginCheck()) {
			return "error";
		}

		int request_id = approvalDF.getRequest_id();
		SizaiDto sizaiDto = buyApprovalS.getRequest(request_id);
		approvalDF.setSizaiDto(sizaiDto);

		return "approvalDetailInit";
	}

	public ApprovalDetailForm getApprovalDF() {
		return approvalDF;
	}

	public void setApprovalDF(ApprovalDetailForm approvalDF) {
		this.approvalDF = approvalDF;
	}

}
