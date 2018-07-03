package com.spring.db;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.model.Task;
import com.spring.model.Team;
import com.spring.model.TeamSkill;



public class DBConnection {

	/**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
	
	private static String jdbcType = "jdbc:sqlite:";
	private static String fileName = "TM.db";
        
    public static String getDBPath(String jdbcType, String fileName) {
    	String path = "E:\\work\\TM\\";
    	/*try {
    		URL r = DBConnection.class.getResource("");
    		path = URLDecoder.decode(r.getFile(), "UTF-8");
    		
    		if(path.startsWith("/")) {
    			path.replaceFirst("/", "");
    		}
    	}catch(UnsupportedEncodingException e) {
    		System.out.println(e);
    		
    	}*/
    	
    	return jdbcType+path+fileName;
    }
      
    public List<String> getTeamData() {
    	Connection conn = null;
    	List<String> lstTeam = new ArrayList<String>();
    	ResultSet rs = null; 
    	Statement stmt = null;
    	StringBuffer sb  = new StringBuffer();
    	String url = getDBPath(jdbcType, fileName);
        try {
        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection(url);
        	sb.append("SELECT * FROM TEAM");
            if (conn != null) {
            	stmt = conn.createStatement();//(sb.toString());
            	//stmt.setString(1, expert);
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                 rs = stmt.executeQuery(sb.toString() );
                while (rs.next()) {
                	String teamID = rs.getString("TEAM_ID");
                	System.out.println("teamID: "+teamID);
                	lstTeam.add(teamID);
                }
            }
 
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
        	try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
		}
    	return lstTeam;
    }
    
    public String updateTeam(Team team) {
    	Connection conn = null;
    	List<String> lstTeam = new ArrayList<String>();
    	ResultSet rs = null; 
    	Statement stmt = null;
    	StringBuffer sb  = new StringBuffer();
    	String url = getDBPath(jdbcType, fileName);
    	int res=0;
        try {
        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection(url);
        	sb.append("INSERT INTO TEAM VALUES('"+team.getTEAM_ID()+"')");
            if (conn != null) {
            	stmt = conn.createStatement();//(sb.toString());
            	//stmt.setString(1, expert);
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
               //  rs = stmt.executeQuery(sb.toString() );
                res = stmt.executeUpdate(sb.toString());
            }
            if(res>0) {
            	System.out.println("Team Updated Succesfully");
            }
 
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
        	try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
		}
    	return "Result: "+res;
    }
    
    public String updateTASK(Task task) {
    	Connection conn = null;
    	List<String> lstTeam = new ArrayList<String>();
    	ResultSet rs = null; 
    	Statement stmt = null;
    	StringBuffer sb  = new StringBuffer();
    	String url = getDBPath(jdbcType, fileName);
    	int res=0;
        try {
        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection(url);
        	sb.append("INSERT INTO TASK VALUES('"+task.getTASK_ID()+","+task.getSKILL()+"')");
            if (conn != null) {
            	stmt = conn.createStatement();//(sb.toString());
            	//stmt.setString(1, expert);
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
               //  rs = stmt.executeQuery(sb.toString() );
                res = stmt.executeUpdate(sb.toString());
            }
            if(res>0) {
            	System.out.println("Team Updated Succesfully");
            }
 
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
        	try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
		}
    	return "Result: "+res;
    }
    public String updateTeamSkill(TeamSkill teamSkill) {
    	Connection conn = null;
    	List<String> lstTeam = new ArrayList<String>();
    	ResultSet rs = null; 
    	Statement stmt = null;
    	StringBuffer sb  = new StringBuffer();
    	String url = getDBPath(jdbcType, fileName);
    	int res=0;
        try {
        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection(url);
        	sb.append("INSERT INTO TEAM_SKILL VALUES('"+teamSkill.getTEAM_ID()+","+teamSkill.getSKILL()+"')");
            if (conn != null) {
            	stmt = conn.createStatement();//(sb.toString());
            	//stmt.setString(1, expert);
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
               //  rs = stmt.executeQuery(sb.toString() );
                res = stmt.executeUpdate(sb.toString());
            }
            if(res>0) {
            	System.out.println("Team Updated Succesfully");
            }
 
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
        	try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
		}
    	return "Result: "+res;
    }
    public static Map<String, String> getCardioDetails3(String expert) {
    	Connection conn = null;
    	Map<String, String> mp = new HashMap<String, String>();
    	String path = DBConnection.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    	ResultSet rs = null; 
    	Statement stmt = null;
    	StringBuffer sb  = new StringBuffer();
    	//String url = "jdbc:sqlite:"+ path.substring(1) + "com/ast/restful/resources/"+"Cardio.db";
    	String url = getDBPath(jdbcType, fileName);
    	//String url = "jdbc:h2:E:/testh2";
    	
    	System.out.println("url: "+url);
        try {
        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection(url);
        	//conn = DriverManager.getConnection(url, "sa", "");
        	sb.append("SELECT * FROM CARDIO where EXPERT = '"+expert+"'");
            if (conn != null) {
            	stmt = conn.createStatement();//(sb.toString());
            	//stmt.setString(1, expert);
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                 rs = stmt.executeQuery(sb.toString() );
                while (rs.next()) {
                	String id = rs.getString("ID");
                	String name = rs.getString("NAME");
                	System.out.println("userid: "+id+"\n username: "+name);
                	mp.put(id, name);
                }
            }
 
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
        	try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
		}
    	return mp;
    	
    }
    public static List<String> getCardioType() {
    	Connection conn = null;
    	List<String> lstCardioType = new ArrayList<String>();
    	ResultSet rs = null; 
    	Statement stmt = null;
    	StringBuffer sb  = new StringBuffer();
    	String url = getDBPath(jdbcType, fileName);
        try {
        	Class.forName("org.sqlite.JDBC");
        	conn = DriverManager.getConnection(url);
        	sb.append("SELECT distinct EXPERT FROM CARDIO");
            if (conn != null) {
            	stmt = conn.createStatement();//(sb.toString());
            	//stmt.setString(1, expert);
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                 rs = stmt.executeQuery(sb.toString() );
                while (rs.next()) {
                	String type = rs.getString("EXPERT");
                	System.out.println();
                	lstCardioType.add(type);
                }
            }
 
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
        	try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
		}
    	return lstCardioType;
    	
    }

    
    public static Connection getH2DbConnection() {
    	Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:h2:E:/testh2", "sa", "");
			System.out.println(conn.getMetaData().getDatabaseProductName());
			System.out.println(conn.getMetaData().getDriverName());
			System.out.println(conn.getMetaData().getDriverVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			// add application code here
    			//conn.close();
		return conn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	System.out.println(DBConnection.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    	String path = DBConnection.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    	//createNewDatabase("Cardio.db", path);
    	//getCardioDetails3("BEGINNER");
    	//getTeamData();
    	//getH2DbConnection();
    }
}
