package demo.springboot.api;

import demo.springboot.entity.Student;
import demo.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentApi {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public List<Student> getAll(){
        return (List<Student>) studentService.findAll();
    }

    @RequestMapping("/{id}")
    public Student findOne(@PathVariable String id){
        return studentService.findById(id);
    }

    @PostMapping("/add")
    public Student add(@RequestBody Student student){
        studentService.save(student);
        return student;
    }

    @PutMapping("/update")
    public Student update(@RequestBody Student student){
        Student studentExist = studentService.findById(student.getId());
        if (studentExist != null){
            studentExist.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
            studentExist.setEmail(student.getEmail());
            studentExist.setName(student.getName());
            studentService.save(studentExist);
        }
        return student;
    }

    @DeleteMapping("/delete/{id}")
    public String detete(@PathVariable String id){
        Student studentExist = studentService.findById(id);
        if (studentExist != null){
            studentService.delete(id);
            return "Delete success!";
        }
        return "Delete fail.";
    }
}
