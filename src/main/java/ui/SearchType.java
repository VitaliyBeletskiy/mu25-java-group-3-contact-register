package ui;

public enum SearchType {
    BY_LAST_NAME("Search by Last Name"),
    BY_FIRST_NAME("Search by First Name"),
    BY_STREET("Search by Street"),
    FREE("Free search");

    private final String title;

    SearchType(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
}
