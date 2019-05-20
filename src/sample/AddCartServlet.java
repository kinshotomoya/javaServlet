package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String productNo = request.getParameter("product_no");
        int no = Integer.parseInt(productNo);
        String productName = null;

        switch (no) {
            case 100:
                productName = "パソコン";
                break;
            case 101:
                productName = "print";
                break;
            case 102:
                productName = "digital camera";
                break;
            default:
                productName = "???";
        }

        // session領域の取得
        // requestから送られてくるから、そっからセッション情報を取得する
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        // セッションオブジェクトに任意の名前のオブジェクトをする。その名前を、productsにして
        // その中で、買い物カート(cart)の中身を保存している
        // sessionオブジェクトは、クライアントごとに割り当てられた領域なので、クライアントごとに情報は違う
        List<String> cart = (ArrayList<String>)session.getAttribute("products");
        if(cart == null) {
            cart =  new ArrayList<String>();
            session.setAttribute("products", cart);
        }

        cart.add(productName);

        out.println("<html><head><title>show cart</title></head></body>");
        out.println("現在のカートの中身は下記の通りです。");
        for(int i = 0; i < cart.size(); i++) {
            out.println(i + 1);
            out.println(":" + cart.get(i) + "<br>");
        }

        out.println("<hr><a href='/HelloServlet1_war_exploded/selectProduct3.html'>list</a>");
        out.println("</body></html>");
    }
}
