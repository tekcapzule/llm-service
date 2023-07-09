package com.tekcapsule.llm.domain.service;

import com.tekcapsule.llm.domain.command.CreateCommand;
import com.tekcapsule.llm.domain.command.UpdateCommand;
import com.tekcapsule.llm.domain.model.LLM;
import com.tekcapsule.llm.domain.model.Status;
import com.tekcapsule.llm.domain.repository.LLMRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class LLMServiceImpl implements LLMService {
    private LLMRepository LLMRepository;

    @Autowired
    public LLMServiceImpl(LLMRepository LLMRepository) {
        this.LLMRepository = LLMRepository;
    }

    @Override
    public void create(CreateCommand createCommand) {

        log.info(String.format("Entering create LLM service - Module Code :%s", createCommand.getTopicCode()));

        LLM llm = LLM.builder()
                .title(createCommand.getTitle())
                .topicCode(createCommand.getTopicCode())
                .author(createCommand.getAuthor())
                .publisher(createCommand.getPublisher())
                .duration(createCommand.getDuration())
                .courseUrl(createCommand.getCourseUrl())
                .summary(createCommand.getSummary())
                .description(createCommand.getDescription())
                .modules(createCommand.getModules())
                .prizingModel(createCommand.getPrizingModel())
                .deliveryMode(createCommand.getDeliveryMode())
                .learningMode(createCommand.getLearningMode())
                .imageUrl(createCommand.getImageUrl())
                .promotion(createCommand.getPromotion())
                .status(Status.ACTIVE)
                .build();

        llm.setAddedOn(createCommand.getExecOn());
        llm.setAddedBy(createCommand.getExecBy().getUserId());

        LLMRepository.save(llm);
    }

    @Override
    public void update(UpdateCommand updateCommand) {

        log.info(String.format("Entering update LLM service - LLM ID:%s", updateCommand.getCourseId()));

        LLM llm = LLMRepository.findBy(updateCommand.getCourseId());
        if (llm != null) {
            llm.setTitle(updateCommand.getTitle());
            llm.setTopicCode(updateCommand.getTopicCode());
            llm.setAuthor(updateCommand.getAuthor());
            llm.setPublisher(updateCommand.getPublisher());
            llm.setDuration(updateCommand.getDuration());
            llm.setCourseUrl(updateCommand.getCourseUrl());
            llm.setSummary(updateCommand.getSummary());
            llm.setDescription(updateCommand.getDescription());
            llm.setModules(updateCommand.getModules());
            llm.setPrizingModel(updateCommand.getPrizingModel());
            llm.setDeliveryMode(updateCommand.getDeliveryMode());
            llm.setLearningMode(updateCommand.getLearningMode());
            llm.setPromotion(updateCommand.getPromotion());
            llm.setImageUrl(updateCommand.getImageUrl());
            llm.setUpdatedOn(updateCommand.getExecOn());
            llm.setUpdatedBy(updateCommand.getExecBy().getUserId());
            LLMRepository.save(llm);
        }
    }

    @Override
    public List<LLM> findAll() {

        log.info("Entering findAll LLM service");

        return LLMRepository.findAll();
    }

    @Override
    public List<LLM> findAllByTopicCode(String topicCode) {

        log.info(String.format("Entering findAllByTopicCode LLM service - Module code:%s", topicCode));

        return LLMRepository.findAllByTopicCode(topicCode);
    }


}
