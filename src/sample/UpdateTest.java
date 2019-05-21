package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/updateTest")
public class UpdateTest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con;
        PreparedStatement ps = null;
        try {
            String url = "jdbc:mysql://localhost:3314/sample?user=root&password=rootpassword";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url);
            String sql = "update emp set age=3333 where code=1";
            PreparedStatement st = con.prepareStatement(sql);
            int rows = st.executeUpdate();
            st.close();
            con.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
