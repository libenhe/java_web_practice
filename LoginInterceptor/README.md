### struts 拦截器、登陆  
* 需求：登陆后，显示列表。在登录时过滤掉不符合的用户，使其返回到登陆页面；  
* demo准备：Struts jar 文件； Dbutils组件 数据库连接池/驱动包  
  
    
####出现的BUG
`The content of element type "package" must match "(result-types?,interceptors?,default-interceptor-ref?,default-action-ref?,default-class-ref?,global-results?,global-exception-mappings?,action*)". `  

  
* 原因：package里元素必须按照一定的顺序排列： (并且在出现拼写错误时，也会出现相同错误提示)  
   * result-types
   * interceptors
   * default-interceptor-ref
   * default-action-ref
   * default-class-ref
   * global-results
   * global-exception-mappings
   * action*（所有action放到最后）
   
