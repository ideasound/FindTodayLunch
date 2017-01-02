package kr.co.findourlunch.search;

import java.util.ArrayList;
import java.util.List;

import kr.co.findourlunch.menu.CateCodeVO;
import kr.co.findourlunch.menu.SearchVO;
import kr.co.findourlunch.menu.ValueCodeVO;

public class SearchSVCImpl implements SearchSVC {

	private SearchDAO dao = SearchDAO.getInstance();
	
	@Override
	public List<CateCodeVO> selectSearchCateCode() {
		List<CateCodeVO> list = new ArrayList<CateCodeVO>();
		list = dao.selectSearchCateCode();
		return list;
	}

	@Override
	public List<ValueCodeVO> selectSearchValueCode() {
		List<ValueCodeVO> list = new ArrayList<ValueCodeVO>();
		list = dao.selectSearchValueCode();
		return list;
	}

	@Override
	public List<SearchVO> advancedSearch(SearchVO vo) {
		
		return dao.advancedSearch(vo);
	}

	
}
