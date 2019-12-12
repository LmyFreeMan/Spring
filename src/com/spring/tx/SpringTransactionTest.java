package com.spring.tx;
import	java.lang.annotation.Target;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {
    private ApplicationContext ctx=null;
    private BookShopDao bookShopDao=null;
    private BookShopService bookShopService=null;
    {
        ctx=new ClassPathXmlApplicationContext("tx.xml");
        bookShopDao=ctx.getBean(BookShopDao.class);
        bookShopService=ctx.getBean(BookShopService.class);
    }
    @Test
    public void testBookShopDaoFindPriceByBookNum(){
        System.out.println(bookShopDao.findBookPriceByBookNum("1001"));
    }
    @Test
    public void testBookShopDaoUpdateBookStock() {
        bookShopDao.updateBookStock("1001");
    }
    @Test
    public void testBookShopDaoUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA",100);
    }
    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA","1001");
    }
}