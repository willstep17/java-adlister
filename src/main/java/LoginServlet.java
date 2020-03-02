import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean user = false;
        if(null == request.getSession().getAttribute("user")) {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        } else {
            user = (boolean) request.getSession().getAttribute("user");
        }

        if(user) {
            request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            request.getSession().setAttribute("user", true);
            request.getSession().setAttribute("username", username);
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
