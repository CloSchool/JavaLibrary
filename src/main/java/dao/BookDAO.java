package dao;

import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class BookDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookPU");

    public List<Book> list() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("FROM Book", Book.class).getResultList();
        } catch (Exception e) {
            return List.of();
        }
    }

    public boolean add(Book book) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
