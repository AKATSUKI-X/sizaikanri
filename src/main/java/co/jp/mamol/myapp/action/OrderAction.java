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

@Results({ @Result(name = "orderInit", location = "/WEB-INF/jsp/order.jsp") })
public class OrderAction extends BaseAction {

	private OrderDeliverForm orderDeliverF = new OrderDeliverForm();

	@Autowired
	private OrderDeleverService orderDeleverS;

	@Action("/order/init")
	public String orderInit() {

		// orderログイン状態チェック
		if (!orderLoginCheck()) {
			return "error";
		}

		List<DepartmentDto> deptList = orderDeleverS.deptList();
		orderDeliverF.setDepartmentDtoList(deptList);

		String request_dept_id = deptList.get(0).getId();

		List<SizaiDto> sizaiDtoList = orderDeleverS.approvaledList(request_dept_id);
		orderDeliverF.setSizaiDtoList(sizaiDtoList);

		Map<String, Object> session = getSession();

		session.put("deptId", request_dept_id);

		return "orderInit";
	}

	@Action("/order/search")
	public String orderSearch() {

		// orderログイン状態チェック
		if (!orderLoginCheck()) {
			return "error";
		}

		List<DepartmentDto> deptList = orderDeleverS.deptList();
		orderDeliverF.setDepartmentDtoList(deptList);

		String request_dept_id = orderDeliverF.getRequest_dept_id();

		List<SizaiDto> sizaiDtoList = orderDeleverS.approvaledList(request_dept_id);
		orderDeliverF.setSizaiDtoList(sizaiDtoList);

		Map<String, Object> session = getSession();

		session.put("deptId", request_dept_id);

		return "orderInit";
	}

	@Action("/order/act")
	public String orderAct() {
		// orderログイン状態チェック
		if (!orderLoginCheck()) {
			return "error";
		}

		Map<String, Object> session = getSession();
		String request_dept_id = (String) session.get("deptId");

		boolean orderAct = orderDeleverS.orderAct(orderDeliverF.getRequest_id());

		if (orderAct) {
			setMessage("発注しました。", orderAct);
		} else {
			setMessage("発注失敗しました。", orderAct);
		}

		List<DepartmentDto> deptList = orderDeleverS.deptList();
		orderDeliverF.setDepartmentDtoList(deptList);

		List<SizaiDto> sizaiDtoList = orderDeleverS.approvaledList(request_dept_id);
		orderDeliverF.setSizaiDtoList(sizaiDtoList);

		return "orderInit";
	}

	public OrderDeliverForm getOrderDeliverF() {
		return orderDeliverF;
	}

	public void setOrderDeliverF(OrderDeliverForm orderDeliverF) {
		this.orderDeliverF = orderDeliverF;
	}

}
