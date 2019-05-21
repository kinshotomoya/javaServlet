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
import java.sql.ResultSet;


@WebServlet("/searchDb")
public class SearchDb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con;
        String url = "jdbc:mysql://localhost:3314/sample?user=root&password=rootpassword";
        StringBuffer sb = new StringBuffer();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url);
            String sql = "select * from emp where name like '%to%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("code");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String tel = rs.getString("tel");
                sb.append("id" + id + "name" + name + "age" + age + "tel" + tel + "sss");
            }
            ps.close();
            con.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
