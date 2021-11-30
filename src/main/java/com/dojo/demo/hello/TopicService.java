package com.dojo.demo.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	
	public TopicService(TopicRepository topicRepository) {
		super();
		this.topicRepository = topicRepository;
	
	}


	public List<Topic>topics= new ArrayList<>(Arrays.asList(
			
			new Topic("Python","Django","Django Framework"),
			new Topic("Java","Spring","Spring Framework"),
			new Topic("Javascript","React","React Framework"),
			new Topic("Python","Flask","Flask Framework"),
			new Topic("Javascript","Node","Node Framework"),
			new Topic("CSS","Bootstrap","bootstrap Framework"),
			new Topic("HTM","XML","XML Framework")
			));
	
	public List<Topic>getAllTopics(){
		return topics;
	}
	
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get(); 
	}


	public void addTopic(Topic topic) {
		topics.add(topic);
		
		
	}


	public void addTopic(String id, Topic topic) {
		for(int i =0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i,topic);
				return ;
			}
		}
		
	}


	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
		
		
	}
}
	
	
	
	