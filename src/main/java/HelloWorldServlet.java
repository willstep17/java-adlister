import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        if(name == null || name.equals("") || name.equals(" ")) {
            out.println("<h1>Hello, World!</h1>");
        }else if (name.equals("test")) {
            out.println("<h1>Hello, Test (else if)</h1>");
        } else {
            out.println("<h1>Hello, "+ name + "!</h1>");
        }
        counter += 1;
        out.println("<h1>The count is " + counter + ".</h1>");
    }
}
