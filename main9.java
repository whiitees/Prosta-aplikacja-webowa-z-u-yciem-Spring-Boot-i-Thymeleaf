import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ZaawansowanaAplikacjaWebowa {

    public static void main(String[] args) {
        SpringApplication.run(ZaawansowanaAplikacjaWebowa.class, args);
    }
}

@Controller
class TaskController {

    private final List<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam String taskName) {
        Task newTask = new Task(taskName);
        tasks.add(newTask);
        return "redirect:/";
    }
}

class Task {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
