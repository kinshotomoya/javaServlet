package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyMessageServlet")
public class MyMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("message");
        String size = request.getParameter("size");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(size.equals("big")) {
            out.println("<h1>" + content + "</h1>");
        } else if (size.equals("middle")) {
            out.println("<h2>" + content + "</h2>");
        } else {
            out.println("<h3>" + content + "</h3>");
        }
    }
}
