package com.spring.tx;

public interface BookShopDao {
    //根据书号获取书的单价
    public int findBookPriceByBookNum(String bookNum);
    //根据书的库存,使书号对应的库存减一
    public void updateBookStock(String bookNum);
    //更新用户的账户余额:使username的balance-price
    public void updateUserAccount(String userName,int price);
}
