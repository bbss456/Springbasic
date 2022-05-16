package Pwang.hellospring.HelloContreoller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam(value = "name" ,required = true) String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value ="name" )String name, Model modle){

        return  "hello-string" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value ="name") String name) {
        Hello helloObj = new Hello();
        helloObj.setName(name);
        return helloObj ;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
