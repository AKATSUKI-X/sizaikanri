package co.jp.mamol.myapp.dto;

public class SizaiDto {
	//資材ID
    private int id;
    //資材名
    private String name;
    //数量
    private int num;
    //倉庫ID
    private String souko_id;
    //倉庫名
    private String souko_name;
    //カテゴリID
    private String category_id;
    //カテゴリ名
    private String category_name;
    //購入依頼者ID
    private String request_user_id;
    //購入依頼者名
    private String request_user_name;
    //購入依頼部門
    private String request_dept_id;
    //購入者部門名
    private String request_dept_name;
    //状態区分
    private String status;
    //状態名
    private String status_name;
    //依頼日
    private String request_date;
    //発注日
    private String order_date;
    //納品日
    private String delivery_date;
    //入庫日
    private String instore_date;
    //出庫日
    private String outstore_date;
    //備考
    private String note;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSouko_id() {
		return souko_id;
	}
	public void setSouko_id(String souko_id) {
		this.souko_id = souko_id;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getRequest_user_id() {
		return request_user_id;
	}
	public void setRequest_user_id(String request_user_id) {
		this.request_user_id = request_user_id;
	}
	public String getRequest_dept_id() {
		return request_dept_id;
	}
	public void setRequest_dept_id(String request_dept_id) {
		this.request_dept_id = request_dept_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequest_date() {
		return request_date;
	}
	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getInstore_date() {
		return instore_date;
	}
	public void setInstore_date(String instore_date) {
		this.instore_date = instore_date;
	}
	public String getOutstore_date() {
		return outstore_date;
	}
	public void setOutstore_date(String outstore_date) {
		this.outstore_date = outstore_date;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getRequest_dept_name() {
		return request_dept_name;
	}
	public void setRequest_dept_name(String request_dept_name) {
		this.request_dept_name = request_dept_name;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public String getRequest_user_name() {
		return request_user_name;
	}
	public void setRequest_user_name(String request_user_name) {
		this.request_user_name = request_user_name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getSouko_name() {
		return souko_name;
	}
	public void setSouko_name(String souko_name) {
		this.souko_name = souko_name;
	}
}
