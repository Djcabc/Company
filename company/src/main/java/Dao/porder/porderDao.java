package Dao.porder;

import java.util.List;

import Model.porder;

public interface porderDao {
	//新增
	void add(porder p);
	
	
	//查詢
	List<porder> queryAll();//全部
	List<porder> querySum(int start,int end);//金額條件-->sum
	porder queryId(int id);
	
	//修改
	void update(porder p);
	//刪除
	void delete(int id);

}
