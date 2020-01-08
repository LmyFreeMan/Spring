package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;
    //添加事务注解
    @Transactional(
            //事务的传播行为
            propagation = Propagation.REQUIRED,
            //事务的隔离级别
            isolation = Isolation.READ_COMMITTED
    )
    @Override
    public void purchase(String username, String number) {
        //1.获取书的单价
        int price=bookShopDao.findBookPriceByBookNum(number);
        //2.更新数的库存
        bookShopDao.updateBookStock(number);
        //3.更新用户余额
        bookShopDao.updateUserAccount(username,price);
    }

    public void setBookShopDao(BookShopImpl bookShopDao) {
    }
}