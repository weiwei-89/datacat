# datacat
数据猫

### 使用说明

**启动脚本**<br>
*java -jar* `datacat-1.0-SNAPSHOT.jar`<br>
*-host="10.10.64.34"<br>
-port="1521"<br>
-service_name="orcl"<br>
-role="sysdba"<br>
-user_name="sys"<br>
-password="sys"<br>
-connect_timeout="5000"<br>
-driver_path="/home/edward/drivers/ojdbc6.jar"<br>
-driver_classname="oracle.jdbc.driver.OracleDriver"<br>*

**参数说明**<br>
*host* : 数据库地址<br>
*port* : 数据库端口<br>
*service_name* : 服务名称<br>
*role* : 角色<br>
*user_name* : 用户名<br>
*password* : 密码<br>
*connect_timeout* : 连接超时时间（毫秒）<br>
*driver_path* : 驱动包地址<br>
*driver_classname* : 驱动类地址<br>