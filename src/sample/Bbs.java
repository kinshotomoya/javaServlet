package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;


@WebServlet("/Bbs")
public class Bbs extends HttpServlet {
    private ArrayList<String> list = new ArrayList<>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String content = request.getParameter("message");
        if(content != null) {
            list.add(content);
            printContent(out);
        }
    }

    void printContent(PrintWriter out) {
        out.println("<form action='/HelloServlet1_war_exploded/Bbs' method='post'>");
        out.println("<textarea name='message'></textarea>");
        out.println("<input type='submit' value='submit'></form>)");
        list.stream().forEach( i -> {
            out.println("<p>" + i + "</p>");
        } );
    }
}
