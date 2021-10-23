package com.example.register.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.register.Regparm;
import com.example.register.repo.Regrepo;



@Controller
public class HomeController {

	@Autowired
	Regrepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/addRegis")
	public String addRegparm(Regparm regis) {
		System.out.println(regis);
		repo.save(regis);
		return "home";
	}
	
	
	@RequestMapping("/getRegis")
	public List<Regparm>getRepo(){
		List<Object[]> objectlist = repo.getRepo();
		List<Regparm> regparm1 = new ArrayList<Regparm>();
		if (objectlist.size() > 0) {
			objectlist.forEach(objlist -> {
				Regparm regparm = new Regparm();
				regparm.setId(((Integer) objlist[0]).intValue());
				regparm.setFirstname((String) objlist[1]);
				regparm.setLastname((String) objlist[2]);
				regparm.setEmail((String) objlist[3]);
				regparm.setPhone((String) objlist[4]);
				regparm.setPassword((String) objlist[5]);
				
			});
			return regparm1;
		}
		return regparm1;
		
	
}
}

