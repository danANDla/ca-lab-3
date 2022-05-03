package methods;

import java.util.ArrayList;
import java.util.HashMap;

public class MethodResult {
    HashMap<String, Double> values;

    public MethodResult(HashMap<String, Double> values, SolutionStatus status) {
        this.values = values;
        this.status = status;
    }

    SolutionStatus status;

    public HashMap<String, Double> getValues() {
        return values;
    }

    public SolutionStatus getStatus() {
        return status;
    }
}
