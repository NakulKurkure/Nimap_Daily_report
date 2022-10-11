package com.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.AnswerEntity;

import com.serviceInterface.IListAnswerDto;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Long>{

	Page<IListAnswerDto> findByOrderById(Pageable pagable, Class<IListAnswerDto> class1);

	Page<IListAnswerDto> findByAnswer(String search, Pageable pagable, Class<IListAnswerDto> class1);

	@Transactional
	@Query(value="SELECT * from answer_entity t WHERE t.user_id_id=:user_id_id",nativeQuery = true)
	Optional<AnswerEntity> findByUserId(@Param("user_id_id") Long user_id_id);

//	@Transactional
//	@Query(value="select answerenti0_.id as id1_3_0_, userentity1_.id as col_1_0_, questionen2_.id as id, answerenti0_.answer as answer, userentity1_.id as id, questionen2_.id as id, userentity1_.created_at as created_2_8_0_, userentity1_.email as email3_8_0_, userentity1_.gender as gender4_8_0_, userentity1_.is_active as is_activ5_8_0_, userentity1_.password as password6_8_0_, userentity1_.updated_at as updated_7_8_0_, userentity1_.user_name as user_nam8_8_0_, questionen2_.created_at as created_2_3_1_, questionen2_.description as descript3_3_1_, questionen2_.is_active as is_activ4_3_1_, questionen2_.is_draft as is_draft5_3_1_, questionen2_.is_flag as is_flag6_3_1_, questionen2_.is_publish as is_publi7_3_1_, questionen2_.question as question8_3_1_, questionen2_.updated_at as updated_9_3_1_, questionen2_.user_id_id as user_id from answer_entity answerenti0_ left outer join user_entity userentity1_ on answerenti0_.user_id_id=userentity1_.id left outer join question_entity questionen2_ on answerenti0_.question_id_id=questionen2_.id where ( answerenti0_.is_active=true) and answerenti0_.id=?",nativeQuery  =true)
//	@Query(value="select questionen0_.id as id, questionen0_.created_at as created_2_3_0_, questionen0_.description as description, questionen0_.is_active as is_activ4_3_0_, questionen0_.is_draft as is_draft5_3_0_, questionen0_.is_flag as is_flag, questionen0_.is_publish as is_publi7_3_0_, questionen0_.question as question8_3_0_, questionen0_.updated_at as updated_9_3_0_, questionen0_.user_id_id as user_id_id from question_entity questionen0_ where questionen0_.id=? and ( questionen0_.is_active=true)",nativeQuery = true)
	
	
//	List<IListAnswerDto> findByquestionId(Long id, Class<IListAnswerDto> class1);

	List<IListAnswerDto> findByQuestionIdId(Long id, Class<IListAnswerDto> class1);


//	@Transactional
//	@Query(value="SELECT t.user_id_id,t.answer from answer_entity t where t.question_id_id=:question_id_id",nativeQuery = true)
//	List<IQuestionListDto> findByAnswerAndQuestionId(Long question_id_id);


}