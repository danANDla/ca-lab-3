package methods;

import java.util.ArrayList;
import java.util.HashMap;

public class MethodResult {
    double answer;

    public MethodResult(double answer, SolutionStatus status) {
        this.answer = answer;
        this.status = status;
    }

    SolutionStatus status;

    public double getAnswer() {
        return answer;
    }

    public SolutionStatus getStatus() {
        return status;
    }
}
