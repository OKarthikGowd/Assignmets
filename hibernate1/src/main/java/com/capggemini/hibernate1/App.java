package com.capggemini.hibernate1;

import com.capgemini.dto.Captain;
import com.capgemini.dto.Team;
import com.capggemini.hibernate1.dao.AssosiationDao;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Captain captain= new Captain();
        captain.setName("ronaldo");
        captain.setAge(36L);
        captain.setJersyname("7");             //https://localhost:5432/
        captain.setNoMatchedPlayed(200L);
        Team team= new Team();                //protocol://Domainname:portnumber/path?QueryString#fragment id
        team.setName("Portuguese foodball");
        team.setTeamtype("Football");
        team.setCountry("Portugal");
        team.setCaptain(captain);
        
        AssosiationDao dao= new AssosiationDao();
      //  dao.saveTeamDetails(team);
       
      
       dao.deleteTeamDetails(team);
        
    }
}
