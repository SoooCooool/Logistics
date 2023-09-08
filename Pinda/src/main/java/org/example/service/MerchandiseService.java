package org.example.service;

import org.example.pojo.Employee;
import org.example.pojo.Merchandise;

import java.util.List;

public interface MerchandiseService {
    public List<Merchandise> findall();
    public Merchandise findbyid (String id);

    public void deletemerchandisebyid(String id);


    public void insertmerchandise(Merchandise merchandise);

    public void updatemerchandisebyid(Merchandise merchandise);
}
