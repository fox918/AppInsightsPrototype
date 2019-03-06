# Application Insights Prototype #

This is a small demo project to demonstrate a dependency
problem in Azure Application Insights using Spring Boot and
Azure Keyvault.

## Problem Description ##
When using the Spring Boot starters for Azure Keyvault and Azure Application Insights,
Azure Application insights is not able to provide Live Metrics and is not able
to upload the log messages as `traces` to Application Insights.

Custom events (in this prototype access to `/` and `/demo`) are still
visible in Application Insights.

The Keyvault seems to be working wether the Application Insights dependency
exists or not.

To reproduce, include both dependencies into your projects gradle file: 
```
compile('com.microsoft.azure:azure-keyvault-secrets-spring-boot-starter:2.1.3')

compile('com.microsoft.azure:applicationinsights-spring-boot-starter:1.1.2')
compile("com.microsoft.azure:applicationinsights-logging-logback:2.3.1")
```
