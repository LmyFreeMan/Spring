package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopImpl implements BookShopDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int findBookPriceByBookNum(String bookNum) {
        String sql ="select price from book where book_number=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,bookNum);
    }
    @Override
    public void updateBookStock(String bookNum) {
        //检查书的库存是否足够,若不够，则抛出异常
        String validationSql="SELECT book_stock FROM stock WHERE book_number=?";
        int stock=jdbcTemplate.queryForObject(validationSql,Integer.class,bookNum);
        if(stock==0){
            throw new BookStockException("库存不足");
        }
        String sql ="update stock set book_stock=book_stock-1 where book_number=?";
        jdbcTemplate.update(sql,bookNum);
    }
    @Override
    public void updateUserAccount(String userName, int price) {
        //验证余额是否足够，若不够抛出异常
        String validationSql="SELECT balance FROM account WHERE username=?";
        int balance=jdbcTemplate.queryForObject(validationSql,Integer.class,userName);
        if(balance<price){
            throw new UserAccountException("余额不足");
        }
        String sql ="update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,userName);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    }
}