package info.androidhive.sqlite.database.model;

public class Message {

    public static final String TABLE_NAME = "messages";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_RECIVER = "reciver";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String content;
    private long reciver;
    private String timestamp;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_CONTENT + " TEXT,"
                    + COLUMN_RECIVER + " INTEGER,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Message(){}


    public Message(int id, String content, int reciver, String timestamp) {
        this.id = id;
        this.content = content;
        this.reciver = reciver;
        this.timestamp = timestamp;
    }
    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getReciver() {
        return reciver;
    }

    public void setReciver(long reciver) {
        this.reciver = reciver;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
