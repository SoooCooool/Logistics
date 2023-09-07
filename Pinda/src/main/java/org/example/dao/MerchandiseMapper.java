package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Merchandise;

import java.util.List;


public interface MerchandiseMapper {
    public List<Merchandise> findall();
    public void insert(Merchandise merchandise);
    public void delete(String order_id);
    public void update(Merchandise merchandise);
    public List<Merchandise> findMerchandisebykindandstate(
            @Param("kind") String kind,
            @Param("present_state") String present_state);
}
