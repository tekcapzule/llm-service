package com.tekcapsule.llm.domain.repository;

import com.tekcapsule.core.domain.CrudRepository;
import com.tekcapsule.llm.domain.model.LLM;

import java.util.List;

public interface LLMRepository extends CrudRepository<LLM, String> {

    List<LLM> findAllByTopicCode(String topicCode);
}
