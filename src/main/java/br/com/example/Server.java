package br.com.example;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {
	
    public static void main( String[] args ) throws IOException {
    	HttpServer server = initializeServer();
		System.in.read(); // enter to stop server
		System.out.println();
		server.shutdown();
		System.out.println("Server stopped");
    }
    
    static HttpServer initializeServer() {
		URI uri = URI.create("http://localhost:8080/");
		ResourceConfig config = new ResourceConfig().packages("br.com.example");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		System.out.println("Server started");
		return server;
	}
    
}
