module1：
    输入输出, if else, for, 方法的定义和使用
    calculator定义的内容是直接从控制台输入信息 返回贷款计算器计算后的信息

module3:
    整个模块结构是从https://start.spring.io/或者https://start.aliyun.com/上下载的
    这个模块 spring boot代码 Module2Application是Spring Boot入口
    resources/static里面是静态页面
    功能是贷款计算器
    用的是类的静态方法 逻辑都写在了Controller里面

module4:
    这个模块也是SpringBoot模块
    主要用的是类的实例方法   Calculator是父类  Calculator0, 1, 2继承于父类 子类可以调用父类的实例方法  也可以重写父类的方法
    Controller类中利用多态和传入的type值调对应的Calculator0,1,2调用不同的贷款计算器
    main里面写类   功能是贷款计算器
    test里面写测试类 这里教学基础内容

module5:
    数据存在JavaBean类中Calculator
    业务逻辑用接口CalculatorService  实现类(CalculatorService0,1,2)的方式实现  用接口是因为父类子类是单继承 接口可以多实现

    controller存放控制器类
    dto存放JavaBean类
    service存放service接口和实现类
    入口类的位置放在上面几个包的外层 要去查找@controller @service 创建对象

mybili
    test中用@@SpringBootTest  可以@Autowired 也可以侧多个不像main中只能测试一个

    主要实现了视频展示播放功能 用了mysql作为数据库 数据库里有一列存的是视频的url并不是整个视频 mybatis把数据库中的内容转为JavaBean 具体要仔细看了
    data/sqltext.sql中就是mysql表的建表和一些信息

    1 mybatis, mysql依赖可以上https://start.spring.io/ 生成之后复制粘贴到pom文件中
    2 resources目录下创建application.properties 将数据库部分信息写入
    3 dto里面写一个类(JavaBean)和数据库的表相对应 用于接收表里每一条数据 创建成类的对象
    4 新建包mapper里面写一个StudentMapper的接口 封装各种增删改查的方法 用@Mapper装饰这个接口
    5 测试的时候 用@SpringBootTest装饰测试类 不要用main方法 用@Test装饰测试方法
        测试类里面用@Autowired装饰StudentMapper接口 就可以进行测试了



    上传部分：
        Springboot默认上传大小是1M 可以在application.properties中进行设置 下面是将默认的1mb改为8mb
        spring.servlet.multipart.max-file-size=8MB




    data里面部分文件是要写入mysql的 参考sqltext.sql
    通过VideoMapper和PlayMapper 从数据库中搜索bv值返回的信息映射到Video JavaBean中返回
    浏览器中locoalhost:8080/play不再从resource/static/play中找 而是挂载到D:\JavaCodes\java-project-demo01\video\ 通过url可以匹配到视频从而播放
    upload_video这个文件夹是上传功能上传及合并的位置
    resources/play目录下的文件用新的怪哉的地址之后就没啥用了
    img里面是原视频的封面以及上传视频时产生的封面图片