package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.StoreDao;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

@Service
public class StoreService {

	@Autowired
	private StoreDao storeDao;

	//BL4001 資材情報一件取得
	public SizaiDto getSizaiById(int request_id) {
		return storeDao.getSizaiById(request_id);
	}

	//BL4002 倉庫情報取得
	public List<SoukoDto> getAllSouko() {
		return storeDao.getSoukoList();
	}

	//BL4003 入庫実行
	public boolean inStore(SizaiDto sizaiDto) {
		return storeDao.inStoreAct(sizaiDto);
	}

	//BL4004 出庫実行
	public boolean outStore(SizaiDto sizaiDto) {
		return storeDao.outStoreAct(sizaiDto);
	}

}
