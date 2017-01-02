package kr.co.findourlunch.menu;

import java.util.List;

public class CateCodeVO {

	
	private int cate_id;
	
	private String name;

	private List<ValueCodeVO> valueList ;
	
	
	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ValueCodeVO> getValueList() {
		return valueList;
	}

	public void setValueList(List<ValueCodeVO> valueList) {
		this.valueList = valueList;
	}
	
	
	
}
