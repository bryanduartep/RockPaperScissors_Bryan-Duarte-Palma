package ws;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import RPS.DBConnection;
import RPS.DBOperation;
import RPS.FormatTournament;
import RPS.Game;

@Path("/api")
public class WebService {
	
	Game game = new Game();
	FormatTournament formatTournament = new FormatTournament();
	DBConnection dbConnection = new DBConnection();
	DBOperation dbOperation = new DBOperation();
    
//    @GET
//    @Path("/{param}")
//    @Produces(MediaType.TEXT_HTML)
//    public String getSaludoHTML(@PathParam("param") String nombre) {
//        return "<html> " + "<title>" + "Hola Mundo" + "</title>"  
//             + "<body><h1>" + "Hola Mundo en HTML : " + nombre 
//             + "</body></h1>" + "</html> ";
//    }
//    
//    @POST
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getSaludoPlain() {
//    	System.out.println("Hola mundo Hell Yeah!");
//        return "Hola mundo Hell Yeah!"  ;
//    }
    
    @Path("/type/{typegame}")
    @GET   // this method process GET request from client
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public String matchWS(@PathParam("typegame") String typegame) throws UnsupportedEncodingException {  
    	
        return "{'winnerPlayer':'Player1', "
  		+ "'winnerStrategy':'P', "
  		+ "'secondPlayer':'Player2', "
  		+ "'secondStrategy':'R'}";    	
      }
    
    @Path("/reset/{code}")
    @GET   // this method process GET request from client
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public String resetDBWS(@PathParam("code") String code) throws UnsupportedEncodingException {  
    	
        return "{'status':1}";
  		    	
      }
    
    @Path("/topTen/{code}")
    @GET   // this method process GET request from client
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public String topTenWS(@PathParam("code") String code) throws UnsupportedEncodingException {  
    	
        return "[ " +
    		    "{'namePlayer':'Player1', 'pointsPlayer':'30'}, " +
    		    "{'namePlayer':'Player2', 'pointsPlayer':'27'}, " +
    		    "{'namePlayer':'Player3','pointsPlayer': '24'}, " +
    		    "{'namePlayer':'Player4','pointsPlayer': '21'}, " +
    		    "{'namePlayer':'Player5','pointsPlayer': '18'}, " +
    		    "{'namePlayer':'Player6','pointsPlayer': '15'}, " +
    		    "{'namePlayer':'Player7','pointsPlayer': '12'}, " +
    		    "{'namePlayer':'Player8','pointsPlayer': '9'}, " +
    		    "{'namePlayer':'Player9','pointsPlayer': '6'}, " +
    		    "{'namePlayer':'Player10','pointsPlayer': '3'} " +
    		"]";
  		    	
      } 
    
   } 
 

