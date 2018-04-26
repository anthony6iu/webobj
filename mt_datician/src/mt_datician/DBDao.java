package mt_datician;


import java.sql.*;
public class DBDao {
    private static String USER = "root";
    private static String PASSWORD = "root";
    private static String DB_URL = "jdbc:mysql://localhost:3306/mt_bdzh";
    private static String DB_DRIVER = "com.mysql.jdbc.Driver";
//  private static String SQL = "";
    private static Connection connection = null;

    //connect database
    public static Connection getConnection(){
    	//System.out.println("-------1-11111-1-1-1-1-1-1-1---------");

        try {
            Class.forName(DB_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("数据库连接异常");
            System.out.println("MYSQL ERROR:" + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
    public  static void closeConnection(Connection connection){

                    if(connection != null){
                        try {
                            connection.close(); // close database connection
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
    }