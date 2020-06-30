#Spring Framework 总览

##Spring 特性总览
###核心特性（Core）

    • IoC 容器（IoC Container）   
    • 资源管理（Resources） 
    • 国际化（i18n） 
    • 校验（Validation） 
    • 数据绑定（Data Binding） 
    • 类型转换（Type Conversion） 
    • Spring 事件（Events） 
    • Spring 表达式（Spring Express Language） 
    • 面向切面编程（AOP）
    
###数据存储（Data Access）

    • JDBC
    • 事务抽象（Transactions） 
    • DAO 支持（DAO Support） 
    • O/R映射（O/R Mapping） 
    • XML 编列（XML Marshalling）
    
###Web 技术（Web）

    • Web Servlet 技术栈
        • Spring MVC
        • WebSocket
        • SockJS
        
    • Web Reactive 技术栈
        • Spring WebFlux
        • WebClient
        • WebSocket
        
###技术整合（Integration）

    • 远程调用（Remoting） 
    • Java 消息服务（JMS） 
    • Java 连接架构（JCA） 
    • Java 管理扩展（JMX） 
    • Java 邮件客户端（Email） 
    • 本地任务（Tasks） 
    • 本地调度（Scheduling） 
    • 缓存抽象（Caching） 
    • Spring 测试（Testing）
    
###测试（Testing）
    
    • 模拟对象（Mock Objects） 
    • TestContext 框架（TestContext Framework） 
    • Spring MVC 测试（Spring MVC Test） 
    • Web 测试客户端（WebTestClient）
    
##Spring 版本特性

###Java 版本依赖与支持

    Spring Framework 版本         Java 标准版         Java 企业版
    
    1.x                          1.3+                J2EE 1.3 +
    2.x                          1.4.2+              J2EE 1.3 +
    3.x                          5+                  J2EE 1.4 和 Java EE 5
    4.x                          6+                  Java EE 6 和 7
    5.x                          8+                  Java EE 7
    
##Spring 模块化设计

###Spring 模块

    • spring-aop
    • spring-aspects
    • spring-context-indexer
    • spring-context-support
    • spring-context
    • spring-core
    • spring-expression
    • spring-instrument
    • spring-jcl
    • spring-jdbc
    • spring-jms
    • spring-messaging
    • spring-orm
    • spring-oxm
    • spring-test
    • spring-tx
    • spring-web
    • spring-webflux
    • spring-webmvc
    • spring-websocket
    
##Spring 对 Java 语言特性运用

    • Java 5 语法特性
    语法特性                 Spring 支持版本                 代表实现
    注解（Annotation）       1.2 +                          @Transactional
    枚举（Enumeration）      1.2 +                          Propagation
    for-each语法            3.0 +                          AbstractApplicationContext
    自动装箱（AutoBoxing）   3.0 +
    泛型（Generic）          3.0 +                          ApplicationListener
    
    • Java 6 语法特性
    语法特性                 Spring 支持版本                 代表实现
    接口 @Override           4.0 +
    
    • Java 7 语法特性
    语法特性                 Spring 支持版本                 代表实现
    Diamond 语法             5.0 +                          DefaultListableBeanFactory
    try-with-resources 语法  5.0 +                          ResourceBundleMessageSource
   
    • Java 8 语法特性
    语法特性                 Spring 支持版本                 代表实现
    Lambda 语法              5.0 +                         PropertyEditorRegistrySupport
    
##Spring 对 JDK API 实践

###JDK 核心 API

    < Java 5
    反射（Reflection）
    Java Beans
    动态代理（Dynamic Proxy）
    
    Java 5
    并发框架（J.U.C）
    格式化（Formatter）
    Java 管理扩展（JMX）
    Instrumentation
    XML 处理（DOM、SAX、XPath、XSTL）
    
    Java 6
    JDBC 4.0（JSR 221）
    JAXB 2.0（JSR 222）
    可插拔注解处理 API（JSR 269）
    Common Annotations（JSR 250）
    Java Compiler API（JSR 199）
    Scripting in JVM（JSR 223）
    
    Java 7
    
    NIO 2（JSR 203）
    Fork/Join 框架（JSR 166）
    invokedynamic 字节码（JSR 292）
    
    Java 8
    Stream API（JSR 335）
    CompletableFuture（J.U.C）
    Annotation on Java Types（JSR 308）
    Date and Time API（JSR 310）
    可重复 Annotations（JSR 337）
    JavaScript 运行时（JSR 223）
    
    Java 9
    Reactive Streams Flow API （J.U.C）
    Process API Updates（JEP 102）
    Variable Handles（JEP 193）
    Method Handles（JEP 277）
    Spin-Wait Hints（JEP 285）
    Stack-Walking API（JEP 259）
    
