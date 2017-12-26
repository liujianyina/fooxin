package cn.fooxin.web.service.impl;

import cn.fooxin.web.domain.Product;
import cn.fooxin.web.repository.ProductRepository;
import cn.fooxin.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/26.
 */

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductRepository> implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    @Override
    public void setRepository(ProductRepository repository) {
        this.productRepository = repository;
        this.baseRepository = repository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
