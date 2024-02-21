### Maven ——  一种专门用来为Java项目提供*构建、依赖管理*支持的工具

![image-20240219194502307](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240219194502307.png)



- 项目构建：指将源代码、配置文件、资源文件等转化为能够运行或部署的应用程序或库的过程。Maven可以管理项目的编译、测试、打包、部署等构建过程。通过**实现标准的构建生命周期**，Maven可以确保每一个构建过程都遵循同样的规则和最佳实践。同时，Maven的**插件机制**也使得开发者可以对构建过程进行扩展和定制。主动触发构建，只需要简单的命令操作即可。
- 依赖管理：Maven可以管理项目的依赖，包括自动下载所需依赖库、自动下载依赖需要的依赖并且保证版本没有冲突、依赖版本管理等。通过Maven，我们可以方便地维护项目所依赖的外部库，避免版本冲突和转换错误等。而我们仅需要编写配置即可。



### 一. Maven配置

![image-20240219194909872](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240219194909872.png)

#### 1. 配置本地仓库

![image-20240122150330235](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150330235.png)



![image-20240122150359094](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150359094.png)



<img src="https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150458294.png" alt="image-20240122150458294" style="zoom: 50%;" />



#### 2. 配置阿里云镜像

![image-20240122150724112](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150724112.png)



### 二.Maven工程项目结构

![image-20240220103729353](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220103729353.png)



### 三.使用mvn命令进行构建

<img src="https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150024548.png" alt="image-20240122150024548" style="zoom:67%;" />

![image-20240220112020098](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220112020098.png)

#### 1. mvn compile

![image-20240220111734406](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220111734406.png)



![image-20240220111753107](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220111753107.png)



##### **mvn compile**

—— 使用**mvn compile**生成的字节码文件**不包含**测试类的


![image-20240220204831146](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220204831146.png)

##### **mvn test-compile**
—— 使用mvn test-compile生成的字节码文件**包含**测试类的


![image-20240220205111340](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220205111340.png)



- #### 测试类及方法命名需要规范


```java
package com.css;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Description: TODO
 * @Author: CSS
 * @Date: 2024/2/20 20:43
 */

//测试类类名必须包含Test
public class MvnTest {

    @Test
    //方法名必须由小写test开头，加其它字符，否则使用命令进行测试时会识别不了
    public void testAssert() {
        int a = 10;
        int b= 20;
        Assertions.assertEquals(a+b,30);
    }
}
```



#### 2. mvn package

打包后的jar、war包中不包含测试类的相关代码，能打包成功便说明测试通过

![image-20240220212932093](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220212932093.png)



#### 3. mvn install

- ##### mvn package(打包)和mvn install(安装)的区别

![image-20240220213610408](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220213610408.png)

- ##### 安装后本地仓库出现：

![image-20240220213838237](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220213838237.png)



#### 4. mvn clean

![image-20240220111841885](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220111841885.png)



#### 5. 构建生命周期

—— 一组固定构建命令的有序集合，出发周期后的命令会自动触发周期前的命令

![image-20240220221348335](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220221348335.png)



### 四. Maven基础概念

#### 1. GAVP
  ——Maven中的GAVP是指GroupId、ArtifactId、Version、Packaging等四个属性的缩写，前三个是必要的，而Packaging属性是可选的

- ![image-20240220222042170](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220222042170.png)


- ![image-20240219202252650](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240219202252650.png)



#### 2. 依赖范围(scope)

![image-20240220223803323](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240220223803323.png)



#### 3. pom.xml文件

- ##### POM(Project Object Model)：项目对象模型

- ##### 各个标签

  - name：模块的名字

  - description：模块描述信息

  - packaging：打包方式

    - jar：表示该工程是一个Java工程
    - war：表示该工程是一个Web工程
    - pom：表示该工程是一个“管理其它工程”的工程

  - properties：定义属性值

    - 自定义版本号，进行统一管理（对于同一个框架的一组 jar 包最好使用相同的版本，为了方便升级框架，可以将 jar 包的版本信息统一提取出来，统一声明版本号），在需要引用的地方使用“${标签}”
    - project.build.sourceEncoding：工程构建过程中读取源码时使用的字符集

  - dependencyManagement：

    - dependencies：依赖配置

      - dependency：配置一个具体的依赖

        - 依赖作标信息(groupId、artifactId、version)

        - scope：依赖的使用范围

          - **complie(**默认值)：编译范围，用在编译、测试、运行，因运行时需要包含该依赖，故该依赖会被打包

          - **test**：仅用在测试，编译、运行时不需要（如：Junit）,因运行时不需要包含该依赖，故该依赖不会被打包

          - **runtime**：用在测试、运行，编译时不需要（如：jdbc的驱动包），因运行时需要包含该依赖，故该依赖会被打包

          - provided：只有当jdk或一个容器已提供该依赖，才会使用相应的依赖，用在编译、测试，运行时不需要（如：servlet api由Tomcat容器提供）

          - system：与 provide 类似，但是必须显示的提供一个对于本地系统中 jar 文件的路径。一般不推荐使用。

          

        - <img src="https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122153442601.png" alt="image-20240122153442601" style="zoom:80%;" />

        

        - exclusions：配置依赖排除

          - exclusion：一个具体的排除项

            - groupId

            - artifactId

            - 不需要写版本号

            

- ##### 继承

  - 概念：Maven工程A继承自工程B，A是子工程、B是父工程
  - 作用：在父工程中统一管理项目中的依赖信息(主要指的是依赖版本信息)，实际上被管理的依赖并没有真正被引入到工程中，只有当子工程中引用时才会引入依赖到子工程中







