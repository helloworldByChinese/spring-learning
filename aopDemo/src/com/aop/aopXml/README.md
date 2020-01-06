### spring aop xml配置使用的简单demo
1. 首先创建Service，xml中`<bean>`标签实例化，然后IOC容器实例化，
获取Service实例对象，保证业务代码正常；
2. 创建Aspect对象类，然后xml中`<bean>`标签实例化，再用以下配置切面；
    1. `<aop:pointcut>`标签用于断言切面范围；
    2. `<aop:aspect>` 则用于创建切面，关联刚才`<bean>`实例化的ID；
    3. `<aop:before>`标签同级的几个主要用来定义不同类型的advice，
    表明在方法执行的不同阶段会出现相应的行为。
    *     <aop:config>
              <!-- 切点表达式 -->
              <aop:pointcut id="pointcut" expression="execution(* com.aop.aopXml.*Impl.*(..)) and !within(com.aop.aopXml.within.*Impl)"/>
              <!-- 配置切面及通知 -->
              <aop:aspect ref="loggingAspect" order="2">
                  <aop:before method="check" pointcut-ref="pointcut" />
                  <aop:after method="afterMethod" pointcut-ref="pointcut" />
                  <aop:after-returning method="afterReturning" pointcut-ref="pointcut" returning="result" />
                  <aop:after-throwing method="afterThrowing" pointcut-ref="pointcut" throwing="ex" />
                  <aop:around method="around" pointcut-ref="pointcut" />
              </aop:aspect>
              
              <aop:aspect ref="testingOrderAspect" order="12">
                  <aop:before method="before" pointcut-ref="pointcut" />
              </aop:aspect>
          </aop:config>
3. 切面的切入点的断言主要了解写法即可，无需刻意记忆，需要使用的时候查询即可。

4. 最后就是order属性用于表明切面行为的执行顺序先后。

