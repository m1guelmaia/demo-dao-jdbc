package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import model.impl.SellerDaoJDBC;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Department obj = new Department(1, "Books");

        Seller seller = new Seller(22, "Mariano", "marianopegasus@outlook.com", LocalDate.now(), 4500.0, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);

    }
}
