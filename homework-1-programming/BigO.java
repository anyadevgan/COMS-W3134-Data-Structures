public class BigO implements BigOInterface{
    
	//O(n^3)
    public void cubic(int n){
        int sum = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					sum++;
				}
			}
		}
    }
    
	//O(2^n)
	public void exp(int n){ 
        int sum = 0;
        for(int i = 0; i < Math.pow(2,n); i++){
            sum += i; 
        }
    }
    
	//O(1)
	public void constant(int n){
        int sum = 0;
		sum++;
    }
    
}