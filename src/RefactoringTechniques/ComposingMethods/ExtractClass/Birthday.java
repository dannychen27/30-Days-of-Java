package RefactoringTechniques.ComposingMethods.ExtractClass;

class Birthday {

    private int day;
    private int month;
    private int year;

    Birthday(int month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return getMonth() + " / " + getDay() + " / " + getYear();
    }

    private String getBirthDate() {
        return getMonth() + " / " + getDay() + " / " + getYear();
    }

    private int getDay() {
        return day;
    }

    private int getMonth() {
        return month;
    }

    private int getYear() {
        return year;
    }

    private void setDay(int day) {
        this.day = day;
    }

    private void setMonth(int month) {
        this.month = month;
    }

    private void setYear(int year) {
        this.year = year;
    }
}
