package com.spring.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.db.DBConnection;
import com.spring.model.Task;
import com.spring.model.Team;
import com.spring.model.TeamSkill;
import com.spring.util.CommonUtil;

@Component
public class TMService {

	public String getTeamData() {
		DBConnection db = new DBConnection();
		
		List<String> list =  db.getTeamData();;
		
		return list.toString();
	}
	
	public String loadData(Team team) {
		DBConnection db = new DBConnection();
		
		String result =  db.updateTeam(team);;
		
		return result;
	}
	public String loadTaskData(Task task) {
		DBConnection db = new DBConnection();
		
		String result =  db.updateTASK(task);
		
		return result;
	}
	public String loadTeamSkill(TeamSkill teamSkill) {
		DBConnection db = new DBConnection();
		
		String result =  db.updateTeamSkill(teamSkill);
		
		return result;
	}
	public List<Team> readData() {
		
		List<Team> list= new ArrayList<>();
		String result = "";
		String csvFile = CommonUtil.getResources("team.csv");
		String line = "";
        String cvsSplitBy = ",";
        int i=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	if(i!=0) {
	            	Team team = new Team();
	                // use comma as separator
	                String[] arr = line.split(cvsSplitBy);
	                team.setTEAM_ID(arr[0].replaceAll("\"", ""));
	                System.out.println(""+arr[0]);
	                list.add(team);
            	}
            	i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		return list;
	}
	
	public List<Task> readTaskData() {
		
		List<Task> list= new ArrayList<>();
		String result = "";
		String csvFile = CommonUtil.getResources("task.csv");
		String line = "";
        String cvsSplitBy = ",";
        int i=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	if(i!=0) {
	            	Task task = new Task();
	                // use comma as separator
	                String[] arr = line.split(cvsSplitBy);
	                task.setTASK_ID(arr[0]);
	                task.setSKILL(arr[1]);
	                System.out.println(""+arr[0]);
	                list.add(task);
            	}
            	i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		return list;
	}
	
	public List<TeamSkill> readTeamSkillData() {
		
		List<TeamSkill> list= new ArrayList<>();
		String result = "";
		String csvFile = CommonUtil.getResources("team_skill.csv");
		String line = "";
        String cvsSplitBy = ",";
        int i=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	if(i!=0) {
            		TeamSkill teamSkill = new TeamSkill();
	                // use comma as separator
	                String[] arr = line.split(cvsSplitBy);
	                teamSkill.setTEAM_ID(arr[0]);
	                teamSkill.setSKILL(arr[1]);
	                System.out.println(""+arr[0]);
	                list.add(teamSkill);
            	}
            	i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		return list;
	}
	public boolean deleteFile(String fileName) {
		String csvFile = CommonUtil.getResources(fileName);
		boolean deleted=false;
		try{
    		
    		File file = new File(csvFile);
        	
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    			deleted = true;
    		}else{
    			System.out.println("Delete operation is failed.");
    			deleted=false;
    		}
    	   
    	}catch(Exception e){
    		
    		e.printStackTrace();
    		
    	}
		return deleted;
	}
	public String addTeamData() {
		DBConnection db = new DBConnection();
		
		List<String> list =  db.getTeamData();;
		
		return list.toString();
	}
}
