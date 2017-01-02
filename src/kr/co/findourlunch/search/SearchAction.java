package kr.co.findourlunch.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.findourlunch.common.action.AbstractAction;
import kr.co.findourlunch.menu.SearchVO;

public class SearchAction extends AbstractAction {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response, String action)
			throws ServletException, IOException {
		
		String view="/ajaxResult.jsp";
		setRedirect(false);
		
		String[] values = request.getParameterValues("value_id");
		
		
		List<String> valueList = new ArrayList<String>();
		
		String json = "";
		Gson gson = new Gson();
		if(values!=null && values.length>0){
			
			for(String value : values){
				valueList.add(value);
			}
			
			SearchVO vo = new SearchVO();
			
			vo.setSearchWordList(valueList);
			
			SearchSVC svc = new SearchSVCImpl();
			
			List<SearchVO> searchList = svc.advancedSearch(vo);
			json = gson.toJson(searchList);
			request.setAttribute("json", json);
		} else {
			json = gson.toJson("조회결과가 없습니다.");
		}
		request.setAttribute("json", json);
		return view;
	}

}
