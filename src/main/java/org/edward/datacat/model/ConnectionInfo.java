package org.edward.datacat.model;

import java.util.List;

public class ConnectionInfo {
    private String host;
    private int port;
    private String userName;
    private String password;
    private long connectTimeout;
    private List<String> driverPathList;
    private String driverClassName;

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getConnectTimeout() {
        return connectTimeout;
    }
    public void setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }
    public List<String> getDriverPathList() {
        return driverPathList;
    }
    public void setDriverPathList(List<String> driverPathList) {
        this.driverPathList = driverPathList;
    }
    public String getDriverClassName() {
        return driverClassName;
    }
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}