#### struts、hibernate、spring 整合案例  
  
* 注意：在web.xml文件中加入一下：  
```xml
<filter>
		<filter-name>OpenSessionInView</filter-name>
		<filter-class>org.springframework.orm.hibernate3.support.OpenSessionInViewFilter</filter-class>
	</filter>
```  
* 目的：JSp页面访问懒加载数据( 注意：访问struts时候需要带上*.action后缀)
