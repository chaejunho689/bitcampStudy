package exam.app;

import java.util.List;

import exam.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntityTestApp03 {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        
        Person person1 = new Person();
        person1.setName("홍길동");
        person1.setAge(25);
        
        Person person2 = new Person();
        person2.setName("이제훈");
        person2.setAge(40);
        
        Person person3 = new Person();
        person3.setName("김태리");
        person3.setAge(32);
        
        manager.persist(person1);
        manager.persist(person2);
        manager.persist(person3);
        
        TypedQuery<Person> query = manager.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> list = query.getResultList();
        list.stream().forEach(System.out::println);
        
        manager.getTransaction().commit();
        manager.close();
        factory.close();
	}

}

/*
[문제] Person 테이블의 엔티티 객체를 생성한 다음 3개의 데이터 입력 후 모두 조회하시오
테이블 : Person
컬럼 : seq(기본키), name, age
데이터 : "홍길동", 25
       "이제훈", 40
       "김태리", 32
*/

