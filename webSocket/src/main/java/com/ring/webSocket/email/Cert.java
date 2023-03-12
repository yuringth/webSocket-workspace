package com.ring.webSocket.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @Builder @AllArgsConstructor
public class Cert {
	
	private String who;
	private String secret;
	private String when;

}
