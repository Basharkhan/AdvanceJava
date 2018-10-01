package bd.ac.seu.collectionsHome;

public enum Grade {
    A("A", 3.75),
    A_PLUS("A+", 4.00),
    A_MINUS("A-", 3.50),
    AB("AB", 0.00),
    B("B", 3.00),
    B_PLUS("B+", 3.25),
    B_MINUS("B-", 2.75),
    C("C", 2.25),
    C_PLUS("C+", 2.50),
    D("D", 2.00),
    F("F", 0.00),
    I("I", 0.00),
    R("R", 0.00),
    S("S", 4),
    U("U", 0.00);

    String letterGrade;
    double numericGrade;

    Grade(String letterGrade, double numericGrade) {
        this.letterGrade = letterGrade;
        this.numericGrade = numericGrade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public double getNumericGrade() {
        return numericGrade;
    }

    @Override
    public String toString() {
        return letterGrade;
    }
}
