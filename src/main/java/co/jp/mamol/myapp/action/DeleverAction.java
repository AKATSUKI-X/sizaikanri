package co.jp.mamol.myapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.OrderDeliverForm;
import co.jp.mamol.myapp.service.OrderDeleverService;

@Results({ 
	@Result(name = "deleverInit", location = "/WEB-INF/jsp/delever.jsp"),
	@Result(name="deleverQR",location = "/WEB-INF/jsp/qr.jsp")
})
public class DeleverAction extends BaseAction {

	private OrderDeliverForm orderDeliverF = new OrderDeliverForm();

	@Autowired
	private OrderDeleverService orderDeleverS;

	@Action("/delever/init")
	public String deleverInit() {

		// orderログイン状態チェック
		if (!orderLoginCheck()) {
			return "error";
		}

		List<DepartmentDto> deptList = orderDeleverS.deptList();
		orderDeliverF.setDepartmentDtoList(deptList);

		String request_dept_id = deptList.get(0).getId();

		List<SizaiDto> sizaiDtoList = orderDeleverS.orderedList(request_dept_id);
		orderDeliverF.setSizaiDtoList(sizaiDtoList);

		Map<String, Object> session = getSession();

		session.put("deptId", request_dept_id);

		return "deleverInit";
	}

	@Action("/delever/search")
	public String deleverSearch() {

		// orderログイン状態チェック
		if (!orderLoginCheck()) {
			return "error";
		}

		List<DepartmentDto> deptList = orderDeleverS.deptList();
		orderDeliverF.setDepartmentDtoList(deptList);

		String request_dept_id = orderDeliverF.getRequest_dept_id();

		List<SizaiDto> sizaiDtoList = orderDeleverS.orderedList(request_dept_id);
		orderDeliverF.setSizaiDtoList(sizaiDtoList);

		Map<String, Object> session = getSession();

		session.put("deptId", request_dept_id);

		return "deleverInit";
	}

	@Action("/delever/act")
	public String deleverAct() {
		// orderログイン状態チェック
		if (!orderLoginCheck()) {
			return "error";
		}

		Map<String, Object> session = getSession();
		String request_dept_id = (String) session.get("deptId");

		boolean deleverAct = orderDeleverS.deleverAct(orderDeliverF.getRequest_id());

		if (deleverAct) {
			setMessage("納品しました。", deleverAct);
		} else {
			setMessage("納品失敗しました。", deleverAct);
		}

		List<DepartmentDto> deptList = orderDeleverS.deptList();
		orderDeliverF.setDepartmentDtoList(deptList);

		List<SizaiDto> sizaiDtoList = orderDeleverS.orderedList(request_dept_id);
		orderDeliverF.setSizaiDtoList(sizaiDtoList);

		return "deleverInit";
	}

	@Action("/delever/qr")
	public String deleverQR() {

		// orderログイン状態チェック
		if (!orderLoginCheck()) {
			return "error";
		}

		return "deleverQR";
	}

	public OrderDeliverForm getOrderDeliverF() {
		return orderDeliverF;
	}

	public void setOrderDeliverF(OrderDeliverForm orderDeliverF) {
		this.orderDeliverF = orderDeliverF;
	}

}
