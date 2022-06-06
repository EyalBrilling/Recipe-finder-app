package network;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpClient.*;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.*;
import java.time.Duration;

import org.json.JSONObject;

import java.io.*;
public class Client {

    private HttpClient httpClient;
    
    
    public void startConnection(String ip, int port) {
    	httpClient = HttpClient.newBuilder().version(Version.HTTP_1_1)
    	        .followRedirects(Redirect.NORMAL)
    	        .connectTimeout(Duration.ofSeconds(100))
    	        .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
    	        .build();
        
    }

    public JSONObject SendRecipeUpdate(JSONObject request) throws URISyntaxException, IOException, InterruptedException {
    	HttpRequest httpRequestRecipes= HttpRequest.newBuilder()
    			.uri(new URI("http://localhost:8000/recipes"))
    			.POST(HttpRequest.BodyPublishers.ofString(request.toString())).build();
    	HttpResponse<String> response = httpClient.send(httpRequestRecipes, BodyHandlers.ofString());
    	JSONObject responseJsonObject = new JSONObject(response);
    	return responseJsonObject;
    }
    
    public JSONObject SendNewUser(JSONObject request) throws URISyntaxException, IOException, InterruptedException {
    	HttpRequest httpRequestUpdateUser= HttpRequest.newBuilder()
    			.uri(new URI("http://localhost:8000/users"))
    			.POST(HttpRequest.BodyPublishers.ofString(request.toString())).build();
    	HttpResponse<String> response = httpClient.send(httpRequestUpdateUser, BodyHandlers.ofString());
    	JSONObject responseJsonObject = new JSONObject(response);
    	return responseJsonObject;
    }
    
    public JSONObject GetRecipes(JSONObject request) throws URISyntaxException, IOException, InterruptedException {
    	HttpRequest httpRequestGetRecipes= HttpRequest.newBuilder()
    			.uri(new URI("http://localhost:8000/recipes"))
    			.POST(HttpRequest.BodyPublishers.ofString(request.toString())).build();
    	HttpResponse<String> response = httpClient.send(httpRequestGetRecipes, BodyHandlers.ofString());
    	JSONObject responseJsonObject = new JSONObject(response);
    	return responseJsonObject;
    }
    public JSONObject GetUser(JSONObject request) throws URISyntaxException, IOException, InterruptedException {
    	HttpRequest httpRequesGetUser= HttpRequest.newBuilder()
    			.uri(new URI("http://localhost:8000/recipes"))
    			.POST(HttpRequest.BodyPublishers.ofString(request.toString())).build();
    	HttpResponse<String> response = httpClient.send(httpRequesGetUser, BodyHandlers.ofString());
    	JSONObject responseJsonObject = new JSONObject(response);
    	return responseJsonObject;
    }
    

}

