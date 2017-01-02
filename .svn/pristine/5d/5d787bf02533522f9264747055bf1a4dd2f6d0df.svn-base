package kr.co.findourlunch.history;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.findourlunch.common.action.AbstractAction;
import kr.co.findourlunch.history.HistorySVC.HistoryResult;

public class HistoryAction extends AbstractAction{

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response, String action)
			throws ServletException, IOException {
		
		
		if("/history/historyInsert.do".equals(action)){
			return performInsertHistory(request, response);
		}else if("".equals(action)){
			return performSelectBefore3DayHistory(request, response);
		}else {
			return null;
		}
	}

	public String performInsertHistory(HttpServletRequest request,
					HttpServletResponse response) throws UnsupportedEncodingException
	{
		String view = "/index.do";
		setRedirect(true);
		HistoryVO vo = new HistoryVO();
		String restaurant_idStr = request.getParameter("restaurant_id");
		int restaurant_id = 0;
		if(restaurant_idStr!=null){
			restaurant_id = Integer.parseInt(restaurant_idStr);
		}
		
		String nightORDay = "D";	// D: 낮, N: 밤
		String date = "";
		
		Date dateObj = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String convertDate = dateFormat.format(dateObj);
		String[] temp = convertDate.split(" ");
		date = temp[0];
		String time = temp[1];
		
		
		if(time!=null){
			if(Integer.parseInt(time.substring(0,2)) < 15 && Integer.parseInt(time.substring(0,2)) > 10){
				nightORDay = "D";
			}else{
				nightORDay = "N";
			}
		}
		
		vo.setVisitDate(date);
		vo.setNightORday(nightORDay);
		vo.setRestaurant_id(restaurant_id);
		
		HistorySVC service = new HistorySVCImpl();
		
		String message = "";
		HistoryResult result = service.insertHistory(vo.toMap());
		if(result==HistoryResult.COMPLETE){
			message = "방문이력이 등록되었습니다. 감사합니다. ";
		}else {
			message = "방문이력이 등록에 실패하였습니다.";
		}
		message = URLEncoder.encode(message, "UTF-8");
//		Gson gson = new Gson();
//		String json = gson.toJson(message);
		request.setAttribute("message", message);
		
		return view;
	}
	
	public String performSelectBefore3DayHistory(HttpServletRequest request,
			HttpServletResponse response){
		String view = "/index.do";
		setRedirect(true);
		
		HistorySVC service = new HistorySVCImpl();
		List<HistoryVO> before3DayHistory = service.selectBefore3DayHistory();
		
		
		
		
		
		return view;
	}
	
}
