					   # 通讯录web程序
					   ----------------
### 简介：   
    采用srevlet和xml(“模拟数据库存储用户数据”)，主页面为查看所有联系人，并实现添加、修改、删除、查看所有联系人功能。注意：contact.xml文件放在E盘下。

#### 1、需求分析： 

	    1）添加联系人  
	    2）修改联系人  
	    3）删除联系人  
	    4）查询所有联系人  
####2、需求设计：    

	    1）设计抽象实体类   
		联系人Contact实体类    
			class Contact{
                private String id;  
				private String name; 
				private String gender;	
				private int age;	
				private String phone;	
				private String email;	
				private String qq;				
			    }       

