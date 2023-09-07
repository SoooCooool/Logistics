package org.example.dao;


import org.example.pojo.Transfer;

import java.util.List;

public interface TransferMapper {

    public List<Transfer> findAll();

    public Transfer getTransferByName(String transfer);
}
