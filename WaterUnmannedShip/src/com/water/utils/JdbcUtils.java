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
	 * �õ�����Դ����
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	/**
	 * �������Ĺ���
	 */
	public static QueryRunner getQuertRunner()
	{
		return new QueryRunner(dataSource);
		
	}
	
}
