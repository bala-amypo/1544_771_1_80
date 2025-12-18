package com.example.onetomany.service;

import com.example.onetomany.model.Department;
import com.example.onetomany.model.Employee;
import com.example.onetomany.repository.DepartmentRepository;
import com.example.onetomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    
    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }
    
    @Override
    public Department createDepartment(Department department) {
        if (department.getEmployees() != null) {
            for (Employee employee : department.getEmployees()) {
                employee.setDepartment(department);
            }
        }
        return departmentRepository.save(department);
    }
    
    @Override
    public Employee addEmployeeToDepartment(Long departmentId, Employee employee) {
        Optional<Department> departmentOpt = departmentRepository.findById(departmentId);
        if (departmentOpt.isPresent()) {
            Department department = departmentOpt.get();
            employee.setDepartment(department);
            return employeeRepository.save(employee);
        }
        throw new RuntimeException("Department not found with id: " + departmentId);
    }
}

