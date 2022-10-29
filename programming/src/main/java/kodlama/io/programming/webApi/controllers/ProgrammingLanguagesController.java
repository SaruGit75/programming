package kodlama.io.programming.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programming.business.abstracts.ProgrammingLanguageService;
import kodlama.io.programming.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		List<ProgrammingLanguage> response = languageService.getAll();
		return response;
	}
	
	@GetMapping("/getById")
	public ProgrammingLanguage getById(int id) {
		ProgrammingLanguage response = languageService.getById(id);
		return response;
	}
	
	@PostMapping("/add")
	public List<ProgrammingLanguage> add(ProgrammingLanguage language) throws Exception {
		List<ProgrammingLanguage> response = languageService.add(language);
		return response;
	}
	
	@PostMapping("/update")
	public List<ProgrammingLanguage> update(ProgrammingLanguage language) throws Exception {
		List<ProgrammingLanguage> response = languageService.update(language);
		return response;
	}
	
	@PostMapping("/delete")
	public List<ProgrammingLanguage> delete(int id) {
		List<ProgrammingLanguage> response = languageService.delete(id);
		return response;
	}	
}
