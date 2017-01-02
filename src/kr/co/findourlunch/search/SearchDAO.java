package kr.co.findourlunch.search;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.findourlunch.menu.CateCodeVO;
import kr.co.findourlunch.menu.SearchVO;
import kr.co.findourlunch.menu.ValueCodeVO;
import kr.co.findourlunch.util.SqlMapper;

import com.ibatis.sqlmap.client.SqlMapClient;

public class SearchDAO {

	SqlMapClient mapper = SqlMapper.getSqlMapClient();
	
	private static SearchDAO dao;
	private SearchDAO(){}
	
	public static SearchDAO getInstance(){
		if(dao==null){
			dao = new SearchDAO();
		}
		return dao;
	}
	
	public List<CateCodeVO> selectSearchCateCode(){
		
		List<CateCodeVO> list = new ArrayList<CateCodeVO>();
		
		try {
			list = (List<CateCodeVO>) mapper.queryForList("Search.selectSearchCateCode");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<ValueCodeVO> selectSearchValueCode(){
		List<ValueCodeVO> list = new ArrayList<ValueCodeVO>();
		try {
			list = (List<ValueCodeVO>) mapper.queryForList("Search.selectSearchValueCode");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SearchVO> advancedSearch(SearchVO vo) {
		List<SearchVO> resList = new ArrayList<SearchVO>();
		
		try {
			resList = (List<SearchVO>) mapper.queryForList("Search.advancedSearch", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resList;
	}


}
