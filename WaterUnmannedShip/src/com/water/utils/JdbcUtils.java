package com.water.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	private static DataSource dataSource;
	static{
		
		dataSource = new ComboPooledDataSource();
	}
	/**
	 * 得到数据源对象
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	/**
	 * 创建核心工具
	 */
	public static QueryRunner getQuertRunner()
	{
		return new QueryRunner(dataSource);
		
	}
	
}
