# Hera-Base
- 所有实体类Id不用自增长策略了，太烦了，还是使用UUID吧
- 所有实体类的POJO，使用jpa作为ORM框架，具体sql查询在使用时直接添加。
- 需要了解jpa自定义sql语句的使用方法
- 注意经常写test，extends BaseTest以方便test配置
- 添加web，否则运行后就直接结束，web由@RestController等Controller部件
## 缓存
- 在service层添加缓存
- 开始因为@Cacheable不是redis的，一直没有缓存
- 2.0以上版本默认lettuce作为redis连接，在此统一使用Jedis连接，需要修改pom
### Redis主键策略

- 目前就暂时只用cacheable注解，将方法名和参数作为id，这样的缓存策略目前来说没有很大意义，只有在分布式高并发环境下 才能体现出效果，对增删改暂时不做缓存

- 在redisConfig配置主键生成策略
- 若缓存的是entity对象，对象需要集成序列化
- @Cacheable：标记在一个方法上，也可以标记在一个类上。主要是缓存标注对象的返回结果，标注在方法上缓存该方法的返回值，标注在类上，缓存该类所有的方法返回值。
参数： value缓存名，指定缓存所在的数据包、 key缓存键值、 condition满足缓存条件、unless否决缓存条件。sync：如果设置sync=true：a. 如果缓存中没有数据，多个线程同时访问这个方法，则只有一个方法会执行到方法，其它方法需要等待; b. 如果缓存中已经有数据，则多个线程可以同时从缓存中获取数据
- @CacheEvict：从缓存中移除相应数据，应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据。
- @CachePut：方法支持缓存功能。与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存。每次执行都会执行方法，无论缓存里是否有值，同时使用新的返回值的替换缓存中的值。这里不同于@Cacheable：@Cacheable如果缓存没有值，从则执行方法并缓存数据，如果缓存有值，则从缓存中获取值
- @CacheConfig: 类级别的注解：如果我们在此注解中定义cacheNames，则此类中的所有方法上 @Cacheable的cacheNames默认都是此值。当然@Cacheable也可以重定义cacheNames的值