package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class OrderDeliverForm {

	private List<DepartmentDto> departmentDtoList;

	private String request_dept_id;

	private List<SizaiDto> sizaiDtoList;

	private int request_id;

	public List<DepartmentDto> getDepartmentDtoList() {
		return departmentDtoList;
	}

	public void setDepartmentDtoList(List<DepartmentDto> departmentDtoList) {
		this.departmentDtoList = departmentDtoList;
	}

	public String getRequest_dept_id() {
		return request_dept_id;
	}

	public void setRequest_dept_id(String request_dept_id) {
		this.request_dept_id = request_dept_id;
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
