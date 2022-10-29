package kodlama.io.programming.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programming.business.abstracts.ProgrammingLanguageService;
import kodlama.io.programming.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programming.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository languageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return languageRepository.getById(id);
	}

	@Override
	public List<ProgrammingLanguage> add(ProgrammingLanguage programmingLang) throws Exception {
		_throwIfameRepetitiveorEmpty(programmingLang);
		
		languageRepository.add(programmingLang);
		return languageRepository.getAll();
	}

	@Override
	public List<ProgrammingLanguage> update(ProgrammingLanguage programmingLang) throws Exception {
		_throwIfameRepetitiveorEmpty(programmingLang);
		
		languageRepository.update(programmingLang);
		return languageRepository.getAll();
	}

	@Override
	public List<ProgrammingLanguage> delete(int id) {
		languageRepository.delete(id);
		return languageRepository.getAll();
	}

	private void _throwIfameRepetitiveorEmpty(ProgrammingLanguage programmingLang) throws Exception {
		if(programmingLang.getName() == "")
			throw new Exception("Language field must not empty!");
		var languages = languageRepository.getAll();
		
		for (ProgrammingLanguage programmingLanguage : languages) {
			if (programmingLanguage.getName().equals(programmingLang.getName())) {
				throw new Exception("This Language is already exist in the records");
			}
		}
	}
}
