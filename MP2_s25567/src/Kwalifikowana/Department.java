package Kwalifikowana;

import util.ObjectPlus;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Department extends ObjectPlus {
    private String name;
    private HashMap<String, Employee> employeesByPesel = new HashMap<>();
//sety zrobic
    public Department(String name, HashMap<String, Employee> employeesByPesel) {
        this.name = name;
        this.employeesByPesel = employeesByPesel;
    }

    public void addEmployee(Employee employee) {
        if (employee == null || employeesByPesel.containsKey(employee.getPesel())) {
            throw new IllegalArgumentException("Invalid or duplicate employee.");
        }
        employeesByPesel.put(employee.getPesel(), employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(String pesel) {
        if(employeesByPesel.containsKey(pesel)){
            Employee employee = employeesByPesel.get(pesel);
            employeesByPesel.remove(pesel);
            employee.setDepartment(null);
        }
    }

    public Employee getEmployeeByPesel(String pesel) {
        return employeesByPesel.get(pesel);
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");
        this.name = name;
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

