# Lucky-Boy

## 开发环境与技术栈

+ Windows
+ Maven
+ Lombok
+ Spring、SpringMVC、SpringBoot
+ MySQL、Mybatis、Druid

## 项目功能

主要业务：为公司活动（如年会等）提供在线抽奖功能，满足奖品、抽奖人员的管理，及抽奖活动的需要。

+ 用户注册、登录、注销
+ 会话管理、统一数据封装、异常拦截
+ 抽奖设置：奖品管理，抽奖人员管理
+ 人员抽奖、重置抽奖

## 数据库设计

### 创建数据库及表

```mysql
drop database if exists lucky_draw;
create database lucky_draw character set utf8mb4;

use lucky_draw;

drop table if exists user;
create table user(
    id int primary key auto_increment,
    username varchar(20) not null unique comment '用户账号',
    password varchar(20) not null comment '密码',
    nickname varchar(20) comment '用户昵称',
    email varchar(50) comment '邮箱',
    age int comment '年龄',
    head varchar(255) comment '头像url',
    create_time timestamp default NOW() comment '创建时间'
) comment '用户表';

drop table if exists setting;
create table setting(
    id int primary key auto_increment,
    user_id int not null comment '用户id',
    batch_number int not null comment '每次抽奖人数',
    create_time timestamp default NOW() comment '创建时间',
    foreign key (user_id) references user(id)
) comment '抽奖设置';

drop table if exists award;
create table award(
    id int primary key auto_increment,
    name varchar(20) not null comment '奖项名称',
    count int not null comment '奖项人数',
    award varchar(20) not null comment '奖品',
    setting_id int not null comment '抽奖设置id',
    create_time timestamp default NOW() comment '创建时间',
    foreign key (setting_id) references setting(id)
) comment '奖项';

drop table if exists member;
create table member(
    id int primary key auto_increment,
    name varchar(20) not null comment '姓名',
    no varchar(20) not null comment '工号',
    user_id int not null comment '用户id',
    create_time timestamp default NOW() comment '创建时间',
    foreign key (user_id) references user(id)
) comment '抽奖人员';

drop table if exists record;
create table record(
    id int primary key auto_increment,
    member_id int not null,
    award_id int not null,
    create_time timestamp default NOW() comment '创建时间',
    foreign key (member_id) references member(id),
    foreign key (award_id) references award(id)
) comment '学生表';



insert into user(id, username, password, nickname, email, age, head) values (1, 'listen', '123', 'yaya', '1111@163.com', 18, 'img/test-head.jpg');

## 数据字典：学生毕业年份
insert into setting(id, user_id, batch_number) values (1, 1, 8);

insert into award(name, count, award, setting_id) values ('特靠谱欢乐奖', 1, '深圳湾一号', 1);
insert into award(name, count, award, setting_id) values ('特靠谱娱乐奖', 5, 'BMW X5', 1);
insert into award(name, count, award, setting_id) values ('特靠谱励志奖', 20, '办公室一日游', 1);

## 数据字典：学生专业
insert into member(name, no, user_id) values ('李寻欢', '水果刀', 1);
insert into member(name, no, user_id) values ('郭靖', '降猪十八掌', 1);
insert into member(name, no, user_id) values ('韦小宝', '抓?龙爪手', 1);
insert into member(name, no, user_id) values ('风清扬', '孤独九贱', 1);
insert into member(name, no, user_id) values ('哪吒', '喷气式电单车', 1);
insert into member(name, no, user_id) values ('渠昊空', 'no2', 1);
insert into member(name, no, user_id) values ('闵觅珍', 'no2', 1);
insert into member(name, no, user_id) values ('慈新之', 'no3', 1);
insert into member(name, no, user_id) values ('户柔绚', 'no4', 1);
insert into member(name, no, user_id) values ('柯雅容', 'no5', 1);
insert into member(name, no, user_id) values ('邰虹彩', 'no6', 1);
insert into member(name, no, user_id) values ('延易蓉', 'no7', 1);
insert into member(name, no, user_id) values ('吉娇然', 'no8', 1);
insert into member(name, no, user_id) values ('百里惜蕊', 'no9', 1);
insert into member(name, no, user_id) values ('云寻双', 'no10', 1);
insert into member(name, no, user_id) values ('衅嘉颖', 'no11', 1);
insert into member(name, no, user_id) values ('银以晴', 'no12', 1);
insert into member(name, no, user_id) values ('保颐和', 'no13', 1);
insert into member(name, no, user_id) values ('饶燕婉', 'no14', 1);
insert into member(name, no, user_id) values ('单阳平', 'no15', 1);
insert into member(name, no, user_id) values ('墨碧春', 'no16', 1);
insert into member(name, no, user_id) values ('侨诗柳', 'no17', 1);
insert into member(name, no, user_id) values ('羿灵珊', 'no18', 1);
insert into member(name, no, user_id) values ('甘凌波', 'no19', 1);
insert into member(name, no, user_id) values ('希忻然', 'no20', 1);
insert into member(name, no, user_id) values ('虎晴画', 'no21', 1);
insert into member(name, no, user_id) values ('闪雅洁', 'no22', 1);
insert into member(name, no, user_id) values ('风易云', 'no23', 1);
insert into member(name, no, user_id) values ('泷运盛', 'no24', 1);
insert into member(name, no, user_id) values ('沐长菁', 'no25', 1);
insert into member(name, no, user_id) values ('栗芃芃', 'no26', 1);
insert into member(name, no, user_id) values ('义涵蕾', 'no27', 1);
insert into member(name, no, user_id) values ('泥清妙', 'no28', 1);
insert into member(name, no, user_id) values ('亓官清宁', 'no29', 1);
insert into member(name, no, user_id) values ('侯曜曦', 'no30', 1);
insert into member(name, no, user_id) values ('齐淑雅', 'no31', 1);
insert into member(name, no, user_id) values ('邸平松', 'no32', 1);
insert into member(name, no, user_id) values ('泉千易', 'no33', 1);
insert into member(name, no, user_id) values ('段彩静', 'no34', 1);
insert into member(name, no, user_id) values ('伦晓凡', 'no35', 1);
insert into member(name, no, user_id) values ('余莎莎', 'no36', 1);
insert into member(name, no, user_id) values ('贵念梦', 'no37', 1);
insert into member(name, no, user_id) values ('接骊文', 'no38', 1);
insert into member(name, no, user_id) values ('龚芷蝶', 'no39', 1);
insert into member(name, no, user_id) values ('丙冷霜', 'no40', 1);
insert into member(name, no, user_id) values ('卫诗蕊', 'no41', 1);
insert into member(name, no, user_id) values ('濯雅懿', 'no42', 1);
insert into member(name, no, user_id) values ('蓝亦竹', 'no43', 1);
insert into member(name, no, user_id) values ('雷书君', 'no44', 1);
insert into member(name, no, user_id) values ('刚孤风', 'no45', 1);
insert into member(name, no, user_id) values ('帛晨蓓', 'no46', 1);
insert into member(name, no, user_id) values ('雀凝梦', 'no47', 1);
insert into member(name, no, user_id) values ('於良工', 'no48', 1);
insert into member(name, no, user_id) values ('从翠阳', 'no49', 1);
insert into member(name, no, user_id) values ('宫咸英', 'no50', 1);
insert into member(name, no, user_id) values ('项英光', 'no51', 1);
insert into member(name, no, user_id) values ('胥友菱', 'no52', 1);
insert into member(name, no, user_id) values ('慎初翠', 'no53', 1);
insert into member(name, no, user_id) values ('锺映寒', 'no54', 1);
insert into member(name, no, user_id) values ('貊飞翔', 'no55', 1);
insert into member(name, no, user_id) values ('葛秀妮', 'no56', 1);
insert into member(name, no, user_id) values ('劳令梅', 'no57', 1);
insert into member(name, no, user_id) values ('昝欣怿', 'no58', 1);
insert into member(name, no, user_id) values ('党忆柏', 'no59', 1);
insert into member(name, no, user_id) values ('福月华', 'no60', 1);
insert into member(name, no, user_id) values ('睢巧春', 'no61', 1);
insert into member(name, no, user_id) values ('修听枫', 'no62', 1);
insert into member(name, no, user_id) values ('孔梦竹', 'no63', 1);
insert into member(name, no, user_id) values ('子车悦欣', 'no64', 1);
insert into member(name, no, user_id) values ('赵飞宇', 'no65', 1);
insert into member(name, no, user_id) values ('宁天睿', 'no66', 1);
insert into member(name, no, user_id) values ('申文心', 'no67', 1);
insert into member(name, no, user_id) values ('冀轩昂', 'no68', 1);
insert into member(name, no, user_id) values ('邬代灵', 'no69', 1);
insert into member(name, no, user_id) values ('佟嘉德', 'no70', 1);
insert into member(name, no, user_id) values ('溥绿兰', 'no71', 1);
insert into member(name, no, user_id) values ('改昊昊', 'no72', 1);
insert into member(name, no, user_id) values ('捷梦影', 'no73', 1);
insert into member(name, no, user_id) values ('孛书语', 'no74', 1);
insert into member(name, no, user_id) values ('粟芮优', 'no75', 1);
insert into member(name, no, user_id) values ('东门虹英', 'no76', 1);
insert into member(name, no, user_id) values ('漆梓玥', 'no77', 1);
insert into member(name, no, user_id) values ('尔幻玉', 'no78', 1);
insert into member(name, no, user_id) values ('丁秋玉', 'no79', 1);
insert into member(name, no, user_id) values ('平晨旭', 'no80', 1);
insert into member(name, no, user_id) values ('遇沙羽', 'no81', 1);
insert into member(name, no, user_id) values ('国琳溪', 'no82', 1);
insert into member(name, no, user_id) values ('仪谷枫', 'no83', 1);
insert into member(name, no, user_id) values ('钭尔琴', 'no84', 1);
insert into member(name, no, user_id) values ('澄慧丽', 'no85', 1);
insert into member(name, no, user_id) values ('佼清秋', 'no86', 1);
insert into member(name, no, user_id) values ('缪荌荌', 'no87', 1);
insert into member(name, no, user_id) values ('闻人幼丝', 'no88', 1);
insert into member(name, no, user_id) values ('绍美曼', 'no89', 1);
insert into member(name, no, user_id) values ('回访波', 'no90', 1);

```
## 前后端接口

