package kr.co.findourlunch.weather;

import java.util.ArrayList;
import java.util.List;

import kr.co.findourlunch.menu.CateCodeVO;
import kr.co.findourlunch.menu.MenudataVO;
import kr.co.findourlunch.menu.SearchVO;
import kr.co.findourlunch.menu.ValueCodeVO;

public class WeatherSVCImpl {

	private WeatherDAO dao = WeatherDAO.getInstance();

	public List<SearchVO> selectMenuListByWeather(int code) {
		List<SearchVO> list = new ArrayList<SearchVO>();
		list = dao.selectMenuListByWeather(code);
		return list;
	}



	
}
