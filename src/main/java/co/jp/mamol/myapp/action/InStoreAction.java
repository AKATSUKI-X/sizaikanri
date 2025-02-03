package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;
import co.jp.mamol.myapp.form.StoreForm;
import co.jp.mamol.myapp.service.StoreService;

@Results({
		@Result(name = "inStoreInit", location = "/WEB-INF/jsp/inStore.jsp")
})
public class InStoreAction extends BaseAction {

	private StoreForm storeF = new StoreForm();

	@Autowired
	private StoreService storeS;

	@Action("/inStore/init")
	public String inStoreInit() {

		// storeログイン状態確認
		if (!storeLoginCheck()) {
			return "error";
		}

		return "inStoreInit";
	}

	@Action("/inStore/search")
	public String inStoreSearch() {

		// storeログイン状態確認
		if (!storeLoginCheck()) {
			return "error";
		}

		SizaiDto sizaiDto = storeS.getSizaiById(storeF.getRequest_id());
		if (sizaiDto == null) {
			storeF.setFalg(false);
			setMessage("資材情報を取得できませんでした。", false);
			return "inStoreInit";
		}

		storeF.setSizaiDto(sizaiDto);

		if (sizaiDto.getStatus().equals("5")) {
			List<SoukoDto> allSouko = storeS.getAllSouko();

			storeF.setSoukoDtoList(allSouko);
		} else {
			setMessage("資材の状態は「納品済」ではないため、入庫できません。", false);
		}

		storeF.setFalg(true);

		return "inStoreInit";
	}

	@Action("/inStore/act")
	public String inStoreAct() {

		// storeログイン状態確認
		if (!storeLoginCheck()) {
			return "error";
		}

		SizaiDto sizaiDto = storeF.getSizaiDto();

		boolean inStoreResult = storeS.inStore(sizaiDto);

		if (inStoreResult) {
			setMessage("入庫完了しました。", true);
		} else {
			setMessage("入庫できませんでした。", false);
		}

		int request_id = sizaiDto.getId();

		SizaiDto sizaiById = storeS.getSizaiById(request_id);

		storeF.setSizaiDto(sizaiById);

		storeF.setFalg(true);

		return "inStoreInit";
	}

	public StoreForm getStoreF() {
		return storeF;
	}

	public void setStoreF(StoreForm storeF) {
		this.storeF = storeF;
	}

}
