/*package com.cni.autoecole.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cni.autoecole.entities.Answer;
import com.cni.autoecole.entities.Question;
import com.cni.autoecole.entities.repositories.QuestionRepository;


public class QuestionServiceImpl  
{

	
	@Autowired
	private QuestionRepository questionRepository;
	/*@Override
	public Iterable<Question> findAll() {
		
		return questionRepository.findAll();
	}
	@Override
	public int findAnswerIdCorrect(int questionId) {
		Question question  = questionRepository.findById(questionId).get();
		for(Answer answer : question.getAnswers()) {
			if(answer.isCorrect()) {
				return answer .getId();
			}}
		return -1;
		
	}*/


