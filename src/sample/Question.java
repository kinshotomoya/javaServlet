package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Question")
public class Question extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String number = request.getParameter("q");
        int numInt = Integer.parseInt(number);
        if(numInt == 1) {
            out.println("<p>正解</p>");
        } else {
            out.println("<p>ちゃんと答えろ！！！</p>");
        }
    }
}
