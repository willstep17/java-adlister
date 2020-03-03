import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ItemsShoppingCartServlet", urlPatterns = "/items/cart")
public class ItemsShoppingCartServlet extends HttpServlet {
    List<Item> shoppingCart = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int priceInCents = Integer.parseInt(request.getParameter("priceInCents"));
        shoppingCart.add(new Item(id, name, priceInCents));
        response.sendRedirect("/items/store");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalCost = 0;
        for(Item item : shoppingCart) {
            totalCost += item.getPriceInCents();
        }
        String totalCostString = centsToDollars(totalCost);
        request.setAttribute("totalCost", totalCostString);
        request.setAttribute("shoppingCart", shoppingCart);
        request.getRequestDispatcher("../WEB-INF/items/cart.jsp").forward(request, response);
    }

    protected String centsToDollars(int costInCents) {
        String returnDollars = Integer.toString(costInCents);
        if(returnDollars.length() > 2) {
            returnDollars = new StringBuilder(returnDollars).insert(returnDollars.length() -2,".").insert(0, "$").toString();
        }
        return returnDollars;
    }
}
