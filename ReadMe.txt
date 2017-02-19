Eureka Server   = http://localhost:8761/
Eureka Client   = 8762
Eureka Consumer = 8763
Zuul Proxy      = http://localhost:9999/sjd-eureka-client/whoami

To Start Each Server: -
    
    mvn spring-boot:run

To Start Additional EurekaClient: -

    mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=8764'