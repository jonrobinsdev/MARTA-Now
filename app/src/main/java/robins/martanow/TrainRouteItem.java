package robins.martanow;

public class TrainRouteItem {

    private int imageId;
    private String description;
    private int editButton;

    public TrainRouteItem(int imageId, String description, int editImageId) {
        this.imageId = imageId;
        this.description = description;
        this.editButton = editImageId;
    }

    public TrainRouteItem(String description){
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public int getEditButton() {
        return editButton;
    }

    public void setEditButton(int editImageId) {
        this.editButton = editImageId;
    }

    @Override
    public String toString() {
        return description;
    }
}