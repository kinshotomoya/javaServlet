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

@WebServlet("/insertDb")
public class InsertDb extends HttpServlet {
    protected void doGet(HttpServletRequest requestm, HttpServletResponse response) throws ServletException, IOException {
        Connection con;
        String url = "jdbc:mysql://localhost:3314/sample?user=root&password=rootpassword";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "insert into emp(code, name) values (222, 'tooooo')";
            con = DriverManager.getConnection(url);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("add data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
