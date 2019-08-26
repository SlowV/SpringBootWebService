package demo.springboot.service;

import demo.springboot.entity.Student;
import demo.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> findAll(){
        return studentRepository.findAll();
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public Student findById(String id){
        return studentRepository.findById(id).orElse(null);
    }

    public void delete(String id){
        studentRepository.deleteById(id);
    }
}