要实现功能，需要先明确前后端约定好的接口。

需要说明的是，接口的定义一般是前后端约定好的，所以也和前端代码息息相关，前端需要什么数据，需要什么格式的数据，也会在接口中体现。

接口主要体现在

+ 请求需要的信息：请求方法，请求路径，请求数据
+ 响应数据

### 用户登录

请求

```
POST api/user/login
Content-Type: application/json

{username: "bit", password: "123"}
```

响应

```json
{
  "success" : true
}
```

### 用户注册

请求

```
POST api/user/register
Content-Type: multipart/form-data; boundary=----WebKitFormBoundarypOUwkGIMUyL0aOZT

username: haha
password: 111
nickname: 牛牛牛
email: 666@163.com
age: 66
headFile: (binary)
```

注意：以上请求数据是解析过的，http原生发送的数据还包含其他很多内容，比较多，可以动手抓包看看。其中boundary后边的是随机生成的，请求数据中会使用该信息。

响应

```json
{
  "success" : true
}
```

### 查询抽奖设置

请求

```
GET api/setting/query
```

响应

```json
{
  "success" : true,
  "data" : {
    "id" : 1,
    "userId" : 1,
    "batchNumber" : 8,
    "createTime" : "2020-08-14 08:16:31",
    "user" : {
      "id" : 1,
      "username" : "bit",
      "password" : "123",
      "nickname" : "小比特",
      "email" : "1111@163.com",
      "age" : 18,
      "head" : "img/test-head.jpg",
      "createTime" : "2020-08-14 08:16:31",
      "settingId" : 1
    },
    "awards" : [ {
      "id" : 1,
      "name" : "特靠谱欢乐奖",
      "count" : 1,
      "award" : "深圳湾一号",
      "settingId" : 1,
      "createTime" : "2020-08-14 08:16:31",
      "luckyMemberIds" : [ 5 ]
    }, {
      "id" : 2,
      "name" : "特靠谱娱乐奖",
      "count" : 5,
      "award" : "BMW X5",
      "settingId" : 1,
      "createTime" : "2020-08-14 08:16:31",
      "luckyMemberIds" : [ 56, 40, 32, 65, 81 ]
    }, {
      "id" : 3,
      "name" : "特靠谱励志奖",
      "count" : 20,
      "award" : "办公室一日游",
      "settingId" : 1,
      "createTime" : "2020-08-14 08:16:31",
      "luckyMemberIds" : [ 48, 68, 43, 73, 13, 83, 63, 25 ]
    } ],
    "members" : [ {
      "id" : 1,
      "name" : "李寻欢",
      "no" : "水果刀",
      "userId" : 1,
      "createTime" : "2020-08-14 08:16:31"
    }, {
      "id" : 2,
      "name" : "郭靖",
      "no" : "降猪十八掌",
      "userId" : 1,
      "createTime" : "2020-08-14 08:16:31"
    }, {
      "id" : 3,
      "name" : "韦小宝",
      "no" : "抓?龙爪手",
      "userId" : 1,
      "createTime" : "2020-08-14 08:16:31"
    } ]
  }
}
```

