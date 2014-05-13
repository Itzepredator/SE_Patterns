package fowler;
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }
    public int getPriceCode() {
    	return _price.getPriceCode();
    	}
    	public void setPriceCode(int arg) {
    	switch (arg) {
    	case REGULAR:
    	_price = new RegularPrice();
    	break;
    	case CHILDRENS:
    	_price = new ChildrensPrice();
    	break;
    	case NEW_RELEASE:
    	_price = new NewReleasePrice();
    	break;
    	default:
    	throw new IllegalArgumentException("Incorrect Price Code");
    	}
    	}
    	private Price _price;
    public String getTitle (){
        return title;
    };
    public double getCharge(int daysRented) {
		double result =0;
		switch (this.getPriceCode()) {
		    case Movie.REGULAR:
		    	result += 2;
		    	if (daysRented > 2)
		        	result += (daysRented - 2) * 1.5;
		    	break;
		    case Movie.NEW_RELEASE:
		    	result += daysRented * 3;
		    	break;
		    case Movie.CHILDRENS:
		    	result += 1.5;
		    	if (daysRented > 3)
		        	result += (daysRented - 3) * 1.5;
		    	break;
		}
		return result;
	}
	public int getFrequentRenterPoints(int daysRented) {
		int frequentRenterPoints =0;
		// add frequent renter points
		frequentRenterPoints ++;
		// add bonus for a two day new release rental
		if ((this.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) 
		    frequentRenterPoints ++;
		return frequentRenterPoints;
	}    
	
	abstract class Price {
		abstract int getPriceCode();
		}
		class ChildrensPrice extends Price {
		int getPriceCode() {
		return Movie.CHILDRENS;
		}
		}
		class NewReleasePrice extends Price {
		int getPriceCode() {
		return Movie.NEW_RELEASE;
		}
		}
		class RegularPrice extends Price {
		int getPriceCode() {
		return Movie.REGULAR;
		}
		}
}