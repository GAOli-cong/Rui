下面就先来说一下开发目的和展示一下完成后的效果图
后面会不断更新开发代码，这个页面就先不涉及代码喽
## 开发目的
为了能更好的记录情侣之间的点点滴滴，记录恋爱过程和时间，记录纪念日，让情侣之间变的更加关心，回忆一起走过的路程。
当情侣身处于异地，能给为情侣之间增添一份温暖，回忆一路走来的点滴，每过一秒，在一起的时间就会被记录其中。时间轴能够为情侣记录从相识到相恋，让爱情不断的升温。
让我们先来看一下界面叭
打开软件会进入到此页面，通过5秒钟的闪屏界面进入软件首页，可以通过点击右上角跳过直接进入软件的首页面。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200616182926940.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
**首页面**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200616183041293.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
首页面能够记录情侣之间在一起的时间，实时每隔一秒刷新时间，可以清楚的看到情侣在一起的天数、小时、分钟和秒数。
	 页面中部的红心，点击可以看到会有红心飘出，每隔一秒就会有小心心飘出。
 **动态页面** 
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200616183147988.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
	 能够展示情侣之间的点点滴滴，记录好在一起的每一个特殊的日子，通过时间轴的方式更加形象直观的展示时间、发生的故事。
		**列表子项页面**
	![在这里插入图片描述](https://img-blog.csdnimg.cn/20200616183306922.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
	点击记录的某一项会更加详细的进入到详情页面，更加详细的展示出这一天发生的事情，以及能够让值得回忆的点滴。
	
**我的页面**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620192805767.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
能够展示出实用工具，例如天气，此页面也是登录界面，能够通过点击进入到后台系统，对数据进行增删改查这个是需要连接后台的。
**实用工具-天气页面**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620193934967.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
此界面能够展示出当前的天气信息，为情侣之间的出行计划提供参考，能展示出当前城市的未来3小时天气信息，还能够为未来7天的天气进行预报，底部能够为当前天气状况为您提供详细的出行指数、舒适度指数、洗车指数、穿衣指数。
**后台操作界面**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620192913911.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
通过登录界面，登录成功会跳转到此界面，进而完成对后台数据的操作，可以完成添加、删除的功能。

**添加记录页面**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620192941401.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
根据输入框的提示，填入标题、时间、内容，点击确定即可完成时间轴的添加功能，注意时间的格式信息，如果是空参数，点击确定会提示不能为空。

**删除功能页面**
此界面能够展示出所有的时间轴信息，如果想要删除，通过点击右侧蓝色删除按钮，即可完成删除操作，删除成功会给出相应提示。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200620193120419.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
好了具体的页面介绍就这些，关我呦，后面会不断更新代码滴
