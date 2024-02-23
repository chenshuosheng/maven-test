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



**打包时，默认打包src/main/java下的 .java 文件到target/classes下对应目录下，不会打包其它类型的资源，如xml文件，只有放在resource下才会被正常打包。为了解决该问题，可以通过指定打包文件类型进行处理**

![image-20240221210748112](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240221210748112.png)



![image-20240221210923915](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240221210923915.png)



![image-20240221211932956](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240221211932956.png)





#### 3. pom.xml文件

- ##### POM(Project Object Model)：项目对象模型

- ##### 各个标签

  - name：模块的名字

  - description：模块描述信息

  - packaging：打包方式

    - jar：表示该工程是一个Java工程
    - war：表示该工程是一个Web工程
    - pom：表示该工程是一个“管理其它工程”的工程

  - build: 

    - **默认情况下，构建不需要额外配置，都有对应的缺省配置。当然也可以通过pom.xml文件定制一些配置，来修改默认构建的行为和产物**

      - 指定构建打包文件的名称，不使用默认名称（artifactId+version）
      - 制定构建打包时，指定包含文件格式和排除文件
      - 打包插件版本过低时，配置更高版本插件

    - finalName：自定义打包名称

    - plugins：插件

      - ```java
        <build>
          <!--自定义打包名称-->
          <finalName>maven_web-1.0</finalName>
          <plugins>
            <plugin>
              <groupId>org.apache.tomcat.maven</groupId>
              <artifactId>tomcat7-maven-plugin</artifactId>
              <version>2.2</version>
              <configuration>
                <!--tomcat服务端口号，启动Tomcat服务器时，它将监听8090端口上的请求-->
                <port>8090</port>
                <!--表示应用程序将会被部署在Tomcat服务器的根路径下-->
                <path>/</path>
                <!--指定URI的编码方式。在这里，编码方式被设置为UTF-8，这意味着URI中的字符将会以UTF-8编码进行解析-->
                <uriEncoding>UTF-8</uriEncoding>
                <!--服务器名称-->
                <server>tomcat7</server>
              </configuration>
            </plugin>
          </plugins>
        </build>
        ```

      - ![image-20240221213510037](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240221213510037.png)

      - ```xml
        "C:\Program Files\Java\jdk1.8.0_111\bin\java.exe" -Dmaven.multiModuleProjectDirectory=F:\programByCSS\maven\maven_test\maven_web_plugin -Dmaven.home=E:\Maven\apache-maven-3.6.1 -Dclassworlds.conf=E:\Maven\apache-maven-3.6.1\bin\m2.conf "-Dmaven.ext.class.path=E:\Java\IDEA\IntelliJ IDEA 2021.3\plugins\maven\lib\maven-event-listener.jar" "-javaagent:E:\Java\IDEA\IntelliJ IDEA 2021.3\lib\idea_rt.jar=65121:E:\Java\IDEA\IntelliJ IDEA 2021.3\bin" -Dfile.encoding=UTF-8 -classpath E:\Maven\apache-maven-3.6.1\boot\plexus-classworlds-2.6.0.jar org.codehaus.classworlds.Launcher -Didea.version=2021.3 -s E:\Maven\apache-maven-3.6.1\conf\settings.xml org.apache.tomcat.maven:tomcat7-maven-plugin:2.2:run
        [INFO] Scanning for projects...
        [INFO] 
        [INFO] --------------------< org.example:maven_web_plugin >--------------------
        [INFO] Building maven_web_plugin 1.0-SNAPSHOT
        [INFO] --------------------------------[ war ]---------------------------------
        [INFO] 
        [INFO] >>> tomcat7-maven-plugin:2.2:run (default-cli) > process-classes @ maven_web_plugin >>>
        [INFO] 
        [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ maven_web_plugin ---
        [WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
        [INFO] Copying 0 resource
        [INFO] 
        [INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ maven_web_plugin ---
        [INFO] Nothing to compile - all classes are up to date
        [INFO] 
        [INFO] <<< tomcat7-maven-plugin:2.2:run (default-cli) < process-classes @ maven_web_plugin <<<
        [INFO] 
        [INFO] 
        [INFO] --- tomcat7-maven-plugin:2.2:run (default-cli) @ maven_web_plugin ---
        [INFO] Running war on http://localhost:8090/
        [INFO] Creating Tomcat server configuration at F:\programByCSS\maven\maven_test\maven_web_plugin\target\tomcat
        [INFO] create webapp with contextPath: 
        二月 21, 2024 9:35:51 下午 org.apache.coyote.AbstractProtocol init
        信息: Initializing ProtocolHandler ["http-bio-8090"]
        二月 21, 2024 9:35:51 下午 org.apache.catalina.core.StandardService startInternal
        信息: Starting service Tomcat
        二月 21, 2024 9:35:51 下午 org.apache.catalina.core.StandardEngine startInternal
        信息: Starting Servlet Engine: Apache Tomcat/7.0.47
        二月 21, 2024 9:35:52 下午 org.apache.coyote.AbstractProtocol start
        信息: Starting ProtocolHandler ["http-bio-8090"]
        ```

        

    - resources：

      - resource

        - directory：设置资源所在上级目录，如：src/main/java
        - includes：
          - include：设置包含的文件类型，如：** /  *.xml，表示包含任意子目录下所有xml类型的文件

      - ```java
            <build>
                <resources>
                    <resource>
                        <!--设置资源所在目录-->
                        <directory>src/main/java</directory>
                        <includes>
                            <!--设置包含的资源类型-->
                            <include>**/*.xml</include>
                        </includes>
                    </resource>
                </resources>
            </build>
        ```

  - properties：定义属性值

    - 自定义版本号，进行统一管理（对于同一个框架的一组 jar 包最好使用相同的版本，为了方便升级框架，可以将 jar 包的版本信息统一提取出来，统一声明版本号），在需要引用的地方使用“${标签}”
  
  - project.build.sourceEncoding：工程构建过程中读取源码时使用的字符集
  
    
  
