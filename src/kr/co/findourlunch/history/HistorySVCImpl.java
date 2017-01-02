package kr.co.findourlunch.history;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistorySVCImpl implements HistorySVC {

	
	private HistoryDAO dao = HistoryDAO.getInstance();
	
	@Override
	public HistoryResult insertHistory(Map<String, Object> map) {
		int result = dao.insertHistory(map);
		if(result>0){
			return HistoryResult.COMPLETE;
		}else{
			return HistoryResult.FAILED;
		}
	}

	@Override
	public List<HistoryVO> selectBefore3DayHistory() {
			
		List<HistoryVO> list = new ArrayList<HistoryVO>();
		
		list = dao.selectBefore3DayHistory();
		
		return list;
	}
	
	

}
