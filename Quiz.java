import java.util.*;
public class Quiz {
	private String quizName;
    private List<Question> questions;
    
    
    public Quiz(String quizName) {
        this.quizName = quizName;
        this.questions = new ArrayList<>();
    }
    
    
    public void addQuestion(Question question) {
        questions.add(question); 
    }
    
    public List<Question> getQuestions(){
    	return questions;
    }
    
    public String getName() {
    	return quizName;
    }
}
