# Problem 1
  分支：p1-starts-from-here
  
主观题：
 @Component 已经可以支持声明一个 bean 了，为何还要再弄个 @Bean 出来？

1. @Bean比@Component的自定义性更强。可以实现一些Component实现不了的自定义加载类。
   @Component倾向于组件扫描和自动装配。如果要引入第三方库，且没有源代码，此时无法添加@Component。
   但@Bean会返回一个被spring认可的Bean。@Bean所注释的方法内部可以对这个第三方库的实例进行设置。
2. @Bean可以灵活的返回实现了同一个接口的不同类，可以通过判断状态变量，动态地返回不同的Bean。