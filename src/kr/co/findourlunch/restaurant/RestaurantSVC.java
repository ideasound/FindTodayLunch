package kr.co.findourlunch.restaurant;

import java.util.List;

public interface RestaurantSVC {
	
	/** All Cafeteria
	 * @return MenuVO
	 */
	public List<RestaurantDAO> selectAllCafeteriaList();
	
}
