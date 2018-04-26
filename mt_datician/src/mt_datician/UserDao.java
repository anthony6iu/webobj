package mt_datician;

import java.sql.*;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import mt_datician.User;

public class UserDao {

    User user = null;
    private String SQL =""; 
    public User login(String username, String password){
        SQL = "select * from mt_aa_users where username = ? and password = ?";
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBDao.getConnection();
            pstmt = (PreparedStatement) connection.prepareStatement(SQL);
            //这里的意思将用户名和密码填到SQL语句的问号处
            // next 2 lines: replace ? in SQL by username and password.
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rSet = (ResultSet) pstmt.executeQuery();//得到数据库的查询结果,一个数据集
            //判断结果集是否有效
            if(rSet.next()){
                user = new User();
                user.setUsername(rSet.getString("username"));
                user.setPassword(rSet.getString("password"));
            }
            connection.close();
            pstmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            DBDao.closeConnection(connection);
        }
        return user;
    }

}
