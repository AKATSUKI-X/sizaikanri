package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.SizaiDto;

public class ApprovalForm {

	private String fromTime;

	private String toTime;

	private List<SizaiDto> sizaiDtoList;

	private int request_id;

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public List<SizaiDto> getSizaiDtoList() {
		return sizaiDtoList;
	}

	public void setSizaiDtoList(List<SizaiDto> sizaiDtoList) {
		this.sizaiDtoList = sizaiDtoList;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

}
