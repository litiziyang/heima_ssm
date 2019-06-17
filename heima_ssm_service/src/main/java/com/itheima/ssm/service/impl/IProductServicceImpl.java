package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IProductServicceImpl implements IProductService {
@Autowired
    private IProductDao iProductDao;

    public List<Product> findAll() {
        List<Product> list = iProductDao.findAll();
        return list;
    }

    @Override
    @Transactional
    public void save(Product product) {
        iProductDao.save(product);
    }
}
