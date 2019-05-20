package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String USER = "tomoya";
    private static final String PASS = "kinsho";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if(action.equals("login")) {
            // ログイン時
            String name = request.getParameter("name");
            String passWord = request.getParameter("pw");
            if(name.equals(USER) && passWord.equals(PASS)) {
                // name passwordが共にあっているとき
                // session管理を行う
                HttpSession session = request.getSession();
                session.setAttribute("isLogin", "true");
                out.println("<h1>ログインしました</h1>");
            } else {
                out.println("ユーザー名、パスワードが違います");
            }
        } else if(action.equals("logout")){
            // ログアウト時
            HttpSession session = request.getSession(false); // falseを指定するとすでに作成済みのsessionを取得する
            if(session != null) {
                 // sessionを無効にする
                session.invalidate();
                out.println("ログアウトしました");
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}