### 修改抽奖人数

请求

```
GET api/setting/update?batchNumber=5
```

接口对应抽奖设置页面中，点每次抽奖人数下拉菜单切换时修改

响应

```json
{
  "success" : true
}
```

### 新增奖项

请求

```
POST api/award/add
Content-Type: application/json

{name: "牛哄哄", count: 3, award: "华为手机"}
```

响应

```json
{
  "success" : true
}
```

### 修改奖项

请求
```
POST api/award/update
Content-Type: application/json

{name: "牛哄哄", count: 3, award: "小米手机", id: 4}
```

响应
```json
{
  "success" : true
}
```

### 删除奖项

请求

```
GET api/award/delete/4
```

最后的数字4，对应奖项的id

响应

```json
{
  "success" : true
}
```

### 新增抽奖人员

请求

```
POST api/member/add
Content-Type: application/json

{name: "羞羞的粉拳", no: "007"}
```

响应

```json
{
  "success" : true
}
```

### 修改抽奖人员

请求

```
POST api/member/update
Content-Type: application/json

{name: "泰山", no: "000", id: 96}
```

响应

```json
{
  "success" : true
}
```

### 删除抽奖人员

请求

```
GET api/member/delete/97
```

注意最后的数字为抽奖人员的id

响应

```json
{
  "success" : true
}
```

