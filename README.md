## 码匠社区

## 资料

[Spring 文档](https://spring.io/guides)

[Spring web 文档](https://spring.io/guides/gs/serving-web-content/)

[es中文社区](https://elasticsearch.cn/)

[BootStrap](https://v3.bootcss.com/components/#navbar)

[github OAuth](https://developer.github.com/apps/)

[okhttp](https://square.github.io/okhttp/)

[读懂UML](https://blog.csdn.net/bntX2jSQfEHy7/article/details/90088866)

[w3school](https://www.w3school.com.cn/sql/index.asp)

[SpringBoot Mybatis](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

[SpringBoot Reference Documents](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/html/index.html)

[flyway migrate](https://flywaydb.org/documentation/maven/migrate)

[lombok](https://projectlombok.org/)

[thymeleaf](https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html)


## 工具

git

[visual-paradigm](https://www.visual-paradigm.com/cn/)


## 命令

git status

git add .

git commit -m "xx"

git commit --amend --no-edit

git push

git pull 和  :x 进行merge



## 快捷键
ctrl+shift+f12 当前窗口最大化，返回上一个窗口

ctrl+shift+n 打开文件

ctrl+n 查找类

alt+1 打开左边的菜单

ctrl+p 提示

alt+insert generator功能

alt+enter 导包

ctrl+alt+v 快速创建一个变量

shift+enter 到下一行的行首

alt+1 从包中查找到当前文件

ctrl+alt+o 自动移除没有使用的包

shift+f6 重命名

ctrl+e 打开最近的文件

ctrl+w 选中区块

ctrl+d 拷贝一行

ctrl+shift+alt+? 保养maintenance registry

ctrl+alt+s 设置settings  




## 脚本

```
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `token` varchar(100) DEFAULT NULL COMMENT '令牌',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

```





## 遇到测错误
使用okhttp发送get请求，返回json响应对象回来的时候。

对response对象进行解析，response.body().string()获得json对象。

response.body().toString()是对象的地址。

然后使用fastjson将json字符串对象解析成我们的复杂对象。

使用flyway时，配置不正确。去官网查看文档，要填写url，并且要确定时区
baselineOnMigrate 也要配置为true【报错提示】

带有驼峰的属性不能对应到数据库中的列。使用mybatis的驼峰配置

使用thymeleaf的语法遍历集合，格式化日期。。。



```pom
<plugin>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-maven-plugin</artifactId>
    <version>6.0.7</version>
    <configuration>
        <url>jdbc:mysql:///community?serverTimezone=Asia/Shanghai</url>
        <user>root</user>
        <password>123456</password>
        <baselineOnMigrate>true</baselineOnMigrate>
    </configuration>
</plugin>
```

使用flyway时，应用启动不成功，找不到Caused by: java.lang.NoClassDefFoundError: org/flywaydb/core/api/configuration/FluentConfiguration
发现确实没有这个文件。原因是springboot2.x之后需要flyway5.x才行。项目中使用的时4.x。提升一下版本，修改一下配置。


圆图片img-round   白框图片img-thumbnail

自动化部署buildAllow auto-make to start even if developed application is currently running. Note that automatically started make may eventually delete some classes that are required by the application.




## 查的资料

从thymeleaf中取session https://blog.csdn.net/sun1021873926/article/details/61615219

连接h2数据库不成功，改为实用更加熟悉的mysql数据库。配置dataSource时，连接数据库报`需要设置TimeZone`，我们设置时区为上海的就行。
spring.datasource.url=jdbc:mysql:///community?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8


## 答疑

1. thymeleaf的回显。```<textarea class="form-control" id="description" name="description" th:value="${description}" placeholder="问题..." cols="30" rows="10"></textarea>```

有的可以使用 th:value 有的要是用th:text

2. fastjson的自动将_转为驼峰命名。【从前台过来的数据，】

3. 格式化日期









