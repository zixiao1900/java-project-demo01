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