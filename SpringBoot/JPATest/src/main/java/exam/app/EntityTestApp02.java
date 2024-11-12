package exam.app;

import java.util.List;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTestApp02 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<EntityTest01> tq = manager.createQuery("select t from EntityTest01 t", EntityTest01.class);
		List<EntityTest01> list = tq.getResultList();
		
//		for(EntityTest01 et : list) {
//			System.out.println(et);
//		}
		list.stream().forEach(e -> System.out.println(e));
		
		manager.close();
		factory.close();

	}

}








