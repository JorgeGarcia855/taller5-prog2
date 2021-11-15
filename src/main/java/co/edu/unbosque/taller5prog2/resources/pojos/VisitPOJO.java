package co.edu.unbosque.taller5prog2.resources.pojos;

public class VisitPOJO {
    private Integer visitId;
    private String createdAt;
    private String type;
    private String description;

    public VisitPOJO() {}

    public VisitPOJO(Integer visitId, String type, String description) {
        this.visitId = visitId;
        this.type = type;
        this.description = description;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
