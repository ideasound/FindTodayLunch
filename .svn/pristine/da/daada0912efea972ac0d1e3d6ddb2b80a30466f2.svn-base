package kr.co.findourlunch.quick;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kr.co.findourlunch.menu.RestaurantVO;
import kr.co.findourlunch.restaurant.RestaurantDAO;

public class QuickSVCImpl implements QuickSVC {

	private QuickDAO dao = QuickDAO.getInstance();
	private RestaurantDAO restDao = RestaurantDAO.getInstance();
	
	@Override
	public RestaurantVO selectQuickRestaurant() {
		// TODO Auto-generated method stub
		RestaurantVO vo = null;
		
		// 최근 6개 목록을 가져온다.(점심, 저녁 3일)
		List<RestaurantVO> quickList = dao.selectQuickList();
		
		// 구내식당 전체 목록을 가져온다.
		List<RestaurantVO> allList = restDao.selectAllCafeteriaList();
		
		int allSize = allList.size();
		int quickSize = quickList.size();
		
		int dupCnt = 0;
		for(int i=0; i<quickList.size(); i++){
			String quickID = quickList.get(i).getId();
			for(int j=0; j<allList.size(); j++){
				if(quickID.equals(allList.get(j).getId())){
					dupCnt++; // 중복카운트
				}
			}
		}
		
		int random = 0;
		 // 최근엔 모두 한번씩 갔으면 다시 로테이션 시작
		boolean isNotDupl = true;
		while(isNotDupl){
			random = (int) (Math.random() * allSize) + 1;
			vo = allList.get(random-1);
			//최근 2회 방문 기록 없는 곳으로.
			String lastVisitRestId = quickList.get(0).getId();
			String lastSndVisitRestId = quickList.get(1).getId();
			if(!vo.getId().equals(lastVisitRestId) &&
					!vo.getId().equals(lastSndVisitRestId))
			{
				
				isNotDupl = false;
			}
		}
		
		return vo;
	}

}
