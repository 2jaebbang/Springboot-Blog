package com.cos.blog.repository;
import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository 생략가능 
public interface UserRepository extends JpaRepository<User, Integer> {    //해당 repository는 user가 관리하는 repository, user table의 primary key는 Integer
	
}
