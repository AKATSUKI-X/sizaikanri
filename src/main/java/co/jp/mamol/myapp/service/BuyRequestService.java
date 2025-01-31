package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.BuyRequestDao;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class BuyRequestService {

	@Autowired
	BuyRequestDao byRequestDao;

	//DA1001 購入依頼登録 insert
	public void requestRegist(SizaiDto sizaiDto) {
		byRequestDao.requestRegist(sizaiDto);
	}

	//DA1002 カテゴリ取得
	public List<CategoryDto> getCategory() {
		return byRequestDao.getCategory();
	}

	//DA1003 ユーザ別購入依頼リスト
	public List<SizaiDto> getUserRequsetList(
			String fromTime,
			String toTime,
			String request_user_id) {
		toTime = toTime + " " + "23:59:59";
		fromTime = fromTime + " " + "00:00:00";
		return byRequestDao.getUserRequsetList(fromTime, toTime, request_user_id);
	}

	//DA1004 購入依頼一件取得
	public SizaiDto getRequest(int request_id) {
		return byRequestDao.getRequestById(request_id);
	}

	//DA1005 購入依頼変更
	public boolean modifyRequest(SizaiDto sizaiDto) {
		return byRequestDao.modifyRequest(sizaiDto);
	}

	//DA1006 購入依頼削除
	public boolean deleteRequest(int request_id) {
		return byRequestDao.deleteById(request_id);
	}

}
