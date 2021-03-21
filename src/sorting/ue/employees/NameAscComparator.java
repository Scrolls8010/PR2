package sorting.ue.employees;

import java.util.Comparator;



public class NameAscComparator implements Comparator<Employee> {

    public NameAscComparator() {
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
