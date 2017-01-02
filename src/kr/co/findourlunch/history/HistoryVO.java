package kr.co.findourlunch.history;

import java.util.HashMap;
import java.util.Map;

import kr.co.findourlunch.menu.RestaurantVO;

public class HistoryVO {
	
	/**
	 * 방문일자
	 */
	private String visitDate;
	
	/**
	 * 밤,낮 구분
	 */
	private String nightORday;
	
	/**
	 * 식당 ID
	 */
	private int restaurant_id;

	/**
	 * 식당
	 */
	private RestaurantVO restaurant; 
	
	/**
	 * 식당명
	 */
	private String restaurantName;
	
	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getNightORday() {
		return nightORday;
	}

	public void setNightORday(String nightORday) {
		this.nightORday = nightORday;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	
	public RestaurantVO getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantVO restaurant) {
		this.restaurant = restaurant;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Map<String, Object> toMap(){
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("visitDate", getVisitDate());
		map.put("nightORday", getNightORday());
		map.put("restaurant_id", getRestaurant_id());
		map.put("restaurant", getRestaurant());
		map.put("restaurantName", getRestaurantName());
		
		return map;
	}
	
}
