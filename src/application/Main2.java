package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1 - Department findById ===");
        Department department = departmentDao.findById(4);
        System.out.println(department);

        System.out.println("\n=== TEST 2 - Department findAll ===");
        List<Department> departments = departmentDao.findAll();
        for (Department d : departments) {
            System.out.println(d);
        }


        System.out.println("\n=== TEST 3 - Department insert ===");
        Department newDepartment = new Department(0, "Economy");
        departmentDao.insert(newDepartment);
        System.out.println("New ID generated: " + newDepartment.getId());

        System.out.println("\n=== TEST 4 - Department update ===");
        Department updatedDepartment = departmentDao.findById(6);
        updatedDepartment.setName("Games");
        departmentDao.update(updatedDepartment);
        System.out.println("Update completed.");

    }
}

