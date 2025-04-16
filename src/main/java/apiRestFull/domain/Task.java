package apiRestFull.domain;

//Clase POJO para la estructura de una tarea
public class Task {

    //atributos de la tarea con encapsulación private
    private int ID;
    private String username;
    private String description;
    private String status;

    //Constructor
    public Task(int ID, String username, String description, String status) {
        this.ID = ID;
        this.username = username;
        this.description = description;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
