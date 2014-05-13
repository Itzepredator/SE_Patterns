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
    
    double getCharge(int daysRented) {
    	return _price.getCharge(daysRented);
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
		abstract double getCharge(int daysRented);
		abstract int getPriceCode();
		}
		class ChildrensPrice extends Price {
			int getPriceCode() {
				return Movie.CHILDRENS;
			}
			double getCharge(int daysRented){
				double result = 1.5;
				if (daysRented > 3)
				result += (daysRented - 3) * 1.5;
				return result;
				}
		}
		class NewReleasePrice extends Price {
			int getPriceCode() {
				return Movie.NEW_RELEASE;
			}
			double getCharge(int daysRented){
				return daysRented * 3;
				}
		}
		class RegularPrice extends Price {
			int getPriceCode() {
				return Movie.REGULAR;
			}
			double getCharge(int daysRented){
				double result = 2;
				if (daysRented > 2)
				result += (daysRented - 2) * 1.5;
				return result;
				}
		}
}