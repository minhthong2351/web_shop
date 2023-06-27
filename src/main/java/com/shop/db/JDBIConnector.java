package com.shop.db;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;

import static com.shop.db.DBProperties.*;

public class JDBIConnector {
    private static Jdbi jdbi;

    private static void makeConnect(){
        MysqlDataSource dataSource= new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://"+ getDbHost()+":"+getDbPort()+"/"+getDbName());
        dataSource.setUser(getUsername());
        dataSource.setPassword(getPassword());
        try {
            dataSource.setUseCompression(true);
            dataSource.setAutoReconnect(true);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        jdbi=jdbi.create(dataSource);
    }
    private JDBIConnector(){
    }
    public static Jdbi get(){
        if(jdbi==null) makeConnect();
        return jdbi;

    }
}
