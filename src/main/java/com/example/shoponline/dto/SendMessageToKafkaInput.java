package com.example.shoponline.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageToKafkaInput {
	private String topic;
	private String message;
}
