package org.edward.datacat.connector;

import org.edward.datacat.model.ConnectionInfo;

import java.sql.Connection;

public interface DatabaseConnector<C extends ConnectionInfo> {
    Connection connect(C connectionInfo) throws Exception;
}