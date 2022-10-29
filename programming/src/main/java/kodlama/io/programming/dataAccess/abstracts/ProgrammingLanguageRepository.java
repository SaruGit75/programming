package kodlama.io.programming.dataAccess.abstracts;

import java.util.List;

import kodlama.io.programming.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	List<ProgrammingLanguage> add(ProgrammingLanguage programmingLang);
	List<ProgrammingLanguage> update(ProgrammingLanguage programmingLang);
	List<ProgrammingLanguage> delete(int id);
}
