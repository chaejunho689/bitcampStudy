package exam.app;

import java.util.List;

import exam.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class HelloJPA03 {
	public static void main(String[] args) throws InterruptedException {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
    EntityManager manager = factory.createEntityManager();

    Query query = manager.createQuery("select emp from Emp emp",Emp.class); //JPQL
    List<Emp> list = query.getResultList();
    
    for(Emp emp : list) {
    	System.out.println("직원명 : " + emp.getEname());
    
    	if(emp.getDeptno() != null) {
    		System.out.println("부서명 : " + emp.getDeptno().getDname());
    	}
    	else {
    		System.out.println("부서명이 없습니다.");
    	}
    };
    
    manager.close();
    factory.close();
	}
}
