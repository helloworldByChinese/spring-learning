### java 简单的动态代理demo
1. 简介
    *     AOP的实现方式主要有两种
          1. 预编译——AspectJ
          2. 运行期动态代理
             主要分为JDK动态代理、 CGLib动态代理
             本DEMO主要实现一个简单的动态代理来说明Spring AOP的一个简单使用过程
2. DEMO过程
    1. 创建service以及对应的serviceImpl，此处仅做demo，可以直接创建serviceImpl；
    2. 实现几个简单的+-*/算法，main方法直接调用成功；
    3. 现在需要实现打印日志的需求，就创建ArithmeticProxy类，内带Service业务类的对象实例，
    且主要实现获取代理ProxyService的方法，其中主要的就是InvocationHandler#invoke()的方法的重写；
    4. 最后在main中就可以创建代理实例，然后像正常方法一样调用即可。
### 概念整理
1. 切面——Aspect
    * ArithmeticProxy类就充当着一个切面的作用（虽然这个切的范围很小）
2. 通知——advice
    * 执行ArithmeticProxy#invoke方法中出现的除method.invoke(...)以及最后的return，其他部分
    都可以认为是通知。
3. 代理——proxy
    * main方法中
    `ArithmeticService proxy = new ArithmeticProxy(service).getProxyService();`
    中的proxy实例对象就是代理。
4. 连接点——JoinPoint
    * advisorBefore方法和advisorAfter方法被调用时的位置就被称为JoinPoint;连接点有两个东西确定：
        * 方法名
        * 相对调用实际方法的位置
5. 目标对象——target
    * ArithmeticService就是AOP中的目标对象
6. 切入点——pointCut
    * 决定切面范围的断言，可类比表查询的条件语句
7. 引入——Introduction
    * 待了解
8. 织入——Weaving
    * 待了解
