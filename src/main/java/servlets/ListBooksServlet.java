package servlets;

import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/list")
public class ListBooksServlet extends HttpServlet {
    private BookDAO dao = new BookDAO();;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("books", dao.list());
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
