package br.com.example;

import java.io.IOException;
import java.net.URI;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {
	
	final static Logger logger = Logger.getLogger(Server.class);
	
    public static void main( String[] args ) throws IOException {
    	BasicConfigurator.configure();
    	
    	HttpServer server = initializeServer();
		System.in.read(); // enter to stop server
		server.shutdown();
		logger.info("Server stopped");
    }
    
    static HttpServer initializeServer() {
		URI uri = URI.create("http://localhost:8080/");
		ResourceConfig config = new ResourceConfig().packages("br.com.example");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		logger.info("Server started");
		
		return server;
	}
    
}