- dependencyManagement：(依赖管理，**若不使用此标签，则父工程中所有依赖都会被子工程无条件继承，若使用了该标签，则在子工程中需要用到父工程中依赖时，只需要在子工程的**dependencies中添加相应的依赖信息即可（不需要指定版本信息）)
  
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
            
              

#### 4. 依赖的传递特性

##### 4.1. 传递的原则

- 当A依赖于B，而B依赖于C的前提下，C是否能传递到A，取决于B依赖C时使用的依赖范围以及配置
  - B依赖C时使用compile范围，可以传递
  - B依赖C时使用test或provide范围，不能传递，故需要相应的jar包时，就必须在需要的地方明确配置依赖才可
  - B依赖C时，若配置标签<optional>true</optional>，则不能传递
  
  
  
  - 模块B包含druid依赖

  - ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
    
        <groupId>org.example</groupId>
        <artifactId>maven_B</artifactId>
        <version>1.0-SNAPSHOT</version>
    
        <properties>
            <maven.compiler.source>8</maven.compiler.source>
            <maven.compiler.target>8</maven.compiler.target>
        </properties>
    
        <dependencies>
            <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>1.2.8</version>
            </dependency>
        </dependencies>
    
    </project>
    ```

  - 模块A依赖于模块B

  - ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
    
        <groupId>org.example</groupId>
        <artifactId>maven_A</artifactId>
        <version>1.0-SNAPSHOT</version>
    
        <properties>
            <maven.compiler.source>8</maven.compiler.source>
            <maven.compiler.target>8</maven.compiler.target>
        </properties>
    
        <dependencies>
            <dependency>
                <groupId>org.example</groupId>
                <artifactId>maven_B</artifactId>
                <version>1.0-SNAPSHOT</version>
            </dependency>
    
            <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
            <dependency>
                <groupId>org.junit.jupiter</groupId>
                <artifactId>junit-jupiter-api</artifactId>
                <version>5.8.2</version>
                <scope>test</scope>
            </dependency>
        </dependencies>
    </project>
    ```

  - 因此在模块A中可以使用druid的相关类(A中自动会引入B中包含的依赖(compile的，且未设置optional为true))

  - ![image-20240221215513938](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240221215513938.png)



##### 4.2. 依赖传递终止
  - 非compile范围进行依赖传递

  - 使用optional配置终止传递

  - 依赖冲突(传递的依赖已存在)

    

##### 4.3. 解决依赖冲突(如何选择重复依赖)的方式
###### 4.3.1. 自动选择

-  短路优先原则(第一原则)

  A—>B—>C—>D—>E—>X(version 0.0.1)      
  A—>F—>X(version 0.0.2)     
  则A依赖于X(version 0.0.2)     
  ![image-20240222190914475](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222190914475.png)


