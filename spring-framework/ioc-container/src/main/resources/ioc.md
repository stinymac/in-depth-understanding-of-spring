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