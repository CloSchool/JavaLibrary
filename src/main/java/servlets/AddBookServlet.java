package servlets;

import dao.BookDAO;
import entities.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/add")
public class AddBookServlet extends HttpServlet {
    private BookDAO dao = new BookDAO();;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String yearStr = request.getParameter("year");
        String availableStr = request.getParameter("available");

        try {
            int year = Integer.parseInt(yearStr);
            boolean available = Boolean.parseBoolean(availableStr);

            Book book = new Book(title, author, year, !available);

            dao.add(book);

            response.sendRedirect(request.getContextPath() + "/list");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/add");
        }
    }
}
