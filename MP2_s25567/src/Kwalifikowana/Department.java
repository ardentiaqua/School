﻿package Kwalifikowana;

import util.ObjectPlus;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Department extends ObjectPlus {
    private String name;
    private TreeMap<String, Employee> employeesByPesel = new TreeMap<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        if (employee == null || employeesByPesel.containsKey(employee.getPesel())) {
            throw new IllegalArgumentException("Invalid or duplicate employee.");
        }

        employeesByPesel.put(employee.getPesel(), employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(String pesel) {
        Employee removed = employeesByPesel.remove(pesel);
        if (removed != null) {
            removed.setDepartment(null);
        }
    }

    public Employee getEmployeeByPesel(String pesel) {
        return employeesByPesel.get(pesel);
    }

    public Map<String, Employee> getAllEmployees() {
        return Collections.unmodifiableMap(employeesByPesel);
    }

    // Aktualizacja kwalifikatora w mapie
    protected void updatePesel(Employee employee, String newPesel) {
        if (!employeesByPesel.containsKey(employee.getPesel())) return;

        employeesByPesel.remove(employee.getPesel());
        employeesByPesel.put(newPesel, employee);
    }

    @Override
    public String toString() {
        return "Department{" + "name='" + name + "', employees=" + employeesByPesel.values() + '}';
    }
}

