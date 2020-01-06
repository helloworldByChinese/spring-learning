### spring启用事务的两种方案:
1. 简单事务   
   1. 配置事务管理器transactionManager
   2. 使用标签`<tx:annotation-driven/>`指定第一步创建的事务管理器
   
2. 多事务管理器 | 自定义连接点的事务管理器
   1. 配置事务管理器transactionManagerOne
   2. 配置事务属性，也可以说是配置事务对应的管理器和需要处理的方法`<tx:advice>`
   3. 配置`<aop:config>`
       *      1.配置事务切入点`<aop:pointcut/>`   
              2.配置`<aop:advisor/>`定义通知器，将事务的工作advice与切入点pointcut关联起来
          
3. `<tx:advice>` 中的 `<tx:attributes>`
    * `<tx:method name="*" propagation = "REQUIRED"/>`该配置可导致所有服务默认开启事务
    * 还需要注意的就是注解的时候默认propagation都是REQUIRED的，若需要配置其他传播机制，
    需要在XML文件中配置才会生效，注解上配置并不会有效果。
    *     <tx:attributes>
             <tx:method name="*"/>
             <tx:method name="*NotSupported" propagation="NOT_SUPPORTED" />
          </tx:attributes>

#### 意外收获
1. 尝试同时配置以上两种方案时且使用相同的事务管理器BEAN 的ID时，
系统会采用`<aop:config>`内的配置内容。
2. `<aop:advisor>` 和 `<aop:aspect>` 的区别
    *       目前发现的是前者一般用于advice封装好的情况，后者用于自定义advice的情况较多
    
3. pointcut的注解需要注意execution类型的，其他的需要的时候再看文档
    *       execution(* com.aop.tx..*(..))
            execution(* com.aop.tx.*.*(..))