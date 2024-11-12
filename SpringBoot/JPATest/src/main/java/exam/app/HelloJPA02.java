package exam.app;

import java.util.List;

import exam.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class HelloJPA02 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager manager = factory.createEntityManager();

        
        Query query = manager.createQuery("select emp from Emp emp",Emp.class); //JPQL
        List<Emp> list = query.getResultList();
        for(Emp emp : list) {
        	System.out.println(emp.getEname());
        }
        
        System.out.println("데이터 총 개수 = " + list.size());
        
        manager.close();
        factory.close();
	}
}
