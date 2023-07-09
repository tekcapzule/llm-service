package com.tekcapsule.llm.domain.service;

import com.tekcapsule.llm.domain.command.CreateCommand;
import com.tekcapsule.llm.domain.command.UpdateCommand;
import com.tekcapsule.llm.domain.model.LLM;

import java.util.List;


public interface LLMService {

    void create(CreateCommand createCommand);

    void update(UpdateCommand updateCommand);

    List<LLM> findAll();

    List<LLM> findAllByTopicCode(String code);
}
