package mt_datician;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;

//import java.sql.*;
import mt_datician.UserDao;
import mt_datician.User;
public class Servlet extends HttpServlet {
	

    //private static final long serialVersionUID = 1L;
    //private final String USERNAME = "hliu3";
    //private final String PASSWORD = "123";

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException {

        // get username and password.
        String username = req.getParameter("uname");

        String password = req.getParameter("pword");
        PrintWriter pw = resp.getWriter();
        // get UserDao instance
        UserDao userDao = new UserDao();

        User user = userDao.login(username,password);
        // condition: user is empty or not.
        if(user != null){
        	pw.write("username and password is right!");
        	//req.getRequestDispatcher("../loginsuccess/LoginSuccess.html").forward(req, resp);
        }else
        {
            pw.write("username or password is wrong!");
        }
    	//doPost(req, resp);
    }
    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	doGet(req,resp);


/*
    Follow parts is meanless.
 */
/*
        String uname = req.getParameter("uname");
        String pword = req.getParameter("pword");
        PrintWriter pw = resp.getWriter();
*/
/*
        String sql = "Select password From mt_aa_users Where username =";
        //create user by User class
        try{
        	User user = null;
        	user.setUsername(uname);
        	user.setPassword(pword);
        	Connection connection = null;
        	connection = Database.getConnection();
    
        	Statement st = null;
        	connection.createStatement();
        	ResultSet rs= st.executeQuery(sql+"'"+user.getUsername()+"'");
        
        	String rss = rs.getString(1); 
        	
*/
/*  
        if(USERNAME.equals(uname) && PASSWORD.equals(pword))
        //if(rss==user.getPassword())
        {
            pw.write("username and password is right!");
        }else
        {
            pw.write("username or password is wrong!");
        }


*/
    }


}