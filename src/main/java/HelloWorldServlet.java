import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String input = request.getParameter("input");
        if(input.equals("first")) {
            response.getWriter().println("<h1>First</h1>");
        } else if(input.equals("second")) {
            response.getWriter().println("<h1>Second</h1>");
        } else {
            response.getWriter().println("<h1>Hello, World!</h1>");
        }
    }
}
