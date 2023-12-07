package com.project.questapp2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp2.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);//jpa repositorynin sağladığı interface, findBy'dan sonra objenin içerisinde kalan herhangi bir alanla birleştirebilirsiniz
	//findByTitle, findByText..


}
