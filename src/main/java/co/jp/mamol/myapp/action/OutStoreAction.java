package co.jp.mamol.myapp.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.StoreForm;
import co.jp.mamol.myapp.service.StoreService;

@Results({
		@Result(name = "outStoreInit", location = "/WEB-INF/jsp/outStore.jsp")
})
public class OutStoreAction extends BaseAction {

	private StoreForm storeF = new StoreForm();

	@Autowired
	private StoreService storeS;

	@Action("/outStore/init")
	public String outStoreInit() {

		// storeログイン状態確認
		if (!storeLoginCheck()) {
			return "error";
		}

		return "outStoreInit";
	}

	@Action("/outStore/search")
	public String outStoreSearch() {

		// storeログイン状態確認
		if (!storeLoginCheck()) {
			return "error";
		}

		SizaiDto sizaiDto = storeS.getSizaiById(storeF.getRequest_id());
		if (sizaiDto == null) {
			storeF.setFalg(false);
			setMessage("資材情報を取得できませんでした。", false);
			return "outStoreInit";
		}

		storeF.setSizaiDto(sizaiDto);

		if (!(sizaiDto.getStatus().equals("6"))) {
			setMessage("資材の状態は「入庫済」ではないため、出庫できません。", false);
		}

		storeF.setFalg(true);

		return "outStoreInit";
	}

	@Action("/outStore/act")
	public String outStoreAct() {

		// storeログイン状態確認
		if (!storeLoginCheck()) {
			return "error";
		}

		SizaiDto sizaiDto = storeF.getSizaiDto();

		boolean outStoreResult = storeS.outStore(sizaiDto);

		if (outStoreResult) {
			setMessage("出庫完了しました。", true);
		} else {
			setMessage("出庫できませんでした。", false);
		}

		int request_id = sizaiDto.getId();

		SizaiDto sizaiById = storeS.getSizaiById(request_id);

		storeF.setSizaiDto(sizaiById);

		storeF.setFalg(true);

		return "outStoreInit";
	}

	public StoreForm getStoreF() {
		return storeF;
	}

	public void setStoreF(StoreForm storeF) {
		this.storeF = storeF;
	}

}
