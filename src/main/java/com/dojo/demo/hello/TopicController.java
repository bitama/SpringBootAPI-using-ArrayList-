package com.dojo.demo.hello;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TopicController {
	@Autowired
	private TopicService topicservice;
	
	
	
	public TopicController(TopicService topicservice) {
		super();
		this.topicservice = topicservice;
	}
	@RequestMapping("/topics")
	public List<Topic> getTopics(){
		return topicservice.getAllTopics();
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicservice.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public  void createTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic);
		
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public  void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicservice.addTopic(id,topic);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public  void deleteTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicservice.deleteTopic(id);
		
	}
	
}