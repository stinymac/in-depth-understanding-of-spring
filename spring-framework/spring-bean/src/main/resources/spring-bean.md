#Spring Bean 基础

##定义 Spring Bean

    BeanDefinition 是 Spring Framework 中定义 Bean 的配置元信息接口，包含：
    
        • Bean 的类名
        • Bean 行为配置元素，如作用域、自动绑定的模式，生命周期回调等
        • 其他 Bean 引用，又可称作合作者（collaborators）或者依赖（dependencies） 
        • 配置设置，比如 Bean 属性（Properties）
        
##BeanDefinition 元信息

    属性（Property）                               说明
    Class                               Bean全类名，必须是具体类，不能用抽象类或接口
    Name                                Bean 的名称或者 ID
    Scope                               Bean 的作用域（如：singleton、prototype 等）
    Constructor arguments               Bean 构造器参数（用于依赖注入）
    Properties                          Bean 属性设置（用于依赖注入）
    Autowiring mode                     Bean 自动绑定模式（如：通过名称 byName）
    Lazy initialization mode            Bean 延迟初始化模式（延迟和非延迟）
    Initialization method               Bean初始化回调方法名称
    Destruction method                  Bean 销毁回调方法名称

##BeanDefinition 元信息

    • BeanDefinition 构建
        • 通过 BeanDefinitionBuilder
        • 通过 AbstractBeanDefinition 以及派生类
        
##命名 Spring Bean

    • Bean 的名称
    每个 Bean 拥有一个或多个标识符（identifiers），这些标识符在 Bean 所在的容器必须是唯一
    的。通常，一个 Bean 仅有一个标识符，如果需要额外的，可考虑使用别名（Alias）来扩充。 
    
    在基于 XML 的配置元信息中，开发人员可用 id 或者 name 属性来规定 Bean 的 标识符。通常
    Bean 的 标识符由字母组成，允许出现特殊字符。如果要想引入 Bean 的别名的话，可在
    name 属性使用半角逗号（“,”）或分号（“;”) 来间隔。
    
    Bean 的 id 或 name 属性并非必须制定，如果留空的话，容器会为 Bean 自动生成一个唯一的
    名称。Bean 的命名尽管没有限制，不过官方建议采用驼峰的方式，更符合 Java 的命名约定。
    
    
    • Bean 名称生成器（BeanNameGenerator） 
    
        • 由 Spring Framework 2.0.3 引入，框架內建两种实现：
          DefaultBeanNameGenerator：默认通用 BeanNameGenerator 实现
          
        • AnnotationBeanNameGenerator：基于注解扫描的 BeanNameGenerator 实现，
          起始于Spring Framework 2.5
          
##注册 Spring Bean

    • BeanDefinition 注册
        • XML 配置元信息
        • <bean name=”...” ... />
        • Java 注解配置元信息
            • @Bean
            • @Component
            • @Import
        • Java API 配置元信息
            • 命名方式：BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
            • 非命名方式：
              BeanDefinitionReaderUtils#registerWithGeneratedName(AbstractBeanDefinition,BeanDefinitionRegistry)
        • 配置类方式：AnnotatedBeanDefinitionReader#register(Class...)
     
    • 外部单例对象注册
        • Java API 配置元信息
            • SingletonBeanRegistry#registerSingleton
            
            
##实例化 Spring Bean

    • Bean 实例化（Instantiation） 
        • 常规方式
            • 通过构造器（配置元信息：XML、Java 注解和 Java API ） 
            • 通过静态工厂方法（配置元信息：XML 和 Java API ） 
            • 通过 Bean 工厂方法（配置元信息：XML和 Java API ） 
            • 通过 FactoryBean（配置元信息：XML、Java 注解和 Java API ） 
        • 特殊方式
            • 通过 ServiceLoaderFactoryBean（配置元信息：XML、Java 注解和 Java API ） 
            • 通过 AutowireCapableBeanFactory#createBean(java.lang.Class, int, boolean)
            • 通过 BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
            
##初始化 Spring Bean     

    • Bean 初始化（Initialization） 
    
        • @PostConstruct 标注方法
        • 实现 InitializingBean 接口的 afterPropertiesSet() 方法
        • 自定义初始化方法
            • XML 配置：<bean init-method=”init” ... /> 
            • Java 注解：@Bean(initMethod=”init”)
            • Java API：AbstractBeanDefinition#setInitMethodName(String) 
            
        • Bean 延迟初始化（Lazy Initialization） 
             • XML 配置：<bean lazy-init=”true” ... />
             • Java 注解：@Lazy(true)
             
##销毁 Spring Bean

    • Bean 销毁（Destroy） 
        • @PreDestroy 标注方法
        • 实现 DisposableBean 接口的 destroy() 方法
        • 自定义销毁方法
            • XML 配置：<bean destroy=”destroy” ... /> 
            • Java 注解：@Bean(destroy=”destroy”)
            • Java API：AbstractBeanDefinition#setDestroyMethodName(String)