package com.hepexta.cfg;

import com.hepexta.mappers.DetailMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class MyBatisCfg {

	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String URL = "jdbc:derby:testdb1;create=true";
	public static final String USERNAME = "sa";
	public static final String PASSWORD = "pass123";
	private static SqlSessionFactory sqlSessionFactory;

	@Bean
	public SqlSessionFactory buildSqlSessionFactory() {

		DataSource dataSource = new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD);
		Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(DetailMapper.class);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		return builder.build(configuration);

	}

	public String getPictureDetailsByTitle( String title) {
		return new SQL() {
			{
				SELECT("*");
				FROM("PIC_DETAIL");
				WHERE("name like "+title+" || '%'");
			}
		}.toString();
	}
}
