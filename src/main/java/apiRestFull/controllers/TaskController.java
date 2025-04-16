package apiRestFull.controllers;

import apiRestFull.domain.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
//Nivel de clase
@RequestMapping ("/tareas")
public class TaskController {
    //simulacion de base de datos
    private List<Task> tasks = new ArrayList<>(Arrays.asList(
            new Task(1,"Iris", "Tarea de historia", "En proceso"),
            new Task(2, "Zavala","Tarea de ingles", "Completada"),
            new Task(3, "Luneta","Tarea de calculo", "Pendiente"),
            new Task(4, "Natalia","Tarea de probabilidad", "En proceso")
    ));


    // Este metodo es lo mismo que GET @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}") //ejecuta este cuando viene con parametros como el username
    public Task getTarea(@PathVariable int id) {
        //Este for recorre la lista, t es variable tarea
        for (Task t : tasks) {
            if (t.getID() == (id)) {
                return t;
            }
        }
        return null;
    }

    @PostMapping//notacion que recibe solicitudes tipo post
    public Task postTarea (@RequestBody Task task){ //RequestBody recibe parametros tipo JSON y los transforma para recibirlos
        tasks.add(task);
        return task;
    }

    @PutMapping
    public Task putTarea (@RequestBody Task task){
        //Indica que esta iterando las tareas
        for(Task t: tasks){
            //Compara si el ID iterado es el mismo
            if (t.getID() == task.getID()){
                //Con esto modificamos los valores en el set por los nuevos
                t.setUsername(task.getUsername());
                t.setDescription(task.getDescription());
                t.setStatus(task.getStatus());

                //Regresa la tarea ya MODIFICADA
                return t;
            }
        }
        //Regresa null si no se encuentra la tarea (es incorrecto este uso)
        return null;
    }

    @DeleteMapping ("/{id}")
    public Task deleteTarea (@PathVariable int id){
        for (Task t: tasks){
            if (t.getID() == id){
                tasks.remove(t);

                //retorna la tarea que se encontró y eliminó
                return t;
            }
        }
        return null;
    }

    @PatchMapping
    public Task patchTarea (@RequestBody Task task){
        for (Task t : tasks){
            if(t.getID() == task.getID()) {

                if (task.getUsername() != null) {
                    t.setUsername(task.getUsername());
                }
                if (task.getDescription() != null) {
                    t.setDescription(task.getDescription());
                }
                if (task.getStatus() != null) {
                    t.setStatus(task.getStatus());
                }
                return t;
            }
        }
        return null;
    }

    }