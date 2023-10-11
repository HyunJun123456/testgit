package myspring.customer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-customer.xml")
public class CustomerDBTest {

		@Autowired
		DataSource dataSource;
			
		@Autowired
		SqlSessionFactory sqlsessionFactory;
		
		@Test
		public void conn() {
			try {
				Connection connection = dataSource.getConnection();
				DatabaseMetaData metaData = connection.getMetaData();
				System.out.println("DB Product Name : " + metaData.getDatabaseProductName());
				System.out.println("DB Driver : " + metaData.getDriverName());
				System.out.println("DB URL : " + metaData.getURL());
				System.out.println("DB Username : " + metaData.getUserName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void sessionFactory() {
			System.out.println(sqlsessionFactory.getClass().getName());
		}
}