-  依赖路径长度相同情况下，则“先声明优先”(第二原则)
   
  A—>E—>X(version 0.0.1)
  A—>F—>X(version 0.0.2)
  则A依赖于X(version 0.0.1)
  ![image-20240222185200302](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222185200302.png)

###### 4.3.2.手动排除

- ![image-20240222192233042](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222192233042.png)

  - maven_A -- pom.xml
    
      - ```java
          <?xml version="1.0" encoding="UTF-8"?>
          <project xmlns="http://maven.apache.org/POM/4.0.0"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
              <modelVersion>4.0.0</modelVersion>
          
              <groupId>org.example</groupId>
              <artifactId>maven_A</artifactId>
              <version>1.0-SNAPSHOT</version>
          
              <properties>
                  <maven.compiler.source>8</maven.compiler.source>
                  <maven.compiler.target>8</maven.compiler.target>
              </properties>
          
              <dependencies>
                  <dependency>
                      <groupId>org.example</groupId>
                      <artifactId>maven_B</artifactId>
                      <version>1.0-SNAPSHOT</version>
                      <!--依赖排除，不指定的话，根据依赖传递第二原则，将会引入maven_B下对应的版本-->
                      <exclusions>
                          <exclusion>
                              <groupId>io.swagger.core.v3</groupId>
                              <artifactId>swagger-annotations</artifactId>
                          </exclusion>
                      </exclusions>
                  </dependency>
                  <dependency>
                      <groupId>org.example</groupId>
                      <artifactId>maven_C</artifactId>
                      <version>1.0-SNAPSHOT</version>
                  </dependency>
          
                  <!--用于验证依赖传递的第一原则，依赖路径最短-->
                  <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
                  <dependency>
                      <groupId>org.apache.logging.log4j</groupId>
                      <artifactId>log4j-core</artifactId>
                      <version>2.17.1</version>
                  </dependency>
          
                  <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
                  <dependency>
                      <groupId>org.junit.jupiter</groupId>
                      <artifactId>junit-jupiter-api</artifactId>
                      <version>5.8.2</version>
                      <scope>test</scope>
                  </dependency>
              </dependencies>
          </project>
          ```
      
  - maven_B -- pom.xml
    
      - ```java
            <?xml version="1.0" encoding="UTF-8"?>
            <project xmlns="http://maven.apache.org/POM/4.0.0"
                     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                     xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
                <modelVersion>4.0.0</modelVersion>
            
                <groupId>org.example</groupId>
                <artifactId>maven_B</artifactId>
                <version>1.0-SNAPSHOT</version>
            
                <properties>
                    <maven.compiler.source>8</maven.compiler.source>
                    <maven.compiler.target>8</maven.compiler.target>
                </properties>
            
                <dependencies>
                    <!--用于验证依赖传递的第一原则，依赖路径最短-->
                    <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
                    <dependency>
                        <groupId>org.apache.logging.log4j</groupId>
                        <artifactId>log4j-core</artifactId>
                        <version>2.19.0</version>
                    </dependency>
            
                    <!--用于验证依赖传递的第二原则，路径长度相同，先声明优先-->
                    <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
                    <dependency>
                        <groupId>com.alibaba</groupId>
                        <artifactId>druid</artifactId>
                        <version>1.2.8</version>
                        <!--添加下列配置，依赖传递将被终止-->
                        <!--<optional>true</optional>-->
                    </dependency>
                    <!--&lt;!&ndash; https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api &ndash;&gt;
                    <dependency>
                        <groupId>org.junit.jupiter</groupId>
                        <artifactId>junit-jupiter-api</artifactId>
                        <version>5.8.2</version>
                        &lt;!&ndash;<scope>test</scope>&ndash;&gt;
                    </dependency>-->
            
            
                    <!-- https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-annotations -->
                    <dependency>
                        <groupId>io.swagger.core.v3</groupId>
                        <artifactId>swagger-annotations</artifactId>
                        <version>2.2.15</version>
                    </dependency>
                </dependencies>
            </project>
        ```
      
  -  maven_C -- pom.xml
     
      - ```java
          <?xml version="1.0" encoding="UTF-8"?>
          <project xmlns="http://maven.apache.org/POM/4.0.0"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
              <modelVersion>4.0.0</modelVersion>
          
              <groupId>org.example</groupId>
              <artifactId>maven_C</artifactId>
              <version>1.0-SNAPSHOT</version>
          
              <properties>
                  <maven.compiler.source>8</maven.compiler.source>
                  <maven.compiler.target>8</maven.compiler.target>
              </properties>
          
              <dependencies>
                  <!--用于验证依赖传递的第二原则，路径长度相同，先声明优先-->
                  <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
                  <dependency>
                      <groupId>com.alibaba</groupId>
                      <artifactId>druid</artifactId>
                      <version>1.2.7</version>
                  </dependency>
          
                  <!-- https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-annotations -->
                  <dependency>
                      <groupId>io.swagger.core.v3</groupId>
                      <artifactId>swagger-annotations</artifactId>
                      <version>2.2.3</version>
                  </dependency>
              </dependencies>
          </project>
          ```
      
      

