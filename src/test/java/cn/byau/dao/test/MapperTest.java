package cn.byau.dao.test;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/** 声明用的是Spring的测试类 **/
@RunWith(SpringJUnit4ClassRunner.class)

/** 声明spring主配置文件位置，注意：以当前测试类的位置为基准,有多个配置文件以字符数组声明 **/
@ContextConfiguration(locations={"classpath:config/spring-core.xml","classpath:config/spring-tx.xml"})

/** 声明使用事务，不声明spring会使用默认事务管理 **/
@Transactional

/** 声明事务回滚，要不删除一个数据就没有了，注意：插入数据时可注掉，不让事务回滚 **/
//@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class MapperTest {
	
	

}
