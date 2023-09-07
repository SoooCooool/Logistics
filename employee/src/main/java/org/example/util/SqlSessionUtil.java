package org.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 功能：创建SqlSession对象，实现对SQL语句的操作
 */
public class SqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    static{
        InputStream inputSteam = null;
        try {
            inputSteam = Resources.getResourceAsStream("mybatis_config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputSteam);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能：创建SqlSession对象
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
