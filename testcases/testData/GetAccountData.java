package testData;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetAccountData {
	public static GetAccountData get(String filename) throws JsonParseException,JsonMappingException,IOException{
	ObjectMapper mapper = new ObjectMapper();
	return mapper.readValue(new File(filename), GetAccountData.class);
	}
	
	@JsonProperty("firstname")
	String firstname;
	
	@JsonProperty("lastname")
	String latsname;
	
	@JsonProperty("email")
	String email;
	
	@JsonProperty("password")
	String password;
	
	public String getFirstName() {
		return firstname;
	}
	public String getLastName() {
		return latsname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
}
