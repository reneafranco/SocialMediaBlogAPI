package Model;

import java.sql.Timestamp;
import java.time.Instant;

public class Message {

    private int id;
    private String content;
    private int created_by;
    private Long created_at;

    public Message(String content, int created_by, Long created_at){
        this.content = content;
        this.created_by = created_by;
        this.created_at = created_at;
    }

    public Message(int id, String content, int created_by, Long created_at){
        this.id= id;
        this.content = content;
        this.created_by = created_by;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getCreated_by() {
        return created_by;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    @Override
    public String  toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created_by=" + created_by +
                ", created_at=" + created_at +
                '}';
    }
}
