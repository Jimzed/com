package com.qushihan.JDBC;

import org.junit.Test;

import java.sql.*;

public class jdbc {
    public static final String driver_url = "com.mysql.jdbc.Driver";
    // 旧版本5.7以下
    //public static final String connect_url = "jdbc:mysql://127.0.0.1/bz?useUnicode=true&characterEnocding=utf-8";
    // 新版本
    public static final String connect_url = "jdbc:mysql://127.0.0.1/bz?useUnicode=true&characterEnocding=utf-8&useSSL=false";
    public static final String usename = "root";
    public static final String password = "root";

    @Test
    public void query() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.加载驱动进入内存
            Class.forName(driver_url);
            // 2.连接数据库
            connection = DriverManager.getConnection(connect_url, usename, password);
            // 3.执行sql语句:可以有效防止两次执行同一sql，提高性能
            preparedStatement = connection.prepareStatement("select * from hus");
            // 4.遍历数据
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void add() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.加载驱动进入内存
            Class.forName(driver_url);
            // 2.连接数据库
            connection = DriverManager.getConnection(connect_url, usename, password);
            // 3.执行sql语句:可以有效防止两次执行同一sql，提高性能
            int id = 1;
            String name = "mike";
            preparedStatement = connection.prepareStatement("insert into hus(id,name) values(?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            // 4.增加数据
            System.out.println(preparedStatement.executeUpdate() > 0 ? "添加成功" : "添加失败");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void del() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.加载驱动进入内存
            Class.forName(driver_url);
            // 2.连接数据库
            connection = DriverManager.getConnection(connect_url, usename, password);
            // 3.执行sql语句:可以有效防止两次执行同一sql，提高性能
            int id = 1;
            preparedStatement = connection.prepareStatement("delete from hus where id=?");
            preparedStatement.setInt(1, id);
            // 4.删除数据
            System.out.println(preparedStatement.executeUpdate() > 0 ? "删除成功" : "删除失败");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void update() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.加载驱动进入内存
            Class.forName(driver_url);
            // 2.连接数据库
            connection = DriverManager.getConnection(connect_url, usename, password);
            // 3.执行sql语句:可以有效防止两次执行同一sql，提高性能
            int id = 1;
            String name = "tank";
            preparedStatement = connection.prepareStatement("update hus set name=? where id=?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            // 4.更改数据
            System.out.println(preparedStatement.executeUpdate() > 0 ? "更改成功" : "更改失败");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void executeProcedure() {// 执行存储过程
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.加载驱动进入内存
            Class.forName(driver_url);
            // 2.连接数据库
            connection = DriverManager.getConnection(connect_url, usename, password);
            // 3.执行sql语句:可以有效防止两次执行同一sql，提高性能
            int order_num = 20005;
            callableStatement = connection.prepareCall("{call p_2(?,?)}");// 输出参数
            callableStatement.setInt(1, order_num);// 输入参数
            callableStatement.registerOutParameter(2, JDBCType.FLOAT);
            // 4.执行存储过程
            boolean flag = callableStatement.execute();// 是否有结果集
            while (flag) {
                System.out.println("总计：" + callableStatement.getFloat(2));// 取得输出参数
                resultSet = callableStatement.getResultSet();// 取得查询结果集
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("order_num") + "\t" + resultSet.getFloat("item_price"));
                }
                flag = callableStatement.getMoreResults();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void executeFunction() {// 执行函数
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            // 1.加载驱动进入内存
            Class.forName(driver_url);
            // 2.连接数据库
            connection = DriverManager.getConnection(connect_url, usename, password);
            // 3.执行sql语句:可以有效防止两次执行同一sql，提高性能
            int order_num = 20005;
            callableStatement = connection.prepareCall("{?=call f_2(?)}");
            callableStatement.registerOutParameter(1, JDBCType.FLOAT);// 输出参数
            callableStatement.setInt(2, order_num);// 输入参数
            // 4.执行函数
            callableStatement.execute();
            System.out.println("总计：" + callableStatement.getFloat(1));// 取得输出参数
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
