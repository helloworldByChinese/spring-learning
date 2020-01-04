### Spring aop 使用步骤： 
1. 加入jar包 
   1. 以下五个为spring基础引用包  
       * commons-logging-1.2.jar
       * spring-beans-5.2.0.RELEASE.jar
       * spring-context-5.2.0.RELEASE.jar
       * spring-core-5.2.0.RELEASE.jar
       * spring-expression-5.2.0.RELEASE.jar
   2. 加入aop的jar包     
       * com.springsource.org.aopalliance-1.0.0.jar  
       * com.springsource.org.aspectj.weaver-1.7.2.RELEASE.jar  
       * spring-aop-5.2.0.RELEASE.jar  
       * spring-aspects-5.2.0.RELEASE.jar  
        
2. 在配置文件中加入aop的命名空间
   * xmlns:context
   * xmlns:aop
   * IDEA 可以直接使用标签，xml文件会自动补全命名空间
        
3. 基于注解的方式配置切面类

   1. 在xml文件中配置扫描默认路径以及开启自动装配AOP代理
      *     <context:component-scan base-package="com.aop.demo1"/>
            <aop:aspectj-autoproxy/>
   2. 把横切面的关注点的代码抽象到配置切面类aspect——demo1包中的LoggingAspect
      *      i. 切面首先是IOC容器的bean，故有@Component
            ii. 其次需要声明这是一个切面类@Aspect
   3. 在类中声明各种切入点@Pointcut
      *     当多个通知用到同一个切入点时方便统一管理
   4. 声明各种通知，如@Before
      *      还可以加入参数连接点joinpoint来获取细节， 如方法名以及参数
     
   5. 调用同一类内部的方法不会经过切面，也就是说声明式事务管理@Transactional注解不会管理同类内的方法调用
        C. 在类中声明各种切入点@Pointcut
            当多个通知用到同一个切入点时方便统一管理
        D. 声明各种通知，如@Before
            还可以加入参数连接点joinpoint来获取细节， 如方法名以及参数