### 五. Maven工程继承关系

  - 概念：Maven继承是指在Maven项目中，让一个项目从另一个项目中继承配置信息的机制，继承可以让我们在多个项目中共享同一配置信息，简化项目的管理和维护工作 。 Maven工程A继承自工程B，A是子工程、B是父工程

  - 作用：在父工程中统一管理项目中的依赖信息(主要指的是依赖版本信息)，实际上被管理的依赖并没有真正被引入到工程中，只有当子工程中引用时才会引入依赖到子工程中

    

#### 1. 父工程中不使用dependencyManagement标签进行依赖管理时

![image-20240222221128935](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222221128935.png)

maven_parent的pom.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>css.example</groupId>
    <artifactId>maven_parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <modules>
        <module>maven_son</module>
    </modules>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

             
    <dependencies>
        <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.8</version>
            <!--添加下列配置，依赖传递将被终止，子模块都会继承-->
            <optional>true</optional>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
            <!--子模块都会继承-->
            <scope>provided</scope>
        </dependency>
    </dependencies>
</project>
```



![image-20240222220955400](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222220955400.png)

maven_son的pom.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!--设置父工程的坐标-->
    <parent>
        <artifactId>maven_parent</artifactId>
        <groupId>css.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <!--由于子工程的groupId和version必须和父工程保持一致，故无需再写一遍-->
    <artifactId>maven_son</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

</project>
```



![image-20240222222035286](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222222035286.png)



#### 2. 父工程中使用dependencyManagement标签进行依赖管理时

maven_parent的pom.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>css.example</groupId>
    <artifactId>maven_parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <modules>
        <module>maven_son</module>
    </modules>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <!--依赖管理，
    若不使用此标签，则父工程中所有依赖都会被子工程无条件继承，
    若使用了该标签，则在子工程中需要用到父工程中依赖时，
    只需要在子工程的dependencies中添加相应的依赖信息即可（不需要指定版本信息）)
    -->
    <dependencyManagement>
        <dependencies>
            <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>1.2.8</version>
                <!--添加下列配置，依赖传递将被终止，子模块都会继承-->
                <optional>true</optional>
            </dependency>

            <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>1.18.24</version>
                <!--子模块都会继承-->
                <scope>provided</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```



maven_son的pom.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!--设置父工程的坐标-->
    <parent>
        <artifactId>maven_parent</artifactId>
        <groupId>css.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <!--由于子工程的groupId和version必须和父工程保持一致，故无需再写一遍-->
    <artifactId>maven_son</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
    </dependencies>
</project>
```

![image-20240222223618765](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222223618765.png)



### 六. Maven工程聚合关系

![image-20240222224340274](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20240222224340274.png)

![image-20240222224411682](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222224411682.png)



### 七. Maven私服

![image-20240222225104921](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222225104921.png)



![image-20240222225156933](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222225156933.png)



![image-20240222225441135](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240222225441135.png)



#### 1. 个人Maven私服

##### 1.1. 下载启动Nexus

