package sample;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/PlusServlet")
public class PlusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String num1 = request.getParameter("value1");
        String num2 = request.getParameter("value2");

        int i1 = Integer.parseInt(num1);
        int i2 = Integer.parseInt(num2);
        int answer = i1 + i2;

        PlusBean bean = new PlusBean(i1, i2, answer);
        request.setAttribute("plus", bean);

        RequestDispatcher rd = request.getRequestDispatcher("/answer.jsp");
        rd.forward(request, response);


    }

}
