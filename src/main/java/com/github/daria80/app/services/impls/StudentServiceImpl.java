package com.github.daria80.app.services.impls;

import com.github.daria80.app.exceptions.StudentNotFoundException;
import com.github.daria80.app.models.Student;
import com.github.daria80.app.repositories.StudentRepository;
import com.github.daria80.app.services.StudentService;
import com.github.daria80.app.utils.StringHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveOrUpdate(Student student) {
        Student savedStudent;

        if (student.getId() != null && studentRepository.existsById(student.getId())) {

            savedStudent = studentRepository.findById(student.getId()).get();
            savedStudent.setFirstName(student.getFirstName());
            savedStudent.setLastName(student.getLastName());
            savedStudent.setMajor(student.getMajor());
            savedStudent.setBirthday(student.getBirthday());
            log.info("Updated: {}", savedStudent);
        } else {
            savedStudent =  student;
            savedStudent.setId(StringHelper.generateId());
            log.info("Save: {}", savedStudent);
        }
        return  studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        log.info("find All");
        return  studentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        log.info("findById: {}", id);
            return studentRepository.findById(id).orElseThrow(
                    () -> new StudentNotFoundException("Student Not Found"));
    }

    @Override
    public void deleteById(String id) {
        log.info("deleteById: {}", id);
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new StudentNotFoundException("Student by id Not Found");
        }

    }
}