### 抽奖

请求

```
POST api/record/add/3
Content-Type: application/json

[92, 22, 43, 76]
```

以上路径中最后的数字代表奖项id，请求数据为抽奖人员id组成的数组

响应

```json
{
  "success" : true
}
```

### 删除当前奖项某个获奖人员

请求

```
GET api/record/delete/member?id=22
```

根据人员id删除对应的获奖记录

响应

```json
{
  "success" : true
}
```

### 删除当前奖项已获奖人员

请求

```
GET api/record/delete/award?id=3
```

根据奖项id删除对应所有获奖人员记录

响应

```json
{
  "success" : true
}
```

## 开发环境准备

### 配置项目pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.1</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.luckyBoy</groupId>
    <artifactId>demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>demo</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.4</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.21</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- https://mvnrepository.com/artifact/log4j/log4j -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <dependency>
            <groupId>javax.validation</groupId>
            <artifactId>validation-api</artifactId>
        </dependency>

    </dependencies>

    <build>
        <finalName>lucky-boy</finalName>
        <plugins>
            <!-- SpringBoot的maven打包插件 -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```

### 准备Springboot配置文件

```properties
spring:
  datasource:
    username: root
    password: listen
    #?serverTimezone=UTC解决时区的报错
    url: jdbc:mysql://localhost:3306/lucky_boy?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    #Spring Boot 默认是不注入这些属性值的，需要自己绑定
    #druid 数据源专有配置
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，stat:监控统计、log4j：日志记录、wall：防御sql注入
    #如果允许时报错  java.lang.ClassNotFoundException: org.apache.log4j.Priority
    #则导入 log4j 依赖即可，Maven 地址：https://mvnrepository.com/artifact/log4j/log4j
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
    # JSON数据设置
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
    default-property-inclusion: non_null
    # MVC配置
  mvc:
    format:
      date: yyyy-MM-dd HH:mm:ss
    throw-exception-if-no-handler-found: true

mybatis:
  type-aliases-package: com.luckyBoy.model
  mapper-locations: classpath:mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true


server:
  port: 8081
  servlet:
    context-path: /lucky-Boy
```

### 准备SpringBoot启动类

```java
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
```



### 准备前端资源

### 准备Mybatis代码生成工具所需资源

## 代码设计

### 设计数据库实体类

### 设计http请求基类

### 设计统一响应类

主要为返回数据的统一字段设计

```java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseResult {

    private boolean success;
    private String code;
    private String message;
    private Object data;

    private ResponseResult(){}

    public static ResponseResult ok(Object data){
        ResponseResult result = new ResponseResult();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static ResponseResult error(){
        return error("ERR000", "未知错误");
    }

    public static ResponseResult error(String code, String message){
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
```

### 设计自定义异常类型

主要针对不同的场景，需要抛异常来处理时，能定位业务含义

主要分为

1. 客户端请求错误时的异常：需要给定错误码，方便前端提示用户，如用户名存在不允许注册（只简单实现，不考虑具体字段的报错）

2. 业务发生错误时的异常：需要给定错误码，方便后端定位问题，一般如程序上的业务错误都可以抛（BUG）

3. 系统发生错误时的异常：需要给定错误码，方便后端定位问题，程序出错，如数据库连接获取失败都可以抛（一般是系统发生错误，如网络断了，数据库挂了等等）


先定义异常的基类：抛异常时，有时候是自己抛，有时候是捕获到异常，再往外抛，所以提供两个构造方法

```java
@Getter
@Setter
public class BaseException extends RuntimeException {

    protected String code;

    public BaseException(String code, String message) {
        this(code, message, null);
    }

    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
```

再完成异常的子类：提供不同的错误码前缀，以便于前端提示时，知道是哪的问题

```java
public class BusinessException extends BaseException {

    public BusinessException(String code) {
        this(code, null);
    }

    public BusinessException(String code, String message) {
        this(code, message, null);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super("BUS" + code, message, cause);
    }
}
```

```java
public class ClientException extends BaseException {

    public ClientException(String code) {
        this(code, null);
    }

    public ClientException(String code, String message) {
        this(code, message, null);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLI" + code, message, cause);
    }
}
```

```java
public class SystemException extends BaseException {

    public SystemException(String code) {
        this(code, null);
    }

    public SystemException(String code, String message) {
        this(code, message, null);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("SYS" + code, message, cause);
    }
}
```

### 设计Controller中抛异常时的拦截器

这里不光是Controller抛异常，只要Controller代码执行，调用其他方法产生的异常，都会退出Controller方法，即HTTP请求方法结束，由拦截器统一处理。

```java
@Slf4j
@ControllerAdvice
public class ExceptionAdvisor {

    /**
     * 请求数据错误：包括类型转换错误，校验失败
     * @param e
     */
    @ExceptionHandler({
            BindException.class//使用@Valid 验证路径中请求实体校验失败后抛出的异常
            , ConstraintViolationException.class//处理请求参数格式错误 @RequestParam上validate失败后抛出的异常
            , MethodArgumentNotValidException.class//处理请求参数格式错误 @RequestBody上validate失败后抛出的异常
            , MethodArgumentTypeMismatchException.class//请求参数类型转换错误
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleMethodArgumentTypeMismatchException(Throwable e){
        log.debug("================================");
        log.debug("Controller方法参数类型转换错误", e);
    }

    @ExceptionHandler({
            MethodNotAllowedException.class
            , HttpRequestMethodNotSupportedException.class
    })
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public void handleMethodNotAllowedException(Throwable e){
        log.debug("================================");
        log.debug("Controller提供的http方法不支持", e);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNoHandlerFoundException(Throwable e){
        log.debug("================================");
        log.debug("找不到http请求处理器", e);
    }

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleBaseException(BaseException e){
        log.debug("================================");
        log.debug("自定义异常", e);
        return ResponseResult.error(e.getCode(), e.getMessage(), e);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(Throwable e){
        log.error("================================");
        log.error("未知异常："+e.getClass().getName()+"，请联系管理员", e);
        return ResponseResult.error(e);
    }
}
```

### 设计会话管理的拦截器及统一数据响应配置

```java
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        //登录校验
        if(session != null && session.getAttribute("user") != null){
            return true;
        }
        response.setStatus(401);
        return false;
    }
}
```

设计Web统一处理的配置

1. 会话管理的拦截器要引入配置：只拦截后端服务路径，并排除登录、注册、注销接口
2. 后端服务器路径都有/api的前缀，可以加上统一的路径映射
3. 统一的响应数据格式封装：这里不使用`@ControllerAdvice`和`ResponseBodyAdvice`进行拦截，原因是，返回值为null，会出现无法统一包装，响应体为空

```java
import frank.config.interceptor.LoginInterceptor;
import frank.config.web.RequestResponseBodyMethodProcessorWrapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SysConfig implements WebMvcConfigurer, InitializingBean{

    @Resource
    private RequestMappingHandlerAdapter adapter;

    @Override
    public void afterPropertiesSet() {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList(returnValueHandlers);
        for(int i=0; i<handlers.size(); i++){
            HandlerMethodReturnValueHandler handler = handlers.get(i);
            if(handler instanceof RequestResponseBodyMethodProcessor){
                handlers.set(i, new RequestResponseBodyMethodProcessorWrapper(handler));
            }
        }
        adapter.setReturnValueHandlers(handlers);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/user/register")
                .excludePathPatterns("/api/user/logout")
        ;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("api", c -> true);
    }
}
```

提供统一响应体封装处理类：

```java
import frank.base.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class RequestResponseBodyMethodProcessorWrapper implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler delegate;

    public RequestResponseBodyMethodProcessorWrapper(HandlerMethodReturnValueHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return delegate.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        if(!(returnValue instanceof ResponseResult)){
            returnValue = ResponseResult.ok(returnValue);
        }
        delegate.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}
```

### 设计Mybatis中Mapper的基类

使用Mybatis的接口方法，所有接口方法都是类似，只是传入参数和返回值不同，可以考虑设计统一的基类，以泛型的方式定义出不同的参数类型、返回类型

```java
public interface BaseMapper<T extends BaseEntity>{

    T selectByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    int deleteByPrimaryKey(Integer id);

    T selectOne(T record);

    List<T> selectAll();

    List<T> selectByCondition(T record);

    int deleteByIds(List<Integer> ids);
}
```

## POJO对象

### User

```java
package com.luckyBoy.model;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * user的POJO对象
 * User: Listen-Y.
 * Date: 2021-01-02
 * Time: 12:24
 */
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;


@Getter
@Setter
@ToString
public class User{

    private Integer id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像url
     */
    private String head;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 抽奖环境ID
     */
    private Integer settingId;
}
```

### Settng

```java
package com.luckyBoy.service;

import com.luckyBoy.exception.BusinessException;
import com.luckyBoy.model.Award;
import com.luckyBoy.model.Member;
import com.luckyBoy.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luckyBoy.mapper.SettingMapper;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 17:13
 */
@Service
public class SettingService {

    @Autowired
    private SettingMapper settingMapper;

    @Autowired
    private AwardService awardService;

    @Autowired
    private MemberService memberService;

    public Setting query(Integer id) {

        //在注册用户时就会创建一个setting 如果此时找不到就说明业务有问题
        Setting query = new Setting();
        query.setUserId(id);
        Setting setting = settingMapper.selectOne(query);
        if (setting == null) {
            throw new BusinessException("SET001", "用户设置信息错误");
        }
        //查询获奖列表设置到setting中
        Award award = new Award();
        award.setSettingId(setting.getId());
        List<Award> awards = awardService.query(award);
        setting.setAwards(awards);
        //查询用户设置的人员列表
        Member member = new Member();
        member.setUserId(id);
        List<Member> members = memberService.query(member);
        setting.setMembers(members);
        return setting;
    }


    //修改抽奖人数
    //Spring事务设置：默认的传播方式为Required，当前没有事务，就创建，有就加入
    @Transactional
    public void update(Integer id, Integer batchNumber) {
        int num = settingMapper.updateByUserId(id, batchNumber);
    }

    @Transactional
    public void add(Setting setting) {
        settingMapper.insertSelective(setting);
    }
}
```

### Award

```java
package com.luckyBoy.service;

import com.luckyBoy.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luckyBoy.mapper.AwardMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 17:11
 */
@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    public List<Award> query(Award award) {

        return awardMapper.query(award);

    }

    public void add(Award award) {
        awardMapper.insert(award);
    }

    public void update(Award award) {
        awardMapper.updateByPrimaryKeySelective(award);
    }

    public void delete(Integer id) {
        awardMapper.deleteByPrimaryKey(id);
    }
}
```

### Member

```java
package com.luckyBoy.service;

import com.luckyBoy.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luckyBoy.mapper.MemberMapper;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 17:12
 */
@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> query(Member member) {

        return memberMapper.selectByCondition(member);

    }

    //添加事务 以防出现数据错误
    @Transactional
    public void add(Member member) {
        memberMapper.insertSelective(member);
    }

    @Transactional
    public void update(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }

    @Transactional
    public void delete(Integer id) {
        memberMapper.deleteByPrimaryKey(id);
    }
}
```

### Record

```java
package com.luckyBoy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luckyBoy.mapper.RecordMapper;
import com.luckyBoy.model.Record;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 17:13
 */
@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    public void add(Integer awardId, List<Integer> memberIds) {
        recordMapper.batchAdd(awardId, memberIds);
    }

    @Transactional
    public void deleteByMemberId(Integer id) {
        Record record = new Record();
        record.setMemberId(id);
        recordMapper.deleteByCondition(record);
    }

    public void deleteByAwardId(Integer id) {
        Record record = new Record();
        record.setAwardId(id);
        recordMapper.deleteByCondition(record);
    }

    public void deleteBySettingId(Integer settingId) {
        recordMapper.deleteBySettingId(settingId);
    }
}
```

