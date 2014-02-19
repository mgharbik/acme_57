package isw2.infrastructure.persistence.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.product.IProduct;
import isw2.domain.product.IProductRepository;
import isw2.domain.product.Product;

public class ProductRepository extends JPARepository 
						implements IProductRepository{

	public ProductRepository(EntityManager em) {
		super(em);
	}

	@Override
	public void assignProcedure(IProduct product, IProcedure procedure) {
		boolean res=true;
		Set<IProcedure> lps = new HashSet<IProcedure>();
		Set<IProduct> lp = new HashSet<IProduct>();
		
		IProduct p = findProduct(product.getID());
		if(p==null){
			res=false;
			System.out.print("The product: "+ product.getName() +"dosn't exist in the db");
		}
		IProcedureRepository pdr = new ProcedureRepository(getEntityManager());
		IProcedure dp = pdr.findProcedure(procedure.getID());
		if(dp==null){
			res=false;
			System.out.print("The procedure: "+ procedure.getName() +"dosn't exist in the db");
		}
		
		if(res){
			lps = p.getProcedures();
			lps.add(procedure);
			p.setProcedures(lps);
			
			lp = dp.getProducts();
			lp.add(p);
			dp.setProducts(lp);
		}
		
	}

	@Override
	public List<Product> findAll() {
		return getEntityManager().createQuery("from Product", Product.class).getResultList();
	}

	@Override
	public Product findProduct(Integer id) {
		return getEntityManager().find(Product.class, id);

	}

	@Override
	public void modifyProduct(IProduct product) {
		getEntityManager().refresh(product);	
	}

	@Override
	public void removeProduct(IProduct product) {
		getEntityManager().remove(product);		
	}

	@Override
	public void storeProduct(IProduct product) {
		getEntityManager().persist(product);		
	}



}
