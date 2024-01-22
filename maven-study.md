### Maven ——  一种专门用来为Java项目提供构建、依赖管理支持的工具

<img src="https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150024548.png" alt="image-20240122150024548" style="zoom:67%;" />



### 一. Maven配置

#### 1. 配置本地仓库

![image-20240122150330235](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150330235.png)



![image-20240122150359094](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150359094.png)



<img src="https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150458294.png" alt="image-20240122150458294" style="zoom: 50%;" />



#### 2. 配置阿里云镜像

![image-20240122150724112](https://cdn.jsdelivr.net/gh/chenshuosheng/picture/maven/image-20240122150724112.png)



### 二.Maven基础概念

#### 1. 坐标

- ##### groupId：公司或组织的id

- ##### artifactId：一个项目/项目中一个模块的id，即模块的名称，将来作为Maven工程的工程名

- ##### version：版本号

#### 2. pom.xml文件

- ##### POM(Project Object Model)：项目对象模型

- ##### 各个标签

  - name：模块的名字

  - description：模块描述信息

  - packaging：打包方式

    - jar：表示该工程是一个Java工程
    - war：表示该工程是一个Web工程
    - pom：表示该工程是一个“管理其它工程”的工程

  - properties

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

