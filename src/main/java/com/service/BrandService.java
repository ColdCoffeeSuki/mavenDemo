package com.service;

import com.Dao.BrandMapper;
import com.pojo.Brand;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {

    //1.獲取SqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {
        //2.獲取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.獲取Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.調用方法
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    public void add(Brand brand) {
        //2.獲取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.獲取Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.調用方法
        mapper.add(brand);

        //5.提交事務
        sqlSession.commit();
        //釋放資源
        sqlSession.close();

    }

    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public void update(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.delete(brand);
        sqlSession.commit();
        sqlSession.close();
    }
}
