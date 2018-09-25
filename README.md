# prometheusdemo1
SpringBoot 1.x 整合 Prometheus


# 配置文件
management.port=9999

management.security.enabled=true

security.user.name=admin

security.user.password=admin


server.port=8081

# prometheus 配置
  - job_name: 'springboot3'
 
  metrics_path: '/prometheus'
 
  basic_auth:
 
    username: admin
   
    password: admin
   
  static_configs:
 
    - targets: ["localhost:9999"]
   
