package dto;

import lombok.Data;

@Data
public class ResponseCreateUser{
	private int code;
	private String type;
	private String message;
}