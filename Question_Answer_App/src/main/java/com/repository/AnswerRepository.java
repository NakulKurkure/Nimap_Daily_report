package com.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.AnswerEntity;
import com.entity.QuestionEntity;
import com.entity.UserRoleEntity;
import com.serviceInterface.IAnswerListDto;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Long>{

	Page<IAnswerListDto> findByOrderById(Pageable pagable, Class<IAnswerListDto> class1);

	Page<IAnswerListDto> findByAnswer(String search, Pageable pagable, Class<IAnswerListDto> class1);

	@Transactional
	@Query(value="SELECT * from answer_entity t WHERE t.user_id_id=:user_id_id",nativeQuery = true)
	Optional<AnswerEntity> findByUserId(@Param("user_id_id") Long user_id_id);




}
