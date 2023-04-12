### 说明
- 修改容器settings.xml
  - 解决域名没有https问题 : http://nexus.soulworld.net/
  - 解决maven容器构建时,.m2目录为空的问题,暂时指定 docker-build命令的运行时主机:${user.home}/.m2