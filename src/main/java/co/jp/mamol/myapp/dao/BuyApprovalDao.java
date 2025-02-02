package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyApprovalDao {

	//DA2001 部門別購入依頼一覧
	public List<SizaiDto> getDeptRequsetList(
			@Param("fromTime") String fromTime,
			@Param("toTime") String toTime,
			@Param("request_user_id") String request_user_id);
	
	//DA2002 購入依頼一件取得
	public SizaiDto getRequestById(@Param("request_id") int request_id);
	
	//DA2003 承認実行
	public boolean approval(@Param("request_id") int request_id);
	
	//DA2004 却下実行
	public boolean regect(@Param("request_id") int request_id);
	
}
