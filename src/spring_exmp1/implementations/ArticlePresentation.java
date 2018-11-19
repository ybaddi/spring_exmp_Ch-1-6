package spring_exmp1.implementations;

public class ArticlePresentation {
	
	public static void main(String[] args) {
		ArticleMetier metier = new ArticleMetier();
		System.out.println(metier.computePrice());
	}

}
