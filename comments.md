### 完成度：
* 缺少查看已经分组的api

### 知识点：
__Details:__
- \- StudentController.java:14 推荐使用构造器注入
- \- StudentController.java:19 如果不是有自定义返回的需求，ResponseEntity一般可省略
- \- StudentController.java:32 了解下@ResponseStatus
- \- StudentService.java:13 如果StudentDao是作为持久层存在的，那么需要被注入，而非直接new

### 工程实践：
__Details:__

- \- StudentDao.java:35 这种自增方式线程不安全，了解下AtomicInteger
- \- StudentController.java:35 如果不沟通，前端不会知道这里需要"inputStudent"作为key，可读性太低
- \- StudentController.java:36 仅仅从代码的角度来讲， 类似"inputStudent"出现了多次的代码，需要抽取变量
- \- StudentService.java:19 长方法，需要抽取方法，进行重构
- \- StudentService.java:22 变量命名不表意，且太过随意
- \- StudentService.java:24 Magic number 6
- \- StudentService.java:38 调试代码，在正式提交前，需要被删除

### 综合：
* 如果使用Map来进行student数据的传输，何不进一步，将这个Map抽象成一个对象
* 尝试使用面向对象的思想进行一些重构

__Details:__

- \- 整体偏向面相过程编程

