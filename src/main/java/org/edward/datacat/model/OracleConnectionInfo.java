package org.edward.datacat.model;

public class OracleConnectionInfo extends ConnectionInfo {
    private String serviceName;
    private String role;

    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}