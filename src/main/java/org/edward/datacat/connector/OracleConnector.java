package org.edward.datacat.connector;

import org.edward.datacat.model.OracleConnectionInfo;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class OracleConnector implements DatabaseConnector<OracleConnectionInfo> {
    @Override
    public Connection connect(OracleConnectionInfo connectionInfo) throws Exception {
        String userName = connectionInfo.getUserName();
        String role = connectionInfo.getRole();
        if("sysdba".equalsIgnoreCase(role)) {
            userName = userName + " as sysdba";
        } else if("sysoper".equalsIgnoreCase(role)) {
            userName = userName + " as sysoper";
        }
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("user", userName);
        connectionProperties.setProperty("password", connectionInfo.getPassword());
        connectionProperties.setProperty("connectTimeout", String.valueOf(connectionInfo.getConnectTimeout()));
        URL driverPath = new URL("file:///"+connectionInfo.getDriverPath());
        URLClassLoader driverClassLoder = new URLClassLoader(new URL[]{driverPath});
        Class<?> driverClass = driverClassLoder.loadClass(connectionInfo.getDriverClassName());
        Driver driver = (Driver) driverClass.newInstance();
        return driver.connect("jdbc:oracle:thin:@//"+connectionInfo.getHost()+":"+connectionInfo.getPort()+"/"+connectionInfo.getServiceName(), connectionProperties);
    }
}