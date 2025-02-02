package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.BuyApprovalDao;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class BuyApprovalService {

	@Autowired
	private BuyApprovalDao buyApprovalDao;

	// BL2001 部門別購入依頼一覧
	public List<SizaiDto> getDeptRequsetList(String fromTime, String toTime, String request_user_id) {
		toTime = toTime + " " + "23:59:59";
		fromTime = fromTime + " " + "00:00:00";
		return buyApprovalDao.getDeptRequsetList(fromTime, toTime, request_user_id);
	}

	// BL2002 購入依頼一件取得
	public SizaiDto getRequest(int request_id) {
		return buyApprovalDao.getRequestById(request_id);
	}

	// BL2003 承認実行
	public boolean approval(int request_id) {
		return buyApprovalDao.approval(request_id);
	}

	// BL2004 却下実行
	public boolean regect(int request_id) {
		return buyApprovalDao.regect(request_id);
	}

}
