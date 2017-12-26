package cn.fooxin.web.service;

import cn.fooxin.web.domain.Product;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/26.
 */

public interface ProductService extends BaseService<Product> {

    List<Product> findAll();

}
