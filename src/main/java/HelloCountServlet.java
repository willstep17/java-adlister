import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloCountServlet", urlPatterns = "/hello/count")
public class HelloCountServlet extends HttpServlet {
    private int counter = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String reset = request.getParameter("reset");
        if(reset != null) {
            System.out.println("Counter has been reset.");
            counter = 0;
        }
        counter += 1;
        out.println("<h1>The count is " + counter + ".</h1>");
    }
}