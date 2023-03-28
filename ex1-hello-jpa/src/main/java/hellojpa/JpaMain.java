package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            //영속 상태
//            em.persist(member);
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember = " + findMember);
//            em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("findMember2 = " + findMember2);
//
//            System.out.println("result= " + (findMember == findMember2));
//            Member member = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member2);
//            em.persist(member);
//            System.out.println("===============+");
            Member member = new Member();
            member.setUsername("AAAAA");
            member.setAge(10);
            member.setDescription("AAAAAAAA");
            member.setRoleType(RoleType.USER);

            //JPA에서 관리를 하지 않기에 업데이트 되지 않음g
            em.persist(member);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
