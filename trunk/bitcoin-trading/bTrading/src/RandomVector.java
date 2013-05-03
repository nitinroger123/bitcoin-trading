import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

/**
 * 
 * @author nitin
 *
 */
public class RandomVector {
	
	private List<Double> randVector;
	private int size;
	
	public RandomVector(int n) {
		randVector = new ArrayList<Double>(n);
		size = n;
	}
	
	
	public List<Double> getRandomVector() {
		for (int i = 0; i < size; ++i) {
			Random rand = new Random();
			randVector.add(rand.nextDouble());
		}
		return randVector;
	}
	
	public Double getSampleMean(boolean exp) {
		Double factor = 1.0;
		
		Double sum = new Double(0);
		for (Double d : randVector) {
			if (exp)
				factor = d;
			sum += (d * factor);
		}
		
		return sum / (size); 
	}
	
	
	
	public Double getVariance() {
		Double eX2 = getSampleMean(false) * getSampleMean(false);
		Double eXPower = getSampleMean(true);
		return eXPower - eX2;
		
	}
	
	
	public Double getSD() {
		return Math.sqrt(getVariance());
	}
	
	public void print() {
		for (Double d: randVector)
			System.out.println(d);
		
		System.out.println("********************************");
		
		System.out.println("Mean = " + getSampleMean(false));
		System.out.println("Variance = " + getVariance());
		System.out.println("Standard deviation = " + getSD() );
		
	}
	
	public static void main(String[] args) {
		RandomVector  r  = new RandomVector(1000);
		List<Double> list = r.getRandomVector();
		r.print();
		SummaryStatistics s = new SummaryStatistics();
		for (Double d: list) {
			s.addValue(d);
			
		}
		
		System.out.println("Apache mean = " + s.getMean());
		System.out.println("Apache varia = " + s.getVariance());
		
	}

}
