package org.example.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Transfer;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface TransferMapper {

    public List<Transfer> findAll();

    public Transfer getTransferByName(String transfer);
}
