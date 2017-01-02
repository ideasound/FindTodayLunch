package kr.co.findourlunch.quick;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.findourlunch.menu.RestaurantVO;
import kr.co.findourlunch.util.SqlMapper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class QuickDAO {
	
	private SqlMapClient sqlMapClient = SqlMapper.getSqlMapClient();
	
	private static QuickDAO dao;
	private QuickDAO(){}
	
	public static QuickDAO getInstance(){
		if(dao==null){
			dao = new QuickDAO();
		}
		return dao;
	}
	
	public List<RestaurantVO> selectQuickList(){
		List<RestaurantVO> list = new ArrayList<RestaurantVO>();
		try {
			list = (List<RestaurantVO>) sqlMapClient.queryForList("Quick.selectQuickList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<RestaurantVO> selectQuickListSnd(){
		List<RestaurantVO> list = new ArrayList<RestaurantVO>();
		try {
			list = (List<RestaurantVO>) sqlMapClient.queryForList("Quick.selectQuickListSnd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
