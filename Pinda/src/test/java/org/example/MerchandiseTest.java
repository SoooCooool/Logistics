package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.MerchandiseMapper;
import org.example.pojo.Merchandise;
import org.example.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class MerchandiseTest {
    @Test
    public void find(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MerchandiseMapper merchandiseMapper = sqlSession.getMapper(MerchandiseMapper.class);
        List<Merchandise> Merchandises =
                merchandiseMapper.findall();
        for(Merchandise mce : Merchandises){
            System.out.println(mce);
        }
            /*sqlSession.commit();
            sqlSession.close();*/
    }
    @Test
    public void findbyid(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MerchandiseMapper merchandiseMapper = sqlSession.getMapper(MerchandiseMapper.class);
        Merchandise merchandises =
                merchandiseMapper.findbyid("D001");

            System.out.println(merchandises);
            /*sqlSession.commit();
            sqlSession.close();*/
    }
    @Test
    public void find1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MerchandiseMapper merchandiseMapper = sqlSession.getMapper(MerchandiseMapper.class);
        List<Merchandise> merchandises =
                merchandiseMapper.findMerchandisebykindandstate("生活用品","运输中");
        for(Merchandise mce : merchandises){
            System.out.println(mce);
        }
    }
    @Test
    public void insert(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MerchandiseMapper merchandiseMapper = sqlSession.getMapper(MerchandiseMapper.class);
        Merchandise merchandise = new Merchandise();
        merchandise.setKind("生活用品");
        Date i = new Date(153,9,8);
        Date o = new Date(153,9,11);
        Date o1 = new Date(153,9,11);
        merchandise.setOrderid("D002");
        merchandise.setArrivetransfertime(o);
        merchandise.setWeight(2);
        merchandise.setPresentlocation("长沙");
        merchandise.setPresentstate("运输中");
        merchandise.setFinaltime(i);
        merchandise.setStarttime(o1);
        merchandiseMapper.insert(merchandise);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void delete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MerchandiseMapper merchandiseMapper = sqlSession.getMapper(MerchandiseMapper.class);
        merchandiseMapper.delete("D002");
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void update(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MerchandiseMapper merchandiseMapper = sqlSession.getMapper(MerchandiseMapper.class);
        Merchandise merchandise = new Merchandise();
        merchandise.setKind("生活用品");
        Date i = new Date(153,9,8);
        Date o = new Date(153,9,11);
        Date o1 = new Date(153,9,11);
        merchandise.setOrderid("D002");
        merchandise.setArrivetransfertime(o);
        merchandise.setWeight(4);
        merchandise.setPresentlocation("广东");
        merchandise.setPresentstate("派送中");
        merchandise.setFinaltime(i);
        merchandise.setStarttime(o1);
        merchandiseMapper.update(merchandise);
        sqlSession.commit();
        sqlSession.close();
    }
}
