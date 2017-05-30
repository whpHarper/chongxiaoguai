package com.cxg.enums;

/**
 * 角色
 * @author 王海鹏
 *
 */
public enum RoleEnum {
	/**管理员*/
	@EnumMark(value="管理员")
	ADMIN("admin"),
	
	/**观察者*/
	@EnumMark(value="观察者")
	OBSERVER("observer"),
	
	/**审核员**/
	@EnumMark(value="评审员")
	ASSESSOR("assessor"),
	
	/**业务操作员*/
	@EnumMark(value="制单员")
	OPERATIONS("operations");
	
	/**
	 * 实际值
	 */
	private String value;

	private RoleEnum(String value) {
		this.value = value;
	}

	/**
	 * 获取枚举值对应的实际值
	 * 
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
}
