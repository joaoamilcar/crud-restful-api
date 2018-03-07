package br.com.example.resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import br.com.example.dao.SampleEntityDAO;
import br.com.example.model.SampleEntity;

@Path("sampleentities")
public class SampleEntityResource {
	
	private Gson gson = new Gson();
	final static Logger logger = Logger.getLogger(SampleEntityResource.class);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("name/{nameParam}/date/{dateParam}")
	public String create(@PathParam("nameParam") String name, @PathParam("dateParam") String date) {
		SampleEntity sampleEntity = new SampleEntity();
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			calendar.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		sampleEntity.setName(name);
		sampleEntity.setCreation(calendar);
		
		try {
			new SampleEntityDAO().insert(sampleEntity);
			logger.info("insertion performed");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}		
		
		return gson.toJson(sampleEntity);
	}
	
}
