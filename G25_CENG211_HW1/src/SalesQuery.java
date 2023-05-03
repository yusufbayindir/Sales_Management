
public class SalesQuery {
 	private double profitHolder[];
	private double max ;
	private double min;
	private double maxPrice;
	private Product[] products;
	private double priceHolder[];
	
	/*
	 * This method calculates the total profit 
	 */
	private double calculateTotalProfit(String file1,String file2,String file3){
		ObjectHolder tempproductsHolder = new ObjectHolder();
		Product[] products1 = tempproductsHolder.createProductArray(file1);
		Product[] products2 = tempproductsHolder.createProductArray(file2);
		Product[] products3 = tempproductsHolder.createProductArray(file3);
		double totalProfit=0;
		//loops for traversing each array and adding the profits to total profit.
		for(Product product1: products1) {
			double a =product1.getProfit();
            totalProfit+=a;
           
		}
		for(Product product2: products2) {
			double a =product2.getProfit();
			totalProfit+=a;
			
		}
		for(Product product3: products3) {
			double a =product3.getProfit();
			totalProfit+=a;
			
		}
		return totalProfit;

	}
	/*
	 * This method calculates the maximum profit among all products in a file.
	 * @return: amount of profit
	 */
 	private double calculateMaxProfit(String filename) {
		ObjectHolder tempproductsHolder = new ObjectHolder();
		products = tempproductsHolder.createProductArray(filename);
		double profitHolder[] = new double[products.length];
		int i=0;
        for(Product tempProduct: products) {
			double a =tempProduct.getProfit();
            profitHolder[i]=a;
            i++;
		}
		double max=profitHolder[0];
		for (int k = 0; k < profitHolder.length; k++){
            if (profitHolder[k] > max) {
                max= profitHolder[k];
            }
		}
		
		this.max=max;
		this.profitHolder=profitHolder;
        return max ; 
 	}
 	/*
	 * This method calculates the minimum profit among all products in a file.
	 * @return: amount of profit
	 */
	private double calculateMinProfit(String filename) {
		ObjectHolder tempproductsHolder = new ObjectHolder();
		products = tempproductsHolder.createProductArray(filename);
		double profitHolder[] = new double[products.length];
		int i=0;
        for(Product tempProduct: products) {
			double a =tempProduct.getProfit();
            profitHolder[i]=a;
            i++;
		}
		double min=profitHolder[0];
		for (int k = 0; k < profitHolder.length; k++){
            if (profitHolder[k] < min) {
                min= profitHolder[k];
            }
		}
		
		this.min=min;
		this.profitHolder=profitHolder;
        return min ; 
 	}
	
	/*
	 * This method finds the index of a double value in an double array.
	 * @param parameter: the double array to be searched
	 * @param max: the double value to be searched in the array
	 * @return: the index of the searched value
	 */
	private int findIndexWithValue(double[] parameter,double max) {
		int myindex = -1; 
    	for(int i=0; i<parameter.length; i++) {
        if(parameter[i] == max)
            myindex = i ;
		}
		return myindex ;
	}
	
	/*
	 * This method finds the most profitable product among all products.
	 */
	private Product findMostProfitableProduct(){
		double max1=calculateMaxProfit("S1_Products.csv");
		double max2 = calculateMaxProfit("S2_Products.csv");
		double max3 = calculateMaxProfit("S3_Products.csv");		
	   	
		double max = max1; 
        if(max2 > max) {
            max = max2;
        }
        if(max3 > max) {
            max = max3;
        }
		
		if(max==max3){
			int index= findIndexWithValue(profitHolder, max);
			return products[index];
		}
		else if (max==max2){
			calculateMaxProfit("S2_Products.csv");
			int index= findIndexWithValue(profitHolder, max) ;
			return products[index];
		}
		else if (max==max1){
			calculateMaxProfit("S1_Products.csv");
			int index= findIndexWithValue(profitHolder, max);
			return products[index];
		}
		return null;
		
			
		}
	
	/*
	 * This method finds the least profitable product in the file.
	 * @param fileName: name of the file to be searched.
	 */
	private Product findMinProfitableProduct(String fileName){
		double min=calculateMinProfit(fileName);
		int index = findIndexWithValue(profitHolder,min);
		return products[index];
		}
		
		/*
		 * This method finds the maximum sales price in the file.
		 * @return: amount of minimum price
		 */
	private double calculateMaxSalesPrice(String filename) {	
		ObjectHolder tempproductsHolder = new ObjectHolder();
		products = tempproductsHolder.createProductArray(filename);
		priceHolder = new double[products.length];
		int i=0;
        for(Product tempProduct: products) {
			double a =tempProduct.getSalesPrice();
            priceHolder[i]=a;
            i++;
		}
		double maxPrice=priceHolder[0];
		for (int k = 0; k < priceHolder.length; k++){
            if (priceHolder[k] > maxPrice) {
                maxPrice= priceHolder[k];
            }
		}
		
		this.maxPrice=maxPrice;
		return maxPrice;
	}
	
	/*
	 * This method finds the product that has the highest sales price among all products.
	 * @return: the product which has the highest sales price
	 */
	private Product findMostSalesPriceProduct(){
		double max1 = calculateMaxSalesPrice("S1_Products.csv");
		double max2 = calculateMaxSalesPrice("S2_Products.csv");
		double max3 = calculateMaxSalesPrice("S3_Products.csv");		
	   	
		double max = max1; 
        if(max2 > max) {
            max = max2;
        }
        if(max3 > max) {
            max = max3;
        }
		
		if(max==max3){
			int index= findIndexWithValue(priceHolder, maxPrice);
			return products[index];
		}
		else if (max==max2){
			calculateMaxSalesPrice("S2_Products.csv");
			int index= findIndexWithValue(priceHolder, maxPrice);
			return products[index];
		}
		else if (max==max1){
			calculateMaxSalesPrice("S1_Products.csv");
			int index= findIndexWithValue(priceHolder, maxPrice);
			return products[index];
		}
		return null;
		
		}
	
	/*
	 * This method finds the customer who had most purchases among all customers
	 * @param target: ID of the customer
	 * @return: the customer who had most purchases
	 */
	private Customer findMostPurchasedCustomer(String target){
			ObjectHolder objectHolder = new ObjectHolder();
			Customer[] customerArray = objectHolder.createCustomerArray();
			Customer tempoCustomer = null ;
			for (Customer tempCustomer:customerArray){
				if(tempCustomer.getId().equals(target)){
					tempoCustomer =  tempCustomer;
				}
			}
		return tempoCustomer ;
		}
	
	public void displayMostProfitProduct() {
		Product maxProfitProduct= findMostProfitableProduct();
		System.out.println("1-) "+maxProfitProduct.toString()+" -> "+maxProfitProduct.getProfit()+" TL profit");
	}
	public void displayMaxSalesPrice() {
		Product maxSalesPriceProduct= findMostSalesPriceProduct();
		System.out.println("2-) " +maxSalesPriceProduct.toString()+"-> with sales price "+maxSalesPriceProduct.getSalesPrice());
	}
	public void displayMostPurchasedCustomer() {
		SalesManagement manage= new SalesManagement();
		manage.createSalesManagementArray("S1_Sales.csv", "S2_Sales.csv", "S3_Sales.csv");
		String purchasedMost= manage.purchasedMost();
		Customer customer=findMostPurchasedCustomer(purchasedMost);
		System.out.println("3-) "+customer.toString()+" -> "+manage.getFrequency()+" purchases");
	}
	public void displayTotalProfit() {
		System.out.println("4-) "+calculateTotalProfit("S1_Products.csv", "S2_Products.csv", "S3_Products.csv"));
	}
	public void displayMinProfitableProduct() {
		Product minProfitProduct=findMinProfitableProduct("S1_Products.csv");
		System.out.println("5-) "+minProfitProduct.toString()+" -> "+calculateMinProfit("S1_Products.csv")+" TL profit");
	}
	} 


 

