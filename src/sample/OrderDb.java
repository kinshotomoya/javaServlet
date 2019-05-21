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


@WebServlet("/orderDb")
public class OrderDb extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con;
        StringBuffer sb = new StringBuffer();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String url = "jdbc:mysql://localhost:3314/sample?user=root&password=rootpassword";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url);
            String sql = "select * from emp order by age";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("code");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String tel = rs.getString("tel");
                sb.append("id" + id + "name" + name + "age" + age + "tel" + tel + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().append(sb);
    }
}
