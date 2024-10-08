import java.util.*;
public class QuizApp {
	private static Map<String,Quiz>quizzes = new HashMap<>();
	private static Scanner sc=new Scanner(System.in);
	
	
	
	public static void main(String[] args)
	{
		while(true) {
			System.out.println("Commands: create_quiz,add_question,take_quiz,show_quizzes,exit");
			System.out.println("Enter Command: ");
			String command = sc.nextLine();
			switch(command) 
			{
				case "create_quiz" : createQuiz();
									 break;
				case "add_question" : addQuestion();
									  break;
				case "take_quiz" : takeQuiz();
									break;
				case "show_quizzes" : showQuizzes();
										break;
				case "exit" : System.exit(0);
								break;
				default : System.out.println("Unknown command");
			}
		}
	}
	
	
	
	public static void createQuiz() {
		System.out.println("Enter the quiz name: ");
		String quizName = sc.nextLine();
		if(quizzes.containsKey(quizName)) {
			System.out.println("Quiz already exists");
			return;
		}
		quizzes.put(quizName, new Quiz(quizName));
		System.out.println("Quiz created " + quizName);
	}
	
	
	
	
	
	public static void addQuestion()
	{
		System.out.println("Enter quiz name : ");
		String quizName = sc.nextLine();
		Quiz quiz = quizzes.get(quizName);
		if(quiz == null) {
			System.out.println("Quiz not found!");
			return;
		}
		System.out.println("Enter question: ");
		String questionText = sc.nextLine();
		
		System.out.println("Enter number of options: ");
		int numofoptions = Integer.parseInt(sc.nextLine());
		List<String>options = new ArrayList<>();
		for(int i=0;i<numofoptions;i++)
		{
			System.out.println("option" + i +": ");
			options.add(sc.nextLine());
		}
		
		System.out.println("Enter the correct answer (option number): ");
		int correctAnswer = Integer.parseInt(sc.nextLine());
		Question question = new Question(questionText,options,correctAnswer);
		quiz.addQuestion(question);
		System.out.println("Question is added to " + quizName);
	}
	
	
	
	
	public static void takeQuiz() {
		//user inputs the quiz name
		System.out.println("Enter quiz name: ");
		String quizName = sc.nextLine();
		//Retrieve the quiz object from the hashmap
		Quiz quiz = quizzes.get(quizName);
		//if there is no quiz 
		if(quiz == null) {
			System.out.println("Quiz not found!");
			return;
		}
		//else calculate the score for correct answer
		int score=0;
		List<Question>questions = quiz.getQuestions();//retrieve the questions,options,correctanswer (it is a custom list)
		for(Question question:questions) { //iterate over the questions
			System.out.println(question); //gets the question along with options
			System.out.println("Choose your answer "); //asking the user to choose option
			int userAnswer = Integer.parseInt(sc.nextLine()); 
			if(question.checkAnswer(userAnswer)) {
				System.out.println("Correct Answer!");
				score++;
			}
			else {
				System.out.println("Incorrect answer! Correct answer is "
			                        +question.getOptions().get(question.getCorrectAnswer()));
				
			}
			System.out.println();
		}
		
		System.out.println("Your score: " + score + "/" + questions.size());
		
	}
	
	
	
	
	public static void showQuizzes() {
		if(quizzes.isEmpty()) {
			System.out.println("No quizzes available");
			return;
		}
		System.out.println("Availabe quizzes :");
		for(String quizName:quizzes.keySet())
		{
			
			System.out.println(" - "+quizName);
		}
	}
}
