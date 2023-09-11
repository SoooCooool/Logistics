package org.example.service.impl;


import org.example.dao.MerchandiseMapper;
import org.example.pojo.Merchandise;
import org.example.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchandiseServiceImpl implements MerchandiseService {
    @Autowired
    private MerchandiseMapper merchandiseMapper;

    @Override
    public List<Merchandise> findall() {
        return merchandiseMapper.findall();
    }

    @Override
    public Merchandise findbyid(String id) {
        return merchandiseMapper.findbyid(id);
    }

    @Override
    public void deletemerchandisebyid(String id) {
        merchandiseMapper.delete(id);
    }

    @Override
    public void insertmerchandise(Merchandise merchandise) {
        merchandiseMapper.insert(merchandise);
    }

    @Override
    public void updatemerchandisebyid(Merchandise merchandise) {
        merchandiseMapper.update(merchandise);
    }
}
