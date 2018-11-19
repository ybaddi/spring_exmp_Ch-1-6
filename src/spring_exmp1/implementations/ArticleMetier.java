package spring_exmp1.implementations;

import spring_exmp1.interfaces.IArticleData;
import spring_exmp1.interfaces.IArticleMetier;

public class ArticleMetier implements IArticleMetier{
	
	private IArticleData articleData;
	
	public double computePrice() {
		double price = articleData.getPrice();
		return price + (price * 0.2);
		
	}

	public void setArticleData(IArticleData articleData) {
		this.articleData = articleData;
	}	

}
