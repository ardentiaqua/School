package Kwalifikowana;

import util.ObjectPlus;

public class Employee extends ObjectPlus {
    private String pesel; // kwalifikator
    private String name;
    private Department department;

    public Employee(String pesel, String name, Department department) {
    try{
        setDepartment(department);
        setPesel(pesel);
        setName(name);
    }catch(Exception e){
        e.printStackTrace();
    }
    }

    public Employee(String pesel, String name) {
        this.pesel = pesel;
        this.name = name;
    }

    public void setPesel(String pesel) {
        if(pesel == null || pesel.isBlank())throw new IllegalArgumentException();
        this.pesel = pesel;
    }

    public void setName(String name) {
        if(name == null || name.isBlank())throw new IllegalArgumentException();
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
        if (department == null) throw new IllegalArgumentException("Department cannot be null.");
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
