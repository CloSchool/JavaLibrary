package dao;

import entities.Book;
import jakarta.persistence.*;

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
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(book);
            transaction.commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(String id) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            Book book = em.find(Book.class, id);
            book.setAvailable(!book.isAvailable());

            transaction.commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