nexus下载链接：[Nexus Repository Manager - Software Component Management | Sonatype](https://www.sonatype.com/thanks/repo-oss?submissionGuid=15b2aff0-24c7-4d35-94da-3bac4d671064)

###### 1.1.1. 解压安装包得到：

​	![image-20240223122940009](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223122940009.png)

###### 1.1.2.以管理员身份打开命令行

![image-20240223123238489](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223123238489.png)


###### 1.1.3.进入nexus.exe所在目录，执行命令./nexus /run

![image-20240223122416500](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223122416500.png)

启动成功

![image-20240223123648511](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223123648511.png)



##### 1.2. 访问Nexus首页 http://localhost:8081

![image-20240223124138855](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223124138855.png)



##### 1.3. 登录

###### 1.3.1. 获取密码
![image-20240223124411158](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223124411158.png)


![image-20240223124459823](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223124459823.png)


###### 1.3.2. 登录并修改密码
![image-20240223124708021](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223124708021.png)


###### 1.3.3. 设置是否允许匿名访问
![image-20240223125023134](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223125023134.png)

登录成功

![image-20240223125305864](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223125305864.png)



##### 1.4. 配置maven的settings.xml文件
###### 1.4.1. 拷贝副本，保留原配置 ![image-20240223130312223](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223130312223.png)


###### 1.4.2. 配置本地仓库路径![image-20240223130549420](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20240223130549420.png)


###### 1.4.3. 配置私服镜像![image-20240223131059631](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223131059631.png)



若前面设置了禁用匿名访问，则需添加设置（server中id的值应与mirror中的id保持相同）

![image-20240223131556266](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223131556266.png)



##### 1.5. 使用maven私服下载依赖
此时打开idea，可以发现maven本地仓库的配置已经自动改变

![image-20240223140819181](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223140819181.png)



本地仓库目录已自动生成，并已经下载了部分依赖，但是maven依赖管理的相关插件并没有自动下载，需要手动刷新下载

![image-20240223141042210](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223141042210.png)

![image-20240223141203744](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223141203744.png)

![image-20240223141558748](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223141558748.png)



maven私服Nexus中已经自动从中央仓库下载了相应的依赖

![image-20240223141347821](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223141347821.png)



手动刷新下载插件依赖后，依赖明显增多

![image-20240223141715454](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223141715454.png)



对模块进行打包，可以观察到从maven私服下载依赖资源

![image-20240223142439205](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223142439205.png)



##### 1.6. 上传个人jar包到maven私服

###### 1.6.1. 配置私服相关信息

```java
<!--http://localhost:8081/repository/maven-snapshots/-->
<!--部署本jar包到maven私服-->
<distributionManagement>
    <snapshotRepository>
        <id>nexus-mine</id>
        <name>Nexus Snapshot</name>
        <url>http://localhost:8081/repository/maven-snapshots/</url>
    </snapshotRepository>
</distributionManagement>
```



###### 1.6.2. 执行部署deploy

```xml
"C:\Program Files\Java\jdk1.8.0_111\bin\java.exe" -Dmaven.multiModuleProjectDirectory=F:\programByCSS\maven\maven_test\maven_mvn -Dmaven.home=E:\Maven\apache-maven-3.6.1 -Dclassworlds.conf=E:\Maven\apache-maven-3.6.1\bin\m2.conf "-Dmaven.ext.class.path=E:\Java\IDEA\IntelliJ IDEA 2021.3\plugins\maven\lib\maven-event-listener.jar" "-javaagent:E:\Java\IDEA\IntelliJ IDEA 2021.3\lib\idea_rt.jar=55249:E:\Java\IDEA\IntelliJ IDEA 2021.3\bin" -Dfile.encoding=UTF-8 -classpath E:\Maven\apache-maven-3.6.1\boot\plexus-classworlds-2.6.0.jar org.codehaus.classworlds.Launcher -Didea.version=2021.3 -s E:\Maven\apache-maven-3.6.1\conf\settings.xml deploy
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< org.example:maven_mvn >------------------------
[INFO] Building maven_mvn 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ maven_mvn ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 3 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ maven_mvn ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to F:\programByCSS\maven\maven_test\maven_mvn\target\classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ maven_mvn ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory F:\programByCSS\maven\maven_test\maven_mvn\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ maven_mvn ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to F:\programByCSS\maven\maven_test\maven_mvn\target\test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ maven_mvn ---
[INFO] Surefire report directory: F:\programByCSS\maven\maven_test\maven_mvn\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.css.MvnTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ maven_mvn ---
[INFO] Building jar: F:\programByCSS\maven\maven_test\maven_mvn\target\maven_mvn-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ maven_mvn ---
[INFO] Installing F:\programByCSS\maven\maven_test\maven_mvn\target\maven_mvn-1.0-SNAPSHOT.jar to E:\Maven\apache-maven-3.6.1\mvn_resp(private_server)\org\example\maven_mvn\1.0-SNAPSHOT\maven_mvn-1.0-SNAPSHOT.jar
[INFO] Installing F:\programByCSS\maven\maven_test\maven_mvn\pom.xml to E:\Maven\apache-maven-3.6.1\mvn_resp(private_server)\org\example\maven_mvn\1.0-SNAPSHOT\maven_mvn-1.0-SNAPSHOT.pom
[INFO] 
[INFO] --- maven-deploy-plugin:2.7:deploy (default-deploy) @ maven_mvn ---
Downloading from nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven-metadata.xml
Uploading to nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven_mvn-1.0-20240223.064100-1.jar
Uploaded to nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven_mvn-1.0-20240223.064100-1.jar (4.7 kB at 36 kB/s)
Uploading to nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven_mvn-1.0-20240223.064100-1.pom
Uploaded to nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven_mvn-1.0-20240223.064100-1.pom (1.9 kB at 21 kB/s)
Downloading from nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/maven-metadata.xml
Uploading to nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven-metadata.xml
Uploaded to nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven-metadata.xml (764 B at 8.9 kB/s)
Uploading to nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/maven-metadata.xml
Uploaded to nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/maven-metadata.xml (278 B at 3.2 kB/s)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.558 s
[INFO] Finished at: 2024-02-23T14:41:00+08:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
```



###### 1.6.3. 查看maven私服

![image-20240223144336409](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240223144336409.png)



##### 1.7. 使用他人的jar包

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>maven_web</artifactId>
    <version>1.0-SNAPSHOT</version>

    <packaging>war</packaging>

    <dependencies>
        <dependency>
            <groupId>org.example</groupId>
            <artifactId>maven_mvn</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

    <repositories>
        <repository>
            <id>nexus-mine</id>
            <name>nexus-mine</name>
            <url>http://localhost:8081/repository/maven-snapshots/</url>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
            <releases>
                <enabled>true</enabled>
            </releases>
        </repository>
    </repositories>
</project>
```



打包可以观察到，依赖从http://localhost:8081/repository/maven-snapshots下载

```xml
"C:\Program Files\Java\jdk1.8.0_111\bin\java.exe" -Dmaven.multiModuleProjectDirectory=F:\programByCSS\maven\maven_test\maven_web -Dmaven.home=E:\Maven\apache-maven-3.6.1 -Dclassworlds.conf=E:\Maven\apache-maven-3.6.1\bin\m2.conf "-Dmaven.ext.class.path=E:\Java\IDEA\IntelliJ IDEA 2021.3\plugins\maven\lib\maven-event-listener.jar" "-javaagent:E:\Java\IDEA\IntelliJ IDEA 2021.3\lib\idea_rt.jar=58652:E:\Java\IDEA\IntelliJ IDEA 2021.3\bin" -Dfile.encoding=UTF-8 -classpath E:\Maven\apache-maven-3.6.1\boot\plexus-classworlds-2.6.0.jar org.codehaus.classworlds.Launcher -Didea.version=2021.3 -s E:\Maven\apache-maven-3.6.1\conf\settings.xml package
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< org.example:maven_web >------------------------
[INFO] Building maven_web 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
Downloading from nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven_mvn-1.0-20240223.064100-1.pom
Downloaded from nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven_mvn-1.0-20240223.064100-1.pom (1.9 kB at 11 kB/s)
Downloading from nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven_mvn-1.0-20240223.064100-1.jar
Downloaded from nexus-mine: http://localhost:8081/repository/maven-snapshots/org/example/maven_mvn/1.0-SNAPSHOT/maven_mvn-1.0-20240223.064100-1.jar (4.7 kB at 196 kB/s)
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ maven_web ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ maven_web ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ maven_web ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory F:\programByCSS\maven\maven_test\maven_web\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ maven_web ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ maven_web ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-war-plugin:2.2:war (default-war) @ maven_web ---
[INFO] Packaging webapp
[INFO] Assembling webapp [maven_web] in [F:\programByCSS\maven\maven_test\maven_web\target\maven_web-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Copying webapp resources [F:\programByCSS\maven\maven_test\maven_web\src\main\webapp]
[INFO] Webapp assembled in [39 msecs]
[INFO] Building war: F:\programByCSS\maven\maven_test\maven_web\target\maven_web-1.0-SNAPSHOT.war
[INFO] WEB-INF\web.xml already added, skipping
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.125 s
[INFO] Finished at: 2024-02-23T15:37:00+08:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
```

