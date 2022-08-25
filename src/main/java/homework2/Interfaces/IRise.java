package homework2.Interfaces;

import homework2.Exceptions.InvalidSalaryException;
import homework2.Project;

@FunctionalInterface
public interface IRise {

    double getSalariesWithRaise(Project p) throws InvalidSalaryException;
}
