package Test;

import java.util.Arrays;
import java.util.List;

public class SubjectServiceMain {

	public static void main(String[] args) {
		
		List<String> subjects = Arrays.asList(new String[] {"C", "Java", "Python","C#"});
		SubjectService subjectService = new SubjectService(subjects);
		subjectService.showSubjects();

	}

}
