package br.edu.utfpr.pb.tcc.security.model;

public class AuthenticationResponse {
	
	private String token;

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
