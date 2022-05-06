package methods;

public enum SolutionStatus {
    OK("Решение найдено успешно");
    private String description;

    SolutionStatus(String s) {
        this.description = s;
    }

    public String getDescription() {
        return this.description;
    }
}
