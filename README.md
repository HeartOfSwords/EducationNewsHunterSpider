# EducationNewsHunterSpider
Web based spider system ,both running in hand mode and auto mode
# 手动模式
## 代码结构及运行原理
	1. HunterIndex作为首页路由在程序运行时加载，并加载首页
	2. 从页面传来url被URLPaser解析
	3. url如果正确则被传入JsoupUtils中，通过对应的方法分别取出文章题目及文章正文；
	4. 前面的数据正确取出之后再传入dao层持久化。
	5. 持久化成功/失败会记录到requst中并返回到首页。
## 查看效果
	在另一展示应用中可添加数据库访问逻辑并将对应的数据加载到页面上。
	这样便做到了数据采集和展示分离。
## 代码总体结构
	HunterIndex->URLPaser->JsoupUtils->Dao->HunterIndex

*全程借助DBUtil工具类与数据库建立连接并交互*
# 自动模式