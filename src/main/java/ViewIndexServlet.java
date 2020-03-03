import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ViewIndexServlet", urlPatterns = "/")
public class ViewIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("loginStatus", "Log In");
        request.getSession().setAttribute("loginStatusAction", "/login");
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
