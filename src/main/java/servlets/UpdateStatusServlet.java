package servlets;

import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/update")
public class UpdateStatusServlet extends HttpServlet {
    private BookDAO dao = new BookDAO();;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
