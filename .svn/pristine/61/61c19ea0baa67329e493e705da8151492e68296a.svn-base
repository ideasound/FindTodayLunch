package kr.co.findourlunch.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.findourlunch.common.action.AbstractAction;
import kr.co.findourlunch.history.HistorySVC;
import kr.co.findourlunch.history.HistorySVCImpl;
import kr.co.findourlunch.history.HistoryVO;
import kr.co.findourlunch.menu.CateCodeVO;
import kr.co.findourlunch.menu.ValueCodeVO;
import kr.co.findourlunch.search.SearchSVC;
import kr.co.findourlunch.search.SearchSVCImpl;

public class MainAction extends AbstractAction {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response, String action) throws ServletException, IOException {
		String view = "/index.jsp";
		setRedirect(false);
		
		SearchSVC searchSVC = new SearchSVCImpl();
		
		List<CateCodeVO> cateCodeList = searchSVC.selectSearchCateCode();
		
//		List<ValueCodeVO> valueCodeList = service.selectSearchValueCode();
		
		// 최근 3일 방문 이력
		
		
		HistorySVC historySVC = new HistorySVCImpl();
		List<HistoryVO> before3DayHistory = historySVC.selectBefore3DayHistory();
		
		request.setAttribute("cateCodeList", cateCodeList);
//		request.setAttribute("valueCodeList", valueCodeList);
		request.setAttribute("historyList", before3DayHistory);
		return view;
	}

}
