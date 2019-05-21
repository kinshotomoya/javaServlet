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


@WebServlet("/insertData")
public class InsertTest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        Connection con;
        ResultSet rs = null;
//        String sql = "select * from emp;";
        String sql = "insert into emp(code, name, age, tel) values (22, 'tomoya', 233, '09-0000-89888')";
        PreparedStatement st = null;
//        String user = "root";
//        String password = "rootpassword";
        // アクセスするデータベースのURL
        String url = "jdbc:mysql://localhost:3314/sample?user=root&password=rootpassword";
        try{
            // ドライバの登録
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url);
            st = con.prepareStatement(sql);
            // selectするとき
            // rs = st.executeQuery();
            // insertするとき
            int rows = st.executeUpdate();
            st.close();
            con.close();
//            while(rs.next()) {
//                int id = rs.getInt("code");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                String tel = rs.getString("tel");
//                sb.append("id" + id + "name" + name + "age" + age + "tel" + tel);
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().append(sb);
    }
}
