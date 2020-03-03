import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ItemsStoreServlet", urlPatterns = "/items/store")
public class ItemsStoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("items", DaoFactory.getItemsDao().all());
        request.getRequestDispatcher("../WEB-INF/items/store.jsp").forward(request, response);
    }
}