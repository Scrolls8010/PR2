package sorting.ue.employees;

import java.util.Comparator;

public class DepartmentAscNameDescComparator implements Comparator<Employee> {

    public DepartmentAscNameDescComparator() {
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        // check first value to compare
        int compDept = o1.getDepartment().compareTo(o2.getDepartment());
        // check if both are the same, if yes, sort by second crit
        if (compDept == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return compDept;
    }
}
