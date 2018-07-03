package com.spring.springboot.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.model.Task;
import com.spring.model.Team;
import com.spring.model.TeamSkill;
import com.spring.service.TMService;

@RestController
public class TMController {
	@Autowired
	private TMService service;
	@RequestMapping("/tmService")
	public String welcome(){
		return service.getTeamData();
	}
	@RequestMapping("/tmService/load")
	public String loadData(){
		Team team= new Team();
		team.setTEAM_ID("TEAM_01");
		return service.loadData(team);
	}
	
	@RequestMapping("/tmService/loadTeam")
	public String loadTeamData(){
		List<Team> list = new ArrayList<>();
		list = service.readData();
		String str = "";
		for (Team team : list) {
		str = str +	service.loadData(team);
			
		}
		return str;
	}
	@RequestMapping("/tmService/loadTask")
	public String loadTaskData(){
		List<Task> list = new ArrayList<>();
		list = service.readTaskData();
		String str = "";
		for (Task task : list) {
		str = str +	service.loadTaskData(task);
			
		}
		return str;
	}
	
	@RequestMapping("/tmService/loadTeamSkill")
	public String loadSkillData(){
		List<TeamSkill> list = new ArrayList<>();
		list = service.readTeamSkillData();
		String str = "";
		for (TeamSkill teamSkill : list) {
		str = str +	service.loadTeamSkill(teamSkill);
			
		}
		return str;
	}
	@RequestMapping("/tmService/readFile")
	public List<Team> readFiles(){
		Team team= new Team();
		List<Team> list = new ArrayList<>();
		list = service.readData();
		return list;
	}
	
	@RequestMapping("/tmService/deleteFile")
	public String deleteFile(){
		Team team= new Team();
		String str= "";
		if(service.deleteFile("team.csv")) {
			str = "team.csv" +"is deleted!";
		}else {
			str = "team.csv" +"is not deleted!";
		}
		return str;
	}
	@RequestMapping(value = "/TeamService", method = RequestMethod.POST)
	public ResponseEntity<Team> addDataToTeam(@RequestBody Team team) {

		if(team!=null) {
			team.setTEAM_ID(team.getTEAM_ID());
		}
		// Status
		return new ResponseEntity<Team>(team, HttpStatus.OK);
	}
}
