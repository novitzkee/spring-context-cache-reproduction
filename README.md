Repository containing error reproduction related to
problematic [DefaultCacheAwareContextLoaderDelegate](https://github.com/spring-projects/spring-framework/blob/main/spring-test/src/main/java/org/springframework/test/context/cache/DefaultCacheAwareContextLoaderDelegate.java)
behavior.

Script `reproduction.sh` can be run to reproduce the issue.

When the value of the `spring.test.context.cache.maxSize` property is changed, the number of failing tests varies, even
though they seem to be configured correctly.

Spring issue: [#35396](https://github.com/spring-projects/spring-framework/issues/35396) - effectively duplicate of [#21007](https://github.com/spring-projects/spring-framework/issues/21007)
