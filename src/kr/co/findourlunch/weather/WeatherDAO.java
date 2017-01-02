package kr.co.findourlunch.weather;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.findourlunch.menu.SearchVO;
import kr.co.findourlunch.util.SqlMapper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class WeatherDAO {
	
	SqlMapClient sqlMapClient = SqlMapper.getSqlMapClient();
	
	private static WeatherDAO dao;
	private WeatherDAO(){}
	
	public static WeatherDAO getInstance(){
		if(dao==null){
			dao = new WeatherDAO();
		}
		return dao;
	}
	
	public List<SearchVO> selectMenuListByWeather(int code){
		List<SearchVO> list = new ArrayList<SearchVO>();
		try {
			list = (List<SearchVO>) sqlMapClient.queryForList("Search.selectMenuListByWeather",code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
