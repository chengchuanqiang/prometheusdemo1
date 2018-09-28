# prometheusdemo1
SpringBoot 1.x 整合 Prometheus


# 配置文件
management.port=9999  
management.security.enabled=true  
security.user.name=admin  
security.user.password=admin  

server.port=8081

# prometheus 配置
\- job_name: 'springboot3'  
&emsp;&emsp;metrics_path: '/prometheus'     
&emsp;&emsp;basic_auth:     
&emsp;&emsp;&emsp;&emsp;username: admin     
&emsp;&emsp;&emsp;&emsp;password: admin     
&emsp;&emsp;static_configs:     
&emsp;&emsp;&emsp;&emsp;\- targets: ["localhost:9999"]
   
