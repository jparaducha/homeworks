package homework2.interfaces;

import homework2.Project;
import homework2.exceptions.InvalidSalaryException;

@FunctionalInterface
public interface IRise {

    double getSalariesWithRaise(Project p) throws InvalidSalaryException;
}
