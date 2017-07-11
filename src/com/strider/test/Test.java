package com.strider.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.strider.bean.UserBean;

public class Test {

	public static void main(String[] args) throws IOException {
		 //MyBatis配置文件  
        String resource="SqlMapConfig.xml";  
        //得到配置文件流  
        InputStream inputStream= Resources.getResourceAsStream(resource);  
        //创建会话工厂，传入MyBatis的配置文件信息  
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);  
          
        //通过工厂得到SqlSession  
        SqlSession sqlSession=sqlSessionFactory.openSession();  
          
        //通过SqlSession操作数据库  
        //第一个参数：映射文件中statement的id，格式为=namespace+“.”+statementid  
        //第二个参数：指定和映射文件中所匹配的parameterType类型的参数  
        //sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象  
        
        UserBean user=sqlSession.selectOne("test.findUserBeanById",1);  
          
        System.out.println(user);  
        //释放资源  
        sqlSession.close(); 
	}
}
