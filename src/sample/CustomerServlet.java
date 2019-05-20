package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String call = request.getParameter("call");
        String UrlQuery = request.getParameter("action");

        HttpSession session = request.getSession();
        List<String> customerArray = (ArrayList<String>)session.getAttribute("customerInfo");
        if(UrlQuery != null) {
            // getのとき（情報確認ボタンを押した場合）
            if(customerArray == null) {
                printContext(out, "先に登録しろよ！");
            } else {
                printInfo(out, customerArray);
            }

        } else {
            if(customerArray == null) {
                // sessionの中に、customerInfoオブジェクトがない場合
                // 新しく、customerInfoを格納するリストを作って、セッションにセットする
                customerArray = new ArrayList<>();
                session.setAttribute("customerInfo", customerArray);
            }

            customerArray.add(name);
            customerArray.add(address);
            customerArray.add(call);
            printContext(out, "登録完了しました！");
        }
    }

    private void printContext(PrintWriter out, String displaycontext) {
        out.println(displaycontext);
    }

    private void printInfo(PrintWriter out, List customerArray) {
        customerArray.stream().forEach( info -> {
            out.print(info);
        } );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }
}
