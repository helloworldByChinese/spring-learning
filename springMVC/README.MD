## 一个http请求的旅程
1. servlet容器接收http请求；
2. Filter过滤器进行过滤，幸存者继续走下去，淘汰者返回或其他操作；
3. servlet容器将请求传给DispatcherServlet；
4. DispatcherServlet将请求传递给HandlerMapping获取到该请求相应的handler
(处理器和可能存在的拦截器）；
5. 根据处理器获取到相应的HandlerAdapter处理器适配器；
6. handler执行拦截器preHandle方法；
7. HandlerAdapter执行handler处理器返回ModelView；
8. handler执行拦截器的postHandle方法；
9. DispatcherServlet调用视图解析器根据ModelView解析到正确的view进行渲染；
10. 页面显示；
11. 执行handler的afterCompleteHandle方法清理或生成日志等；

## 注意点
我们获取到的handler通常是一个AOP生成的代理对象，拦截器本质就是AOP的一种运用。
