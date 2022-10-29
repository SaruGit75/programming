package kodlama.io.programming.business.abstracts;

import java.util.List;

import kodlama.io.programming.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	List<ProgrammingLanguage> add(ProgrammingLanguage programmingLang) throws Exception;
	List<ProgrammingLanguage> update(ProgrammingLanguage programmingLang) throws Exception;
	List<ProgrammingLanguage> delete(int id);
}
