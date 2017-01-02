package kr.co.findourlunch.weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.findourlunch.common.action.AbstractAction;
import kr.co.findourlunch.menu.SearchVO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class WeatherAction extends AbstractAction {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response, String action)
			throws ServletException, IOException {
		String view = "/ajaxResult.jsp";

		int weather_code = 0;
		if (request.getParameter("weather")!=null){
			weather_code = Integer.parseInt(request.getParameter("weather"));
		}
		int code = Math.round(weather_code/100) * 100;
		WeatherSVCImpl impl = new WeatherSVCImpl();
		List<SearchVO> list = new ArrayList<SearchVO>();
		list = impl.selectMenuListByWeather(code);
		
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(list);
		request.setAttribute("json", json);
		System.out.println(json);
		setRedirect(false);
		return view;
	}
	private JsonObject json;


}
