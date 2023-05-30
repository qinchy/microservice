# 微服务示例工程


* 整合nacos
* 整合sentinel
* 整合skywalking


* skywalking的jvm参数：
```shell
-javaagent:D:\Dev_Tools\apache-skywalking-apm-6.6.0\agent\skywalking-agent.jar=agent.service_name=micsoservice-provider4,collector.backend_service=192.168.43.1:11800
-Dskywalking.agent.service_name=micsoservice-provider4
-Dskywalking.collector.backend_service=192.168.43.1:11800
```