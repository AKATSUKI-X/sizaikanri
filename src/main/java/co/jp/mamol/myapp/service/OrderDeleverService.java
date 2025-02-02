package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.OrderDeliverDao;
import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class OrderDeleverService {

	@Autowired
	private OrderDeliverDao orderDeliverDao;

	// BL3001 部署リスト取得
	public List<DepartmentDto> deptList() {
		return orderDeliverDao.deptList();
	}

	// BL3002 承認済資材取得(部署別)
	public List<SizaiDto> approvaledList(String request_dept_id) {
		return orderDeliverDao.approvaledList(request_dept_id);
	}

	// BL3003 発注済資材取得(部署別)
	public List<SizaiDto> orderedList(String request_dept_id) {
		return orderDeliverDao.orderedList(request_dept_id);
	}

	// BL3004 発注実行
	public boolean orderAct(int request_id) {
		return orderDeliverDao.orderAct(request_id);
	}

	// BL3005 納品実行
	public boolean deleverAct(int request_id) {
		return orderDeliverDao.deleverAct(request_id);
	}

}
