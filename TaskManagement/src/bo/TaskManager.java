/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author datkh
 */
public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // ID = ID của task cuối cùng + 1 (theo đề)
    public boolean addTask(Task t) {
        if (t == null) {
            return false;
        }
        t.setId(tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1);
        return tasks.add(t);
    }

    private int getTaskIndexById(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void deleteTask(int id) throws Exception {
        int index = getTaskIndexById(id);
        if (index == -1) {
            throw new Exception("Task ID does not exist!");
        }
        tasks.remove(index);
    }

    // Trả về bản copy đã sắp xếp tăng dần theo ID, không sort trực tiếp list gốc
    public ArrayList<Task> getDataTasks() {
        ArrayList<Task> result = new ArrayList<>(tasks);
        Collections.sort(result, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.getId(), t2.getId());
            }
        });
        return result;
    }

}
