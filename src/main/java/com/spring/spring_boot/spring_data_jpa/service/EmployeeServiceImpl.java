package com.spring.spring_boot.spring_data_jpa.service;

import com.spring.spring_boot.spring_data_jpa.dao.EmployeeRepository;
//import com.spring.springboot.spring_springboot.dao.EmployeeDAO;
//import com.spring.springboot.spring_springboot.entity.Employee;
import com.spring.spring_boot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    //private EmployeeDAO employeeDAO; //зависимость нампярмую от DAO
    private EmployeeRepository employeeRepository; //зависимость нампярмую от EmployeeRepository

    @Override
    //@Transactional
    public List<Employee> getAllEmployees() {
        //return employeeDAO.getAllEmployees(); //просто вызывает метод из DAO
        return employeeRepository.findAll();
        //return null;
    }

    @Override
    //@Transactional
    public void saveEmpl(Employee employee) {
        System.out.println("EmployeeServiceImpl save emp " + employee);
        //employeeDAO.saveEmpl(employee);
        employeeRepository.save(employee);
    }

    @Override
    //@Transactional
    public Employee getEmployee(int id) {
        //return employeeDAO.getEmployee(id);
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) employee = optional.get();

        return employee;
    }

    @Override
    //@Transactional
    public void deleteEmployee(int id) {
        //employeeDAO.deleteEmployee(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> emps = employeeRepository.findAllByName(name);
        return emps;
    }
}
