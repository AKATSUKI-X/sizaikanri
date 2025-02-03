package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

public class StoreForm {

	private SizaiDto sizaiDto;

	private List<SoukoDto> soukoDtoList;

	private int request_id;

	private boolean falg;

	public SizaiDto getSizaiDto() {
		return sizaiDto;
	}

	public void setSizaiDto(SizaiDto sizaiDto) {
		this.sizaiDto = sizaiDto;
	}

	public List<SoukoDto> getSoukoDtoList() {
		return soukoDtoList;
	}

	public void setSoukoDtoList(List<SoukoDto> soukoDtoList) {
		this.soukoDtoList = soukoDtoList;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public boolean isFalg() {
		return falg;
	}

	public void setFalg(boolean falg) {
		this.falg = falg;
	}

}
