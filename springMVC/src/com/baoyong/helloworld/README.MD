### springMVC DEMO
1. 创建一个web项目，加入jar包；
2. 在web.xml中配置DispatcherServlet；
*         <!-- 配置DispatcherServlet -->
             <servlet>
                 <servlet-name>springDispatcherServlet</servlet-name>
                 <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
                 <!-- 配置DispatcherServlet 的一个初始化参数: 配置springMVC的配置文件的路径和名称 -->
                 <init-param>
                     <param-name>contextConfigLocation</param-name>
                     <param-value>classpath:com/baoyong/helloworld/spring-mvc.xml</param-value>
                 </init-param>
                 <!-- 设置web在应用启动的时候就创建，而不是应用加载的时候才创建 -->
                 <load-on-startup>1</load-on-startup>
             </servlet>
             <!-- 匹配对应路径的请求，/ 表示响应所有请求 -->
             <servlet-mapping>
                 <servlet-name>springDispatcherServlet</servlet-name>
                 <url-pattern>/</url-pattern>
             </servlet-mapping>
2. 创建springMVC的配置文件，配置扫描根路径和配置视图解析器。
*       <!-- 配置扫描bean注册到IOC容器的根地址 -->
        <context:component-scan base-package="com.baoyong.helloworld"/>
    
        <!-- 配置视图解析器： 如何把handler 方法返回值解析为实际的物理视图 -->
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/views/" />
            <property name="suffix" value=".jsp" />
        </bean>

3. 编写请求的处理器，并标识为处理器



### 说明
1. Controller返回值到会被步骤二中的视图解析器获取到，然后拼接形成完整的静态资源路径，
然后读取相应位置的文件返回给前端。

2. 需要注意的是，本项目由于没使用maven等依赖工具，因此必须要
将jar包放在/WEB-INF/lib目录下才会在tomcat需要用的WAR包中出现依赖的jar包。