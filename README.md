# urlShort
将长链接转换成短链接
application.yml内容参考：

spring:
  datasource:
    url: jdbc:mysql://ip:8080/url_shorter
    username: username
    password: password
    driver-class-name: com.mysql.jdbc.Driver
  jpa:
    hibernate:
#     更新或者创建数据表结构
      ddl-auto: update
#   控制台显示SQL
    show-sql: true
