package com.Dao;

import com.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();

    void add(Brand brand);

    Brand selectById(int id);

    void update(Brand brand);

    void delete(Brand brand);
}
