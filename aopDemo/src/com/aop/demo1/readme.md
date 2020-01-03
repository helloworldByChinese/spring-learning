Spring aop 使用步骤：
    1. 加入对应的jar包火maven依赖
        com.springsource.org.aopalliance-1.0.0.jar
        com.springsource.org.aspectj.weaver-1.7.2.RELEASE.jar
        spring-aop-5.2.0.RELEASE.jar
        spring-aspects-5.2.0.RELEASE.jar
        
        以下五个为spring基础引用包
        commons-logging-1.2.jar
        spring-beans-5.2.0.RELEASE.jar
        spring-context-5.2.0.RELEASE.jar
        spring-core-5.2.0.RELEASE.jar
        spring-expression-5.2.0.RELEASE.jar
        
    2. 在配置文件中加入aop的命名空间
        xmlns:context
        xmlns:aop
        xsi:schemaLocation
        
    3. 基于注解的方式配置切面类
        
        A. 在xml文件中配置扫描默认路径以及自动装配AOP代理
            <context:component-scan base-package="com.aop.demo1"/>
            <aop:aspectj-autoproxy/>
        B. 把横切面的关注点的代码抽象到配置切面类aspect 
            demo1包中的LoggingAspect
            i. 切面首先是IOC容器的bean，故有@Component
            ii. 其次需要声明这是一个切面类@Aspect
        C. 在类中声明各种切入点@Pointcut
            当多个通知用到同一个切入点时方便统一管理
        D. 声明各种通知，如@Before
            还可以加入参数连接点joinpoint来获取细节， 如方法名以及参数
     