package org.example.service.impl;

import org.example.dao.AdministratorMapper;
import org.example.dao.TransferMapper;
import org.example.pojo.Transfer;
import org.example.service.TransferService;

import java.util.List;

public class TransferServiceImpl implements TransferService {
    TransferMapper transferMapper;
    public List<Transfer> queryTransferAll(){
        return transferMapper.findAll();
    };
}
