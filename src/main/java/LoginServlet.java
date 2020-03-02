import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if ((request.getParameter("username") != null && request.getParameter("username").equals("admin")) &&
            (request.getParameter("password") != null && request.getParameter("password").equals("password"))) {
            response.sendRedirect("/profile.jsp");
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
