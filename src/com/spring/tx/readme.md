 - 配置事务管理器
 <!--配置事务管理器-->
 
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource1"></property>
    </bean>
    
- 启用事务注解

    <!--启用事务注解-->
    <tx:annotation-driven transaction-manager="transactionManager"/><br/>
     @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.DEFAULT)<br/>
     propagation:事务的传播行为<br/>
     isolation:事务的隔离级别<br/>
     默认情况下Spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置<br/>
     使用readOnly指定事务是否为只读,可以帮助数据库引擎优化事务<br/>
     timeout指定强制回滚之前事务可以占用的时间<br/>
     
     
     
    
    