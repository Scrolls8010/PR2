package sorting.ue.employees;

import java.util.Comparator;

public class SalaryAscNameAscComparator implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {
        // compare main sorting value
        int compSal = Double.compare(o1.getSalary(), o2.getSalary());
        // if result is 0, aka they are the same, sort further by second value
        if (compSal == 0 ) {
            return o1.getName().compareTo(o2.getName());
        }
        return compSal;
    }
}
