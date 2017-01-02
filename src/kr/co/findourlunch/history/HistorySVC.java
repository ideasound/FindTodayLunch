package kr.co.findourlunch.history;

import java.util.List;
import java.util.Map;

public interface HistorySVC {
	
	enum HistoryResult{ COMPLETE, FAILED };
	
	/** History Insert
	 * @return void
	 */
	public HistoryResult insertHistory(Map<String, Object> map);
	
	
	/** 최근 3일간 방문 이력
	 * @return List<HistoryVO>
	 */
	public List<HistoryVO> selectBefore3DayHistory();
}
