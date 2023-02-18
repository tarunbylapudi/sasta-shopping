package com.team.sastashoppingbackend.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionPayload extends Exception {
	private String error;
	private int code;
	private Date timeStamp;
}
