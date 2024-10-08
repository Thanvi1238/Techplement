import java.util.*;
public class Question 
{
	private String questionText;
	private List<String>options;
	private int correctAnswer;
	
	public Question(String questionText,List<String>options,int correctAnswer)
	{
		this.questionText=questionText;
		this.options=options;
		this.correctAnswer = correctAnswer;
	}
	
	
	// Method to check if the user's answer is correct
	public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
	
	// Getter for the list of options
	public List<String> getOptions(){
		return options;
	}
	
	// Getter for the correct answer
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    
    // ToString method to print the question and its options
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(questionText + "\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append(i).append(". ").append(options.get(i)).append("\n");
        }
        return sb.toString();
    }
	
}
