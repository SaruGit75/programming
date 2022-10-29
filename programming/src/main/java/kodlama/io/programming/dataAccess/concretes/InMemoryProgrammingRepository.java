package kodlama.io.programming.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import kodlama.io.programming.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programming.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> languages;
	
	public InMemoryProgrammingRepository() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1, "C#"));
		languages.add(new ProgrammingLanguage(2, "Java"));
		languages.add(new ProgrammingLanguage(3, "Python"));
		languages.add(new ProgrammingLanguage(4, "Rust"));
		languages.add(new ProgrammingLanguage(5, "Go"));
		languages.add(new ProgrammingLanguage(6, "F#"));
		languages.add(new ProgrammingLanguage(7, "C++"));
		languages.add(new ProgrammingLanguage(8, "C"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {	
		return languages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		ProgrammingLanguage languageById = null;
		
		for (ProgrammingLanguage lang: languages) {
			if (lang.getId() == id)
				languageById = lang;
		}
		
		if(languageById != null)
			return languageById;
		throw null;
	}

	@Override
	public List<ProgrammingLanguage>  add(ProgrammingLanguage programmingLang) {
		int lastId = languages.get(languages.size() - 1).getId();
		programmingLang.setId(lastId + 1);
		
		languages.add(programmingLang);
		return languages;
	}

	@Override
	public List<ProgrammingLanguage>  update(ProgrammingLanguage programmingLang) {	
		
		for (ProgrammingLanguage lang: languages) {
			if(lang.getId() == programmingLang.getId()) {
				lang.setName(programmingLang.getName());
				break;
			}
		}
		return languages;
	}

	@Override
	public List<ProgrammingLanguage>  delete(int id) {
		ProgrammingLanguage deleteToLanguage = getById(id);
		if(deleteToLanguage != null) {
			languages.remove(deleteToLanguage);
			return languages;
		}
		throw null;
	}
}
