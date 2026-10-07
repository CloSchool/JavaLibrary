package servlets;

import dao.BookDAO;
import entities.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/update")
public class UpdateStatusServlet extends HttpServlet {
    private BookDAO dao = new BookDAO();;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");

            dao.update(id);

            response.sendRedirect(request.getContextPath() + "/list");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/update");
        }
    }
}
