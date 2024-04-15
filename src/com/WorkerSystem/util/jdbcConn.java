package com.WorkerSystem.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class jdbcConn {

    public static Connection getConnection() throws Exception{
        //加载配置文件
        Properties prop = new Properties();

        //加载druid对象
        prop.load(new FileInputStream("D:/Test/src/druid.properties"));

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);//传入properties对象  资源对象

        Connection conn = dataSource.getConnection();

        return conn;
    }
}
