#认识 IoC

##IoC 发展简介

    • 1983年，Richard E. Sweet 在《The Mesa Programming Environment》中提出“Hollywood 
    Principle”（好莱坞原则）
    • 1988年，Ralph E. Johnson & Brian Foote 在《Designing Reusable Classes》中提出“Inversion 
    of control”（控制反转）
    • 1996年，Michael Mattsson 在《Object-Oriented Frameworks, A survey of methodological 
    issues》中将“Inversion of control”命名为 “Hollywood principle”
    • 2004年，Martin Fowler 在《Inversion of Control Containers and the Dependency Injection 
    pattern》中提出了自己对 IoC 以及 DI 的理解
    • 2005年，Martin Fowler 在 《InversionOfControl》对 IoC 做出进一步的说明
    
##IoC 主要实现策略


##IoC 容器的职责

    • 通用职责
    • 依赖处理
        • 依赖查找
        • 依赖注入
    • 生命周期管理
        • 容器
        • 托管的资源（Java Beans 或其他资源）
    • 配置
        • 容器
        • 外部化配置
        • 托管的资源（Java Beans 或其他资源）
    
##IoC 容器的实现

    主要实现
    
    • Java SE
        • Java Beans
        • Java ServiceLoader SPI
        • JNDI（Java Naming and Directory Interface） 
    
    • Java EE
        • EJB（Enterprise Java Beans） 
        • Servlet 
    
    • 开源
        • Apache Avalon（http://avalon.apache.org/closed.html） 
        • PicoContainer（http://picocontainer.com/） 
        • Google Guice（https://github.com/google/guice） 
        • Spring Framework（https://spring.io/projects/spring-framework）
        
        
##传统 IoC 容器的实现

     Java Beans 作为 IoC 容器
    • 特性
        • 依赖查找
        • 生命周期管理
        • 配置元信息
        • 事件
        • 自定义
        • 资源管理
        • 持久化
        
    • 规范
        • JavaBeans：https://www.oracle.com/technetwork/java/javase/tech/index-jsp-138795.html
        • BeanContext：https://docs.oracle.com/javase/8/docs/technotes/guides/beans/spec/beancontext.html
        
        
#Spring IoC 容器概述

##Spring IoC 依赖查找

    • 根据 Bean 名称查找
        • 实时查找
        • 延迟查找
    • 根据 Bean 类型查找
        • 单个 Bean 对象
        • 集合 Bean 对象
    • 根据 Bean 名称 + 类型查找
    • 根据 Java 注解查找
        • 单个 Bean 对象
        • 集合 Bean 对象
        
##Spring IoC 依赖注入

    • 根据 Bean 名称注入
    • 根据 Bean 类型注入
        • 单个 Bean 对象
        • 集合 Bean 对象
    • 注入容器內建 Bean 对象
    • 注入非 Bean 对象
    • 注入类型
        • 实时注入
        • 延迟注入
        
##Spring IoC 依赖来源

    • 自定义 Bean
    • 容器內建 Bean 对象
    • 容器內建依赖
    
##Spring IoC 配置元信息

    • Bean 定义配置
        • 基于 XML 文件
        • 基于 Properties 文件
        • 基于 Java 注解
        • 基于 Java API（专题讨论）
    • IoC 容器配置
        • 基于 XML 文件
        • 基于 Java 注解
        • 基于 Java API （专题讨论）
    • 外部化属性配置
        • 基于 Java 注解
        
##Spring 应用上下文

    • ApplicationContext 除了 IoC 容器角色，还有提供：
        • 面向切面（AOP） 
        • 配置元信息（Configuration Metadata） 
        • 资源管理（Resources） 
        • 事件（Events） 
        • 国际化（i18n） 
        • 注解（Annotations） 
        • Environment 抽象（Environment Abstraction）
        
##Spring IoC 容器生命周期

    • 启动
    • 运行
    • 停止
    
#Spring IoC 依赖查找

##单一类型依赖查找

    • 单一类型依赖查找接口 - BeanFactory
    
        • 根据 Bean 名称查找
            • getBean(String)
            • Spring 2.5 覆盖默认参数：getBean(String,Object...)
            
        • 根据 Bean 类型查找
            • Bean 实时查找
                • Spring 3.0 getBean(Class)
                • Spring 4.1 覆盖默认参数：getBean(Class,Object...)
            • Spring 5.1 Bean 延迟查找
                • getBeanProvider(Class)
                • getBeanProvider(ResolvableType)
                
        • 根据 Bean 名称 + 类型查找：getBean(String,Class)
        
##集合类型依赖查找

    • 集合类型依赖查找接口 - ListableBeanFactory
    
        • 根据 Bean 类型查找
            • 获取同类型 Bean 名称列表
                • getBeanNamesForType(Class)
                • Spring 4.2 getBeanNamesForType(ResolvableType)
            • 获取同类型 Bean 实例列表
                • getBeansOfType(Class) 以及重载方法
                
        • 通过注解类型查找
            • Spring 3.0 获取标注类型 Bean 名称列表
                • getBeanNamesForAnnotation(Class<? extends Annotation>)
            • Spring 3.0 获取标注类型 Bean 实例列表
                • getBeansWithAnnotation(Class<? extends Annotation>)
            • Spring 3.0 获取指定名称 + 标注类型 Bean 实例
                • findAnnotationOnBean(String,Class<? extends Annotation>)
                
##延迟依赖查找

    • Bean 延迟依赖查找接口
    
        • org.springframework.beans.factory.ObjectFactory
        
        • org.springframework.beans.factory.ObjectProvider
            • Spring 5 对 Java 8 特性扩展
                • 函数式接口
                    • getIfAvailable(Supplier)
                    • ifAvailable(Consumer)
                • Stream 扩展 - stream()
                
##安全依赖查找

    • 依赖查找安全性对比
    
    依赖查找类型                代表实现                                            是否安全
    
    单一类型查找                BeanFactory#getBean                                否
                              ObjectFactory#getObject                            否
                              ObjectProvider#getIfAvailable                      是
                              
    集合类型查找                ListableBeanFactory#getBeansOfType                 是
                              ObjectProvider#stream                              是
                              
    注意：层次性依赖查找的安全性取决于其扩展的单一或集合类型的 BeanFactory 接口
    
##内建可查找的依赖   

    • AbstractApplicationContext 内建可查找的依赖
    Bean 名称                                Bean 实例                                使用场景
    environment                             Environment 对象                         外部化配置以及 Profiles
    systemProperties                        java.util.Properties 对象                Java 系统属性
    systemEnvironment                       java.util.Map 对象                       操作系统环境变量
    messageSource                           MessageSource 对象                       国际化文案
    lifecycleProcessor                      LifecycleProcessor 对象                  Lifecycle Bean 处理器
    applicationEventMulticaster             ApplicationEventMulticaster 对象         Spring 事件广播器
    
##内建可查找的依赖

    • 注解驱动 Spring 应用上下文内建可查找的依赖
    
    Bean 名称                                                                Bean 实例                                                                使用场景
    
    org.springframework.context.annotation.                                 ConfigurationClassPostProcessor 对象                                    处理 Spring 配置类
    internalConfigurationAnnotationProcessor
   
    
    org.springframework.context.annotation.                                 AutowiredAnnotationBeanPostProcessor 对象                              处理 @Autowired 以及 @Value注解
    internalAutowiredAnnotationProcessor
   
    
    org.springframework.context.annotation.                                 CommonAnnotationBeanPostProcessor 对象                                （条件激活）处理 JSR-250 注解，如 @PostConstruct 等
    internalCommonAnnotationProcessor
    
    
    org.springframework.context.event.                                      EventListenerMethodProcessor对象                                       处理标注 @EventListener 的Spring 事件监听方法
    internalEventListenerProcessor
   
    org.springframework.context.event.                                      DefaultEventListenerFactory 对象                                       @EventListener 事件监听方法适配为 ApplicationListener
    internalEventListenerFactory
  
   
    org.springframework.context.annotation.                                 PersistenceAnnotationBeanPostProcessor 对象                            （条件激活）处理 JPA 注解场景
    internalPersistenceAnnotationProcessor
    
##依赖查找中的经典异常

    • BeansException 子类型
    
    异常类型                                 触发条件（举例）                                 场景举例
    
    NoSuchBeanDefinitionException           当查找 Bean 不存在于 IoC 容器时                  BeanFactory#getBean
                                                                                          ObjectFactory#getObject
    NoUniqueBeanDefinitionException         类型依赖查找时，IoC 容器存在多个 Bean 实例         BeanFactory#getBean(Class)
   
    BeanInstantiationException              当 Bean 所对应的类型非具体类时                    BeanFactory#getBean
    BeanCreationException                   当 Bean 初始化过程中                            Bean 初始化方法执行异常时
    BeanDefinitionStoreException            当 BeanDefinition 配置元信息非法时               XML 配置资源无法打开时
   
   
    
 