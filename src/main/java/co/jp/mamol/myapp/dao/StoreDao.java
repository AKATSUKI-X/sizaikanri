package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

public interface StoreDao {

	//DA4001 資材情報一件取得
	public SizaiDto getSizaiById(@Param("request_id") int request_id);

	//DA4002 倉庫情報取得
	public List<SoukoDto> getSoukoList();

	//DA4003 入庫実行
	public boolean inStoreAct(SizaiDto sizaiDto);

	//DA4004 出庫実行
	public boolean outStoreAct(SizaiDto sizaiDto);

}
