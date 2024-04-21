<p align="center">
 <img src="https://img.shields.io/badge/Spring%20Boot-3.2.0-blue.svg" alt="Downloads">
 <img src="https://img.shields.io/badge/Vue-3.2-blue.svg" alt="Downloads">
 <img src="https://img.shields.io/badge/license-MIT-green" alt="Downloads" />
</p>


## 🐯 平台简介


### 系统功能

|     | 功能    | 描述                              |
|-----|-------|---------------------------------|
|     | 用户管理  | 用户是系统操作者，该功能主要完成系统用户配置          |
| ⭐️  | 在线用户  | 当前系统中活跃用户状态监控，支持手动踢下线           |
|     | 角色管理  | 角色菜单权限分配、设置角色按机构进行数据范围权限划分      |
|     | 菜单管理  | 配置系统菜单、操作权限、按钮权限标识等，本地缓存提供性能    |
|     | 字典管理  | 对系统中经常使用的一些较为固定的数据进行维护          |
| 🚀  | 操作日志  | 系统正常操作日志记录和查询，集成 Swagger 生成日志内容 |
| ⭐️  | 登录日志  | 系统登录日志记录查询，包含登录异常               |
| 🚀  | 错误码管理 | 系统所有错误码的管理，可在线修改错误提示，无需重启服务     |

## 🐨 技术栈


### 框架

| 框架                                                                                          | 说明               | 版本             | 学习指南                                                           |
|---------------------------------------------------------------------------------------------|------------------|----------------|----------------------------------------------------------------|
| [Spring Boot](https://spring.io/projects/spring-boot)                                       | 应用开发框架           | 3.2.0          | [文档](https://github.com/YunaiV/SpringBoot-Labs)                |
| [MySQL](https://www.mysql.com/cn/)                                                          | 数据库服务器           | 5.7 / 8.0+     |                                                                |
| [Druid](https://github.com/alibaba/druid)                                                   | JDBC 连接池、监控组件    | 1.2.20         | [文档](http://www.iocoder.cn/Spring-Boot/datasource-pool/?wuzhu) |
| [MyBatis Plus](https://mp.baomidou.com/)                                                    | MyBatis 增强工具包    | 3.5.4.1        | [文档](http://www.iocoder.cn/Spring-Boot/MyBatis/?wuzhu)         |
| [Dynamic Datasource](https://dynamic-datasource.com/)                                       | 动态数据源            | 4.2.0          | [文档](http://www.iocoder.cn/Spring-Boot/datasource-pool/?wuzhu) |
| [Redis](https://redis.io/)                                                                  | key-value 数据库    | 5.0 / 6.0 /7.0 |                                                                |
| [Redisson](https://github.com/redisson/redisson)                                            | Redis 客户端        | 3.25.0         | [文档](http://www.iocoder.cn/Spring-Boot/Redis/?wuzhu)           |
| [Spring MVC](https://github.com/spring-projects/spring-framework/tree/master/spring-webmvc) | MVC 框架           | 6.1.1          | [文档](http://www.iocoder.cn/SpringMVC/MVC/?wuzhu)               |
| [Spring Security](https://github.com/spring-projects/spring-security)                       | Spring 安全框架      | 6.2.0          | [文档](http://www.iocoder.cn/Spring-Boot/Spring-Security/?wuzhu) |
| [Hibernate Validator](https://github.com/hibernate/hibernate-validator)                     | 参数校验组件           | 8.0.1          | [文档](http://www.iocoder.cn/Spring-Boot/Validation/?wuzhu)      |
| [Flowable](https://github.com/flowable/flowable-engine)                                     | 工作流引擎            | 7.0.0          | [文档](https://doc.iocoder.cn/bpm/)                              |
| [Quartz](https://github.com/quartz-scheduler)                                               | 任务调度组件           | 2.3.2          | [文档](http://www.iocoder.cn/Spring-Boot/Job/?wuzhu)             |
| [Springdoc](https://springdoc.org/)                                                         | Swagger 文档       | 2.2.0          | [文档](http://www.iocoder.cn/Spring-Boot/Swagger/?wuzhu)         |
| [SkyWalking](https://skywalking.apache.org/)                                                | 分布式应用追踪系统        | 9.0.0          | [文档](http://www.iocoder.cn/Spring-Boot/SkyWalking/?wuzhu)      |
| [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin)                       | Spring Boot 监控平台 | 3.1.8          | [文档](http://www.iocoder.cn/Spring-Boot/Admin/?wuzhu)           |
| [Jackson](https://github.com/FasterXML/jackson)                                             | JSON 工具库         | 2.15.3         |                                                                |
| [MapStruct](https://mapstruct.org/)                                                         | Java Bean 转换     | 1.5.5.Final    | [文档](http://www.iocoder.cn/Spring-Boot/MapStruct/?wuzhu)       |
| [Lombok](https://projectlombok.org/)                                                        | 消除冗长的 Java 代码    | 1.18.30        | [文档](http://www.iocoder.cn/Spring-Boot/Lombok/?wuzhu)          |
| [JUnit](https://junit.org/junit5/)                                                          | Java 单元测试框架      | 5.10.1         | -                                                              |
| [Mockito](https://github.com/mockito/mockito)                                               | Java Mock 框架     | 5.7.0          | -                                                              |
