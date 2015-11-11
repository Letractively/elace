# Introduction #

String + Hibernate（Annotation） 遇到 No Hibernate Session bound to thread, and configuration does not allow creation


# Details #

Spring Reference 原文：



&lt;tx:annotation-driven/&gt;

 only looks for @Transactional on beans in the same application context it is defined in. This means that, if you put 

&lt;tx:annotation-driven/&gt;

 in a WebApplicationContext for a DispatcherServlet, it only checks for @Transactional beans in your controllers, and not your services.




&lt;tx:annotation-driven /&gt;

 仅仅在配置该行的配置文件中寻找对应的Bean.这就意味着在在Servlet配置文件中配置该行，那么仅仅取检查所有的Controller Bean,而不会取查找其他的Service Bean。然而对于已经配置了的Bean,并不会做二次的配置，这也就意味着，即时在Context配置文件中也配置tx:annotation-driven,由于该Bean已经配置了，所以@Transactional并不会再进行事务的配置。

解决方案：

Referrence：

http://java.dzone.com/articles/how-i-resolved