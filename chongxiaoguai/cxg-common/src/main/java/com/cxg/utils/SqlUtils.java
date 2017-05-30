package com.cxg.utils;

/**
 * 拼装sql工具类
 * @author qiaohfeng
 *
 */
public class SqlUtils {

	/**
	 * 根据提供的字段查询对应的数据字典
	 * @author qiaohfeng
	 * @date 2017年3月6日 16:37:23
	 * @param sql 
	 * @param parmStr 数据库字段名称(比如供应商信息表的审核状态 'audit_status')
	 * @param typeCode 对应的数据字典类型code(数据字典中的审核状态的类型code : audit_status)
	 * @return 返回的sql多了typecode以及typename两个参数
	 */
	public static String getDataTypeName(String sql, String parmStr,
			String typeCode) {
		StringBuffer newSql = new StringBuffer("select * from (").append(sql).append(") base_table");
		newSql.append("left join (")
				.append("select t.typename,t.typecode from t_s_type t join t_s_typegroup tg on t.typegroupid = tg.id where tg.typegroupcode = '")
				.append(typeCode)
				.append("') data_type on data_type.typecode = base_table.")
				.append(parmStr);
		return newSql.toString();
	}
}
