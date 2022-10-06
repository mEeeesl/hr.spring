package com.my.hr.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.hr.domain.Laborer;
import com.my.hr.service.LaborerService;

@RestController
@RequestMapping("laborer")
public class LaborerController {
	@Autowired private LaborerService laborerService;
	
	@GetMapping
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("laborer/laborerMain");
		return mv;
	}
	
	@GetMapping("getLaborers")
	public List<Laborer> getLaborers() {
		return laborerService.getLaborers();
	}
	
	@PostMapping("addLaborer")
	public void addLaborer(String laborerName, 
			@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate hireDate) {
		laborerService.addLaborer(laborerName, hireDate);
	}
	
	@PutMapping("fixLaborer")
	public void fixLaborer(@RequestBody Laborer laborer) {
		laborerService.fixLaborer(laborer);
	}
	
	@DeleteMapping("delLaborer/{laborerId}")
	public void delLaborer(@PathVariable int laborerId) {
		laborerService.delLaborer(laborerId);
	}
}
