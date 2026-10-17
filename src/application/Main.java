package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for (Seller s : sellers) {
            System.out.println(s);
        }

        System.out.println("\n=== TEST 3: Seller findAll ===");
        sellers = sellerDao.findAll();
        for (Seller s : sellers) {
            System.out.println(s);
        }

        System.out.println("\n=== TEST 4: Seller insert ===");
        Seller newSeller = new  Seller(0, "Ananias Junior", "ananiasjr1@outlook.com", LocalDate.of(1990, 6, 23), 7560.30, department);
        sellerDao.insert(newSeller);
        System.out.println("New ID generated: " + newSeller.getId());

        System.out.println("\n=== TEST 5: Seller update ===");
        Seller updatedSeller = sellerDao.findById(1);
        updatedSeller.setEmail("scapinfelipe@gmail.com");
        sellerDao.update(updatedSeller);
        System.out.println("Update completed.");


        System.out.println("\n=== TEST 6: Seller delete ===");
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed.");

        sc.close();
    }
}
