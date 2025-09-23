FROM eclipse-temurin:17
LABEL maintainer="leofigorelli@gmail.com"
WORKDIR /FinancialPlanningAi
COPY target/FinancialPlanningAi-0.0.1-SNAPSHOT.jar /FinancialPlanningAi/FinancialPlanningAi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "FinancialPlanningAi.jar"]