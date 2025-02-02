package co.jp.mamol.myapp.form;

import co.jp.mamol.myapp.dto.SizaiDto;

public class ApprovalDetailForm {

	private int request_id;

	private SizaiDto sizaiDto;

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public SizaiDto getSizaiDto() {
		return sizaiDto;
	}

	public void setSizaiDto(SizaiDto sizaiDto) {
		this.sizaiDto = sizaiDto;
	}

}
