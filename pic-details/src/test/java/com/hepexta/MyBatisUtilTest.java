package com.hepexta;

import com.hepexta.cfg.MyBatisCfg;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyBatisCfg.class)
public class MyBatisUtilTest {

	@Autowired
	private MyBatisCfg myBatisCfg;

	@Test
	public void test_buildSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = myBatisCfg.buildSqlSessionFactory();
		System.out.println(sqlSessionFactory.getConfiguration());
		Assert.assertNotNull(sqlSessionFactory.getConfiguration());
	}

	@Test
	public void test_getPictureDetailsByTitle() {
		String title = "title";
		String byTitle = myBatisCfg.getPictureDetailsByTitle( title );
		Assert.assertTrue(byTitle.contains( title ));
	}
}
