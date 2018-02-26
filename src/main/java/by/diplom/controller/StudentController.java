package by.diplom.controller;

import by.diplom.model.Student;
import by.diplom.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    private IStudentService iStudentService;

    @Autowired
    @Qualifier(value = "iStudentService")
    public void setiStudentService(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }


    @RequestMapping(value = "students", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listStudents", this.iStudentService.listStudents());
        return "students";
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student) {
        if (student.getId() == 0) {
            this.iStudentService.addStudent(student);
        } else {
            this.iStudentService.updateStudent(student);
        }
        return "redirect:/students";
    }

    @RequestMapping("/remove/{id}")
    public String removeStudents(@PathVariable("id") int id) {
        this.iStudentService.removeStudent(id);
        return "redirect:/students";
    }

    @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", this.iStudentService.getStudentById(id));
        model.addAttribute("listStudent", this.iStudentService.listStudents());
        return "students";
    }

    @RequestMapping("studentdata/{id}")
    public String stundentData(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", this.iStudentService.getStudentById(id));
        return "studentdata";
    }
}
