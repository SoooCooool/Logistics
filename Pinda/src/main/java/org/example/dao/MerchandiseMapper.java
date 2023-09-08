package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Merchandise;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository

public interface MerchandiseMapper {
    public List<Merchandise> findall();
    public Merchandise findbyid(String order_id);
    public void insert(Merchandise merchandise);
    public void delete(String order_id);
    public void update(Merchandise merchandise);
    public List<Merchandise> findMerchandisebykindandstate(
            @Param("kind") String kind,
            @Param("present_state") String present_state);
}
