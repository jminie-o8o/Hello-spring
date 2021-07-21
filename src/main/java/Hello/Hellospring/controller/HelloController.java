package Hello.Hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //웹어플리케이션에서 /(슬래쉬)hello 라고 들어오면 아래 메소드를 실행해준다.
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","spring");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {  //@RequestParam 외부에서 파라미터를 받는다.
        model.addAttribute("name", name);                         //@RequestParam 는 required가 기본적으로 true기 때문에 파라미터가 있어야한다.
        return "hello-template";                                              //@RequstParam을 썼으면 반드시 RequestParam과 key값을 맞춰야 함.
                                                                              //model에 담으면 view에서 랜더링할 때 사용
    }

    @GetMapping("hello-string")
    @ResponseBody //http Body부분에 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 넘김
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
