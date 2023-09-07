package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.TransferMapper;
import org.example.pojo.Transfer;
import org.example.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class TransferTest {

    @Test
    public void testQueryAllTransfer(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        TransferMapper transferMapper =
                sqlSession.getMapper(TransferMapper.class);

        List<Transfer> transfer = transferMapper.findAll();
        for(Transfer transfers : transfer){
            System.out.println(transfers);
        }
        sqlSession.close();
    }

    @Test
    public void testGetTransferByName(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        //2.创建TransferMapper的代理对象
        TransferMapper transferMapper =
                sqlSession.getMapper(TransferMapper.class);
        //3.实现查询操作
        Transfer transfer = transferMapper.getTransferByName("东北-吉林");
        System.out.println(transfer);
        //4.关闭SqlSession对象
        sqlSession.close();

    }
}
