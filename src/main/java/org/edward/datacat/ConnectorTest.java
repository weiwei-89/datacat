package org.edward.datacat;

import org.apache.commons.lang3.StringUtils;
import org.edward.datacat.connector.OracleConnector;
import org.edward.datacat.model.OracleConnectionInfo;
import org.edward.datacat.util.ParamsUtil;

import java.sql.Connection;
import java.util.Arrays;

public class ConnectorTest {
    private static final String PREFIX = "-";

    public static void main(String[] args) throws Exception {
        String host = ParamsUtil.getValueByKey(args, "host", PREFIX);
        if(StringUtils.isBlank(host)) {
            throw new Exception("host为空");
        }
        String port = ParamsUtil.getValueByKey(args, "port", PREFIX);
        if(StringUtils.isBlank(port)) {
            throw new Exception("port为空");
        }
        String serviceName = ParamsUtil.getValueByKey(args, "service_name", PREFIX);
        if(StringUtils.isBlank(serviceName)) {
            throw new Exception("serviceName为空");
        }
        String role = ParamsUtil.getValueByKey(args, "role", PREFIX);
        String userName = ParamsUtil.getValueByKey(args, "user_name", PREFIX);
        if(StringUtils.isBlank(userName)) {
            throw new Exception("userName为空");
        }
        String password = ParamsUtil.getValueByKey(args, "password", PREFIX);
        if(StringUtils.isBlank(password)) {
            throw new Exception("password为空");
        }
        String connectTimeout = ParamsUtil.getValueByKey(args, "connect_timeout", PREFIX);
        String driverPath = ParamsUtil.getValueByKey(args, "driver_path", PREFIX);
        if(StringUtils.isBlank(driverPath)) {
            throw new Exception("driverPath为空");
        }
        String driverClassName = ParamsUtil.getValueByKey(args, "driver_classname", PREFIX);
        if(StringUtils.isBlank(driverClassName)) {
            throw new Exception("driverClassName为空");
        }
        System.out.println("###### 连接信息 ######");
        System.out.println(">>>>>> 数据库地址：" + host);
        System.out.println(">>>>>> 数据库端口：" + port);
        System.out.println(">>>>>> 服务名称：" + serviceName);
        System.out.println(">>>>>> 角色：" + role);
        System.out.println(">>>>>> 用户名：" + userName);
        System.out.println(">>>>>> 密码：" + password);
        System.out.println(">>>>>> 连接超时时间：" + connectTimeout + "毫秒");
        System.out.println(">>>>>> 驱动地址：" + driverPath);
        System.out.println(">>>>>> 驱动类名称：" + driverClassName);
        System.out.println("####################");
        OracleConnectionInfo connectionInfo = new OracleConnectionInfo();
        connectionInfo.setHost(host);
        connectionInfo.setPort(Integer.parseInt(port));
        connectionInfo.setServiceName(serviceName);
        connectionInfo.setRole(role);
        connectionInfo.setUserName(userName);
        connectionInfo.setPassword(password);
        connectionInfo.setConnectTimeout(Long.parseLong(connectTimeout));
        String[] driverPathArray = driverPath.split(";");
        connectionInfo.setDriverPathList(Arrays.asList(driverPathArray));
        connectionInfo.setDriverClassName(driverClassName);
        try {
            System.out.println("开始连接目标数据库......");
            Connection connection = new OracleConnector().connect(connectionInfo);
            if(connection == null) {
                System.out.println("连接失败 :(");
                return;
            }
            System.out.println("连接成功 ^_^");
        } catch (Exception e) {
            System.out.println("连接失败 :(");
            e.printStackTrace();
        }
    }
}