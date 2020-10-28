public class Problem3{
    public static void main(String[] args){
        
        BigO x = new BigO();
		long startTime;
		long endTime;
        
        //initial run of methods to prevent compiler inefficiency
        x.cubic(5);
        x.constant(5);
        x.exp(5);
        
		//test cubic
		System.out.println("Runtime results for cubic()");
		for(int i = 10; i < 6000; i *=5){
			startTime = System.nanoTime();
			x.cubic(i);
			endTime = System.nanoTime();
			System.out.println("for n = " + i + ", time elapsed = " + (endTime - startTime) + " ns");
		}
		
        //test constant
        System.out.println("Runtime results for constant()");
		for(int j = 10; j < 1000000; j *= 10){
            startTime = System.nanoTime();
            x.constant(j);
            endTime = System.nanoTime();
			System.out.println("for n = " + j + ", time elapsed = " + (endTime - startTime) + " ns");
        }
		
        //test exponential
        System.out.println("Runtime results for exp()");        
		for(int k = 6; k <= 30; k *= 2){
            startTime = System.nanoTime();
            x.exp(k);
            endTime = System.nanoTime();
			System.out.println("for n = " + k + ", time elapsed = " + (endTime - startTime) + " ns");
        }
        
        System.out.println("Finished");

                
    }
}
