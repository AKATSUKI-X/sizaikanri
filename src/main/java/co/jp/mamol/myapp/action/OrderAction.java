package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.form.OrderDeliverForm;
import co.jp.mamol.myapp.service.OrderDeleverService;

@Results({ @Result(name = "orderInit", location = "") })
public class OrderAction extends BaseAction {

	private static final long serialVersionUID = 1L;

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
		
		
		

		return "orderInit";
	}

	public OrderDeliverForm getOrderDeliverF() {
		return orderDeliverF;
	}

	public void setOrderDeliverF(OrderDeliverForm orderDeliverF) {
		this.orderDeliverF = orderDeliverF;
	}

}
