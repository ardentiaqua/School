package Kwalifikowana;

import util.ObjectPlus;

public class Employee extends ObjectPlus {
    private String pesel; // kwalifikator
    private String name;
    private Department department;

    public Employee(String pesel, String name) {
        this.pesel = pesel;
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    protected void setDepartment(Department department) {
        this.department = department;
    }


    public void changePesel(String newPesel) {
        if (department != null) {
            department.updatePesel(this, newPesel);
        }
        this.pesel = newPesel;
    }

    @Override
    public String toString() {
        return "Employee{" + "pesel='" + pesel + "', name='" + name + "'}";
    }
}
