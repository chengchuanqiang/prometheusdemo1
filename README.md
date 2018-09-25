# prometheusdemo1
SpringBoot 1.x 整合 Prometheus

 # prometheus 配置
 - job_name: 'springboot3'
 metrics_path: '/prometheus'
 basic_auth:
   username: admin
   password: admin
 static_configs:
   - targets: ["localhost:8888"]
