Sample project to simulate https://github.com/spring-projects-experimental/spring-native/issues/1522 

To build: `mvn clean package -P native-image`

Fails with:
```
[2022-03-07 10:30:59.140] - ???? INFO [main] --- org.springframework.aot.build.ContextBootstrapContributor: Detected application class: xxx.App
[2022-03-07 10:30:59.174] - ???? INFO [main] --- org.springframework.aot.build.ContextBootstrapContributor: Processing application context
[2022-03-07 10:31:06.075] - ???? INFO [main] --- org.springframework.aot.build.ContextBootstrapContributor: Processed 37 bean definitions in 6897ms
[2022-03-07 10:31:06.353] - ???? INFO [main] --- org.springframework.nativex.support.SpringAnalyzer: Spring Native operating mode: native
[2022-03-07 10:31:30.858] - ???? INFO [main] --- org.springframework.aop.framework.ProxyGenerator: Generating class file bytes for a proxy named xxx.ServerConfiguration$$SpringProxy$e81fb7ad
java.lang.IllegalStateException: Cannot create a build time proxy for a final class: xxx.ServerConfiguration
        at org.springframework.aop.framework.ProxyGenerator.getProxyBytes(ProxyGenerator.java:73)
        at org.springframework.aot.nativex.ConfigurationContributor.generateBuildTimeClassProxy(ConfigurationContributor.java:193)
        at org.springframework.aot.nativex.ConfigurationContributor.generateBuildTimeClassProxies(ConfigurationContributor.java:170)
        at org.springframework.aot.nativex.ConfigurationContributor.processBuildTimeClassProxyRequests(ConfigurationContributor.java:142)
        at org.springframework.aot.nativex.ConfigurationContributor.contribute(ConfigurationContributor.java:74)
        at org.springframework.aot.build.BootstrapCodeGenerator.generate(BootstrapCodeGenerator.java:91)
        at org.springframework.aot.build.BootstrapCodeGenerator.generate(BootstrapCodeGenerator.java:71)
        at org.springframework.aot.build.GenerateBootstrapCommand.call(GenerateBootstrapCommand.java:107)
        at org.springframework.aot.build.GenerateBootstrapCommand.call(GenerateBootstrapCommand.java:42)
        at picocli.CommandLine.executeUserObject(CommandLine.java:1953)
        at picocli.CommandLine.access$1300(CommandLine.java:145)
        at picocli.CommandLine$RunLast.executeUserObjectOfLastSubcommandWithSameParent(CommandLine.java:2352)
        at picocli.CommandLine$RunLast.handle(CommandLine.java:2346)
        at picocli.CommandLine$RunLast.handle(CommandLine.java:2311)
        at picocli.CommandLine$AbstractParseResultHandler.execute(CommandLine.java:2179)
        at picocli.CommandLine.execute(CommandLine.java:2078)
        at org.springframework.aot.build.GenerateBootstrapCommand.main(GenerateBootstrapCommand.java:112)
java.lang.IllegalStateException: Problem creating proxy with configuration: org.springframework.aop.framework.ProxyConfiguration@e81fb7ad
        at org.springframework.aop.framework.ProxyGenerator.getProxyBytes(ProxyGenerator.java:98)
        at org.springframework.aot.nativex.ConfigurationContributor.generateBuildTimeClassProxy(ConfigurationContributor.java:193)
        at org.springframework.aot.nativex.ConfigurationContributor.generateBuildTimeClassProxies(ConfigurationContributor.java:170)
        at org.springframework.aot.nativex.ConfigurationContributor.processBuildTimeClassProxyRequests(ConfigurationContributor.java:142)
        at org.springframework.aot.nativex.ConfigurationContributor.contribute(ConfigurationContributor.java:74)
        at org.springframework.aot.build.BootstrapCodeGenerator.generate(BootstrapCodeGenerator.java:91)
        at org.springframework.aot.build.BootstrapCodeGenerator.generate(BootstrapCodeGenerator.java:71)
        at org.springframework.aot.build.GenerateBootstrapCommand.call(GenerateBootstrapCommand.java:107)
        at org.springframework.aot.build.GenerateBootstrapCommand.call(GenerateBootstrapCommand.java:42)
        at picocli.CommandLine.executeUserObject(CommandLine.java:1953)
        at picocli.CommandLine.access$1300(CommandLine.java:145)
        at picocli.CommandLine$RunLast.executeUserObjectOfLastSubcommandWithSameParent(CommandLine.java:2352)
        at picocli.CommandLine$RunLast.handle(CommandLine.java:2346)
        at picocli.CommandLine$RunLast.handle(CommandLine.java:2311)
        at picocli.CommandLine$AbstractParseResultHandler.execute(CommandLine.java:2179)
        at picocli.CommandLine.execute(CommandLine.java:2078)
        at org.springframework.aot.build.GenerateBootstrapCommand.main(GenerateBootstrapCommand.java:112)
Caused by: java.lang.IllegalStateException: Cannot create a build time proxy for a final class: xxx.ServerConfiguration
        at org.springframework.aop.framework.ProxyGenerator.getProxyBytes(ProxyGenerator.java:73)
        ... 16 more
```
