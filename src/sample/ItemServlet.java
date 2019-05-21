package sample;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// controllerの役割
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // modelを利用してitemを取得する
            ItemDAO dao = new ItemDAO();
            List<ItemBean> list = dao.findAll();

            // 取得したitemをrequestスコープに格納して、showItem.jspで表示する
            req.setAttribute("items", list);
            RequestDispatcher rd = req.getRequestDispatcher("/showItem.jsp");
            rd.forward(req, resp);
        } catch(DAOException e) {
            e.printStackTrace();
            req.setAttribute("message", "内部エラーが発生しました");
            RequestDispatcher rd= req.getRequestDispatcher("/errInternal.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
