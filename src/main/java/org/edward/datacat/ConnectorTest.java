package org.edward.datacat;

import org.edward.datacat.connector.OracleConnector;
import org.edward.datacat.model.OracleConnectionInfo;
import org.edward.datacat.util.ParamsUtil;

import java.sql.Connection;

public class ConnectorTest {
    private static final String PREFIX = "-";

    public static void main(String[] args) throws Exception {
        String host = ParamsUtil.getValueByKey(args, "host", PREFIX);
        String port = ParamsUtil.getValueByKey(args, "port", PREFIX);
        String serviceName = ParamsUtil.getValueByKey(args, "service_name", PREFIX);
        String role = ParamsUtil.getValueByKey(args, "role", PREFIX);
        String userName = ParamsUtil.getValueByKey(args, "user_name", PREFIX);
        String password = ParamsUtil.getValueByKey(args, "password", PREFIX);
        String connectTimeout = ParamsUtil.getValueByKey(args, "connect_timeout", PREFIX);
        String driverPath = ParamsUtil.getValueByKey(args, "driver_path", PREFIX);
        String driverClassName = ParamsUtil.getValueByKey(args, "driver_classname", PREFIX);
        System.out.println("###### 连接信息 ######");
        System.out.println(">>>>>> host : " + host);
        System.out.println(">>>>>> port : " + port);
        System.out.println(">>>>>> serviceName : " + serviceName);
        System.out.println(">>>>>> role : " + role);
        System.out.println(">>>>>> userName : " + userName);
        System.out.println(">>>>>> password : " + password);
        System.out.println(">>>>>> connectTimeout : " + connectTimeout);
        System.out.println(">>>>>> driverPath : " + driverPath);
        System.out.println(">>>>>> driverClassName : " + driverClassName);
        System.out.println("####################");
        OracleConnectionInfo connectionInfo = new OracleConnectionInfo();
        connectionInfo.setHost(host);
        connectionInfo.setPort(Integer.parseInt(port));
        connectionInfo.setServiceName(serviceName);
        connectionInfo.setRole(role);
        connectionInfo.setUserName(userName);
        connectionInfo.setPassword(password);
        connectionInfo.setConnectTimeout(Long.parseLong(connectTimeout));
        connectionInfo.setDriverPath(driverPath);
        connectionInfo.setDriverClassName(driverClassName);
        try {
            System.out.println("开始连接......");
            Connection connection = new OracleConnector().connect(connectionInfo);
            if(connection == null) {
                System.out.println("连接失败！！！");
                return;
            }
            System.out.println("连接成功");
        } catch (Exception e) {
            System.out.println("连接失败！！！");
            e.printStackTrace();
        }
    }
}