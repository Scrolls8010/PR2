package sorting.ue.employees;

import java.util.Comparator;

public class SalaryDescComparator implements Comparator<Employee> {

    public SalaryDescComparator() {
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o2.getSalary(), o1.getSalary());
    }
}
