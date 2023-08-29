package spring.db.com.mysqlmongo.response;

public class FailedResponse {
    private String value;
    private int index;

    public FailedResponse(String value, int index) {
        this.value = value;
        this.index = index;
    }
}
