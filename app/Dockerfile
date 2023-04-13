FROM openjdk:17-jdk-alpine
COPY build/libs/demo-0.0.1-SNAPSHOT.jar DemoApplication.jar
COPY elastic-apm-agent-1.37.1.jar /apm-agent.jar
ENTRYPOINT ["java", "-javaagent:/apm-agent.jar", "-Delastic.apm.service_name=demo","-Delastic.apm.server_urls=http://apm:8200","-Delastic.apm.environment=production","-Delastic.apm.application_packages=com.fabiolnh.demo", "-jar","DemoApplication.jar"]