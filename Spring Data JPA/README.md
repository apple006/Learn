# Spring Data JPA
## 人生苦短，我用 SDJ！
[Spring Data JPA](http://projects.spring.io/spring-data-jpa/)（SDJ）在我看来，相比于 [MyBatis](http://www.mybatis.org/mybatis-3/zh/) 和 [Hibernate](http://hibernate.org/) 最大的好处就在于，它太方便了！如果你的业务逻辑并不需要控制细腻度很高的情况下（SDJ 在我看来其实控制粒度也不低！），我强烈建议从 Hibernate 或 Mybatis 迁移至 SDJ！我只能说 [Spring](https://spring.io/) 出的东西个个都是极品，另外安利一个给我一样感觉的公司（Spring 是 [Pivotal](https://pivotal.io/) 公司的项目）——大名鼎鼎的 [JetBrains](https://www.jetbrains.com/) ，其代表作 [IntelliJ IDEA](https://www.jetbrains.com/idea/) 被公认为是最好的 [Java](https://www.oracle.com/java/index.html) IDE！

严格意义上来说，SDJ 是“站在巨人的肩膀上”—— Hibernate 和 [JPA](http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html)。Hibernate 是一种 ORM （Object Relational Mapping ——对象关系映射）框架，通俗点来说就是将数据库和 Java 对象进行相互映射，这样一来就可以通过操作 Java 对象来操作数据库；JPA 是一种协议，它提供了一种用于对象关系映射的 POJO（Plain Old Java Object ——普通 Java 对象）持久性模型。而 Hibernate 本身也是基于 JPA 的实现。有点类似于实现类（Hibernate）和接口（JPA）的关系。而 SDJ 是在两者的肩膀上更近一步，提供了更加方便的操作。

顺带一说，MyBatis 与两者不同，它不基于 JPA 协议，而是直接通过操作 SQL 语句来操作数据库。控制细腻度在我看来是最高的！因此，如果您需要更加强大的控制，建议您使用 MyBatis。
## 是时候从 Eclipse + Maven 迁移了！
全文的知识来源都是项目的 `GA RELEASE` 官方文档，文末我会提供对应的参考链接，并尽可能地根据 `GA RELEASE` 版本进行更新。开发环境是 [IntelliJ IDEA](https://www.jetbrains.com/idea/) & [Gradle](https://gradle.org/) & [Spring Boot](http://projects.spring.io/spring-boot/)，如果您对其中任何一项不熟悉，别慌，我只会以平台无关的代码进行说明，当然我强烈建议您去了解一下这些对编程人员友好开发的工具，今后我也会写相关的文章来记录我学习其的总结。
## 初探 SDJ
先让我们来巩固一下 Java 的基础知识。Java 是面向对象的语言，目的是解决现实生活中的问题，可以通过使用类来包装现实生活中的事物成对象、使用属性来描述对象的特点并使用方法来控制对象的行为。我们在 Java 里一切的操作都是针对对象本身，这也是为什么我们需要 ORM 来操作存储在数据库里面的“对象”。题外话，对于类似于 [Redis](https://redis.io/) 这种基于 Key-Value 存储的 NoSQL（非关系型数据库）来说，我们并不能很显然地观察到存储在里面的“对象”，因为这种“对象”不同于关系型数据库里的对象，比如 [MySQL](https://www.mysql.com/cn/)。在 MySQL 中，其 Table 就对应 Java 中的类，每一条 Column 对应的就是对象，每一个字段对应的就是属性，当然 MySQL 也有自己的方法，不过不在本文讨论范围内。我们可以很直观地通过查询 SQL 语句来观察“对象”，但在 NoSQL 中，我们只能通过序列号和反序列化来写和读对象。相信我，您宁愿看汇编也不想看序列化之后的对象……

为了节省时间，关于用什么和怎么来构建基本环境不在此赘述，这里提供 SDJ 的[官方指南](https://spring.io/guides/gs/accessing-data-mysql/)之一供您参考，只要您能引用 SDJ 的包（org.springframework.data:spring-data-jpa:1.11.6.RELEAS）就行。

SDJ 对于应用来说最应该关注的就是以下几个核心接口（按照从子类到父类的继承顺序）：

* JpaRepository —— JPA 协议的具体实现的接口。
```java
    package org.springframework.data.jpa.repository;

    public interface JpaRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {}
```
* PagingAndSortingRepository —— 分页和排序检索的接口。
```java
    package org.springframework.data.repository;

    public interface PagingAndSortingRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {}
```
* CrudRepository —— 通用CRUD操作的接口。
```java
    package org.springframework.data.repository;
    public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {}
```

就如同名称所示，我们可以根据情况继承特定的接口，不同的接口提供不同的功能，如果我们需要分页和排序，就继承 `PagingAndSortingRepository` 接口。但为了全方位地了解 SDJ，本文使用 `JpaRepository` 接口，由于其位于继承树的最底端，可以理解成二叉树里面的树叶，所以可以使用包括其父类的所有未被重写方法。当然这样也有一些不影响功能实现的矛盾点，我们一会会见到。
## 为使用默认的接口方法做准备
