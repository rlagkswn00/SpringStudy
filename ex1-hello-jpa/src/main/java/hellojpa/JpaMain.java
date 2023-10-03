package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Member member = new Member();
            member.setName("user");

            em.persist(member);

            em.flush();
            em.clear();
            Member findMember = em.getReference(Member.class, member.getId());

            System.out.println("isLoaded: " + emf.getPersistenceUnitUtil().isLoaded(findMember));
            System.out.println("findMember.getName() = " + findMember.getName());
            Hibernate.initialize(findMember);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
