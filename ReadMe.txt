Eureka Server   = http://localhost:8761/
Eureka Client   = 8762
Eureka Consumer = 8763
Zuul Proxy      = http://localhost:9999/sjd-eureka-client/whoami

To Start Each Server: -
    
    mvn spring-boot:run

To Start Additional EurekaServer: -

    mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=8760'


To Start Additional EurekaClient: -

    mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=8764'


REST operations
===============

https://github.com/Netflix/eureka/wiki/Eureka-REST-operations

To De-register an instance: -

curl -X DELETE http://localhost:8761/eureka/apps/SJD-EUREKA-CLIENT/192.168.1.106:sjd-eureka-client:8764

To Take an Instance out of service: -

curl -X PUT http://localhost:8761/eureka/apps/SJD-EUREKA-CLIENT/192.168.1.106:sjd-eureka-client:8764/status?value=OUT_OF_SERVICE

To Put an Instance Back into service: -

curl -X PUT http://localhost:8761/eureka/apps/SJD-EUREKA-CLIENT/192.168.1.106:sjd-eureka-client:8764/status?value=UP


.Net / Eureka Interop
=====================

https://github.com/SteeltoeOSS