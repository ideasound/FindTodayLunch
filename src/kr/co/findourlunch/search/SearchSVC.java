package kr.co.findourlunch.search;

import java.util.List;

import kr.co.findourlunch.menu.CateCodeVO;
import kr.co.findourlunch.menu.SearchVO;
import kr.co.findourlunch.menu.ValueCodeVO;

public interface SearchSVC {
	enum SearchCodeResult{ COMPLETE, FAILED };
	
	/** CateCode Select
	 * @return List<CateCodeVO>
	 */
	public List<CateCodeVO> selectSearchCateCode();
	
	
	/** ValueCode Select
	 * @return List<ValueCodeVO>
	 */
	public List<ValueCodeVO> selectSearchValueCode();
	
	
	public List<SearchVO> advancedSearch(SearchVO vo);
}