###Spring 对 JDK API 实践

    • < Java 5 API
    
    API 类型                     Spring 支持版本                     代表实现
    反射（Reflection）            1.0 +                              MethodMatcher
    Java Beans                   1.0 +                              CachedIntrospectionResults
    动态代理（Dynamic Proxy）      1.0 +                              JdkDynamicAopProxy
    
    • Java 5 API
    API 类型                     Spring 支持版本                     代表实现
    XML 处理（DOM,SAX...）        1.0 +                              XmlBeanDefinitionReader
    Java 管理扩展（JMX）           1.2 +                              @ManagedResource
    Instrumentation              2.0 +                              InstrumentationSavingAgent
    并发框架（J.U.C）              3.0 +                              ThreadPoolTaskScheduler
    格式化（Formatter）            3.0 +                              DateFormatter
    
    • Java 6 API
    API 类型                               Spring 支持版本                     代表实现
    JDBC 4.0（JSR 221）                    1.0 +                              JdbcTemplate
    Common Annotations（JSR 250）          2.5 +                              CommonAnnotationBeanPostProcessor
    JAXB 2.0（JSR 222）                    3.0 +                              Jaxb2Marshaller
    Scripting in JVM（JSR 223）            4.2 +                              StandardScriptFactory
    可插拔注解处理 API（JSR 269）            5.0 +                              @Indexed
    Java Compiler API（JSR 199）           5.0 +                              TestCompiler（单元测试）
    
    • Java 7 API
    API 类型                               Spring 支持版本                      代表实现
    Fork/Join 框架（JSR 166）               3.1 +                               ForkJoinPoolFactoryBean
    NIO 2（JSR 203）                       4.0 +                                PathResource
    
    • Java 8 API
    API 类型                               Spring 支持版本                      代表实现
    Date and Time API（JSR 310）           4.0 +                               DateTimeContext
    可重复 Annotations（JSR 337）           4.0 +                               @PropertySources
    Stream API（JSR 335）                  4.2 +                               StreamConverter
    CompletableFuture（J.U.C）             4.2 +                               CompletableToListenableFutureAdapter
    
##Spring 对 Java EE API 整合

###Java EE Web 技术相关

    JSR 规范                               Spring 支持版本                               代表实现
    Servlet + JSP(JSR 035）                1.0 +                                        DispatcherServlet
    JSTL(JSR 052)                          1.0 +                                        JstlView
    JavaServer Faces(JSR 127)              1.1 +                                        FacesContextUtils
    Portlet(JSR 168)                       2.0 -                                        4.2 DispatcherPortlet
    SOAP(JSR 067)                          2.5 +                                        SoapFaultException
    WebServices(JSR 109)                   2.5 +                                        CommonAnnotationBeanPostProcessor
    WebSocket(JSR 356)                     4.0 +                                        WebSocketHandler

###Java EE 数据存储相关

    JSR 规范                               Spring 支持版本                               代表实现
    JDO(JSR 12)                            1.0 - 4.2                                   JdoTemplate
    JTA(JSR 907)                           1.0 +                                       JtaTransactionManager
    JPA(EJB 3.0 JSR 220的成员)              2.0 +                                       JpaTransactionManager
    Java Caching API(JSR 107)              3.2 +                                       JCacheCache
    
###Java EE Bean 技术相关

    JSR 规范                                   Spring 支持版本                               代表实现
    JMS(JSR 914)                               1.1 +                                       JmsTemplate
    EJB 2.0 (JSR 19)                           1.0 +                                       AbstractStatefulSessionBean
    Dependency Injection for Java(JSR 330)     2.5 +                                       AutowiredAnnotationBeanPostProcessor
    Bean Validation(JSR 303)                   3.0 +                                       LocalValidatorFactoryBean
    
##Spring 编程模型

###Spring 编程模型

    面向对象编程
    
        契约接口：Aware、BeanPostProcessor ...
        设计模式：观察者模式、组合模式、模板模式 ...
        对象继承：Abstract* 类
        
    函数驱动
    
        函数接口：ApplicationEventPublisher
        Reactive：Spring WebFlux
    
    面向切面编程
    
        动态代理：JdkDynamicAopProxy
        字节码提升：ASM、CGLib、AspectJ...
    
    模块驱动
    
        Maven Artifacts
        OSGI Bundles
        Java 9 Automatic Modules
        Spring @Enable*
    
    面向元编程
    
        注解：模式注解（@Component、@Service、@Respository ...）
        配置：Environment 抽象、PropertySources、BeanDefinition ...
        泛型：GenericTypeResolver、ResolvableType ...