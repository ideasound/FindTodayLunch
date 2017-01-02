package kr.co.findourlunch.quick;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.co.findourlunch.common.action.AbstractAction;
import kr.co.findourlunch.menu.RestaurantVO;

public class QuickAction extends AbstractAction {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response, String action)
						throws ServletException, IOException
	{
		
		String view = "/ajaxResult.jsp";
		QuickSVC svc = new QuickSVCImpl();
		RestaurantVO vo = svc.selectQuickRestaurant();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(vo);
		System.out.println(json);
		request.setAttribute("json", json);
		setRedirect(false);
		return view;
//		return performQuickSelect(request, response);
	}
	
//	private String performQuickSelect (HttpServletRequest request,
//			HttpServletResponse response) {
//		
//	}
	

}
