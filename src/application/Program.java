package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
		/*SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj: list)
		{
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: seller findall ===");
		list = sellerDao.findAll();
		for(Seller obj: list)
		{
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: seller Insert ===");
		Seller newSeller = new Seller(null, "greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new seller with id = "+ newSeller.getId() +"!!");
		
		System.out.println("\n=== Test 5: seller Update ===");
		seller = sellerDao.findById(10);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Updated!");
		
		System.out.println("\n=== Test 6: seller Delete ===");
		sellerDao.deleteById(11);
		System.out.println("Deleted!");*/
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("=== Teste 1: Department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== Teste 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department dep: list) 
		{
			System.out.println(dep);
		}
		
		System.out.println("\n=== Teste 2: Department Insert ===");
		Department depInsert = new Department(null, "Investigation");
		departmentDao.insert(depInsert);
		System.out.println("Done!");	
		
		System.out.println("\n=== Teste 3: Department Update ===");
		depInsert.setName("Developer");
		departmentDao.update(depInsert);
		
		System.out.println("\n=== Teste 4: Department Delete ===");
		departmentDao.deleteById(13);
	}

}
