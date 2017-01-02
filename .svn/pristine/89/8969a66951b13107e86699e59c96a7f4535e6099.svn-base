package kr.co.findourlunch.restaurant;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.findourlunch.menu.RestaurantVO;
import kr.co.findourlunch.util.SqlMapper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class RestaurantDAO {

	
	private SqlMapClient mapper = SqlMapper.getSqlMapClient();
	
	private static RestaurantDAO dao;
	private RestaurantDAO(){}
	
	public static RestaurantDAO getInstance(){
		if(dao==null){
			dao = new RestaurantDAO();
		}
		return dao;
	}
	
	public List<RestaurantVO> selectAllCafeteriaList(){
		
		List<RestaurantVO> list = new ArrayList<RestaurantVO>();
		
		try {
			list = (List<RestaurantVO>) mapper.queryForList("Restaurant.selectAllCafeteriaList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
}
