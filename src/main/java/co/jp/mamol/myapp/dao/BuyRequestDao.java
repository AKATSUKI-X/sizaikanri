package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyRequestDao {

	//DA1001 購入依頼登録
	public void requestRegist(SizaiDto sizaiDto);

	//DA1002 カテゴリ取得
	public List<CategoryDto> getCategory();

	//DA1003 ユーザ別購入依頼リスト
	public List<SizaiDto> getUserRequsetList(
			@Param("fromTime") String fromTime,
			@Param("toTime") String toTime,
			@Param("request_user_id") String request_user_id);

	//DA1004 購入依頼一件取得
	public SizaiDto getRequestById(@Param("request_id") int request_id);

	//DA1005 購入依頼変更
	public boolean modifyRequest(SizaiDto sizaiDto);

	//DA1006 購入依頼削除
	public boolean deleteById(@Param("request_id") int request_id);

}
