# UPDATE1.0   JspLoginDemo

广东财经大学实验楼八楼机房  2017年7月24日09:26:25

搞Java有一段时间了，最近有空就看了看Jsp+Servlet

做了一个阶段小案例出来

基于MyEclipse开发工具

# UPDATE2.0   Jsp + Servlet + JavaBean MVC小例子

用户提交用户名和密码给后台，后台去数据库中匹配，

如果匹配到了，那么返回该用户的用户名，密码，所读学校，身高等信息。

这里用到了MySql数据库，动态生成了页面。

利用了MVC三层模型

# UPDATE3.0   JspLoginDemo  
# 2017年8月1日11:52:17

放在了centos的tomcat的服务器上测试成功
地址在 http://120.77.254.6:8080/JspLoginDemo/

# kkk  2017年9月13日16:32:19 更新

加入了新的Demo, 所有代码都是纯手工打。

运行了一天后发觉mysql会自动关闭（真的是，运行会出很多错呢）

界面真心丑啊，哭死。要去学学Bootstrap才行啊

![Image text](https://github.com/wenbochang888/JspLoginDemo/blob/master/kkk.png)

地址在 http://120.77.254.6:8080/kkk/

# UPDATE4.0   MVC  
# 2017年9月28日11:22:27

超级标准的MVC设计模式

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/MVC.png)

感觉之前的都白学了，自从发现了尚硅谷的视频，发觉发现了新大陆。

以前写的代码真的是奇丑务必，虽然功能也能实现。但发觉维护，以及面向接口编程用的渣渣。

不多说废话，直接看效果图

index.jsp页面

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/index.png)

支持模糊查询

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/query.png)

更新判断，并且出错信息不回丢失

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/update.png)

用了差不多一个星期搞定的，跟着视频搞着。

准备花几天做一个类似标准的MVC实现，不看视频，练练手

# UPDATE5.0   BootStrapMVC  
# 2017年10月5日22:32:30

一直说要学BootStrap，花了两天时间把BootStrap官方文档Docs看了看，然后又看了点

博客，知乎教程就直接用了

对于一个纯理工科的人，几乎没有一点设计艺术细胞。

发觉BootStrap的css包装的还是很不错的（不要骂我，哈哈哈，你看我以前的界面就知道了）

我还是觉得BootStrap还是蛮好看的，毕竟我看起来挺舒服的。

LeetCode等一些网站就是BootStrap风格的

这个项目就是上面项目来的，上面的MVC设计模式，然后我加了点界面

最后在学spring，学完加点spring的东西进去，hahahah

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/BootStrap1.png)

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/BootStrap2.png)

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/BootStrap3.png)

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/BootStrap4.png)


# UPDATE6.0   源于数据库的一个作业 
# 2017年11月11日23:22:42

增加内容：分页，还有年月日的统计

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/HomeWork2Page.png)

![Image text](https://github.com/wenbochang888/MVC/blob/master/img/HomeWork2Year.png)

重点来了，敲黑板。啊哈哈哈。

最近在看《设计模式之禅》这本书，感觉作者真的用心去写这本书，写的也是特别的好。

我也非常的喜欢，奈何自己水平有限，有些并不能理解。

里面有一个话这样说的：**客户的需求是一个无底洞，项目要随时的变化**

这一句话我真的有深刻的体会，前面我这些小项目，我想要加入一个功能，就要在jsp，servlet，DAO

里面等等，改来改去，有的时候改的真的要崩溃，最后调试部署运行的时候，还出错。

这也许就是“差代码”，可维护性很低吧。给以后增加需求带来不可变的风险。

所以，这次项目尽量依据一些设计模式，尽可能的写出一手好的代码。

ps. 设计感觉不是看出来的，是用出来的。我这个小项目中，虽然自己没有注意，但用到了很多设计模式，

这是事后才发掘的。比如连接数据库时，用了单例模式，统计年月日，用了装饰着模式，还有建造者模式等等，感觉用到项目才是真。

写于 2017年11月11日23:29:58。接下来要好好做一个“真正”拿得出手的项目了。