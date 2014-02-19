package isw2.domain.product;

import java.util.List;

import isw2.domain.procedure.IProcedure;


public interface IProductRepository {
	
	public void storeProduct(IProduct product);

	public void modifyProduct(IProduct product);
	
	public void removeProduct(IProduct product);
	
	public Product findProduct(Integer id);
	
	public List<Product> findAll();

	public void assignProcedure(IProduct product, IProcedure procedure);
	
}
