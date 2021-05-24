package com.cos.blog.repository;
import com.cos.blog.model.User;


import javax.persistence.criteria.From;

import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


//@Repository 생략가능 
public interface UserRepository extends JpaRepository<User, Integer> {    //해당 repository는 user가 관리하는 repository, user table의 primary key는 Integer
	
	
	
	
	
 	
}


//JPA Naming 쿼리
	//Select * From user Where usernameWhere =Where username = ?1 AND Password = ?2;
	//User findByUsernameAndPassword(String useranme, String password);
	
	//같은 방법
//	@Query(value = "Select * From user Where usernameWhere =Where username = ?1 AND Password = ?2", nativeQuery = true)
//	User login(String username, String password);