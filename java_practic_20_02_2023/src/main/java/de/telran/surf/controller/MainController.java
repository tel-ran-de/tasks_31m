package de.telran.surf.controller;

import de.telran.surf.entity.*;
import de.telran.surf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final CategoryService categoryService;

    private final ProductService productService;

    private final UserService userService;

    private final RoleService roleService;

    private final CaptchaService captchaService;

    @Autowired
    public MainController(
            CategoryService categoryService,
            ProductService productService,
            UserService userService,
            RoleService roleService,
            CaptchaService captchaService
    ) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.roleService = roleService;
        this.captchaService = captchaService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Map<Category, List<Product>> productsByCategories = new HashMap<>();
        for (Category category : categoryService.getAllCategories()) {
            productsByCategories.put(category, productService.getProductsInCategory(category));

        }
        model.addAttribute("map", productsByCategories);
        return "index";
    }

    @GetMapping("/login")
    public String admin(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @Valid User user,
            BindingResult bindingResult,
            HttpServletRequest request
    ) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            bindingResult.addError(new FieldError("user", "password", "Passwords must equals!"));
            return "registration";
        }
        String response = request.getParameter("g-recaptcha-response");
        String ip = request.getRemoteAddr();
        GoogleResponse googleResponse = captchaService.processResponse(response, ip);
        if (!googleResponse.isSuccess()) {
            return "registration";
        }

        String username = user.getLogin();
        String password = user.getPassword();
        Role role = roleService.findByName("ROLE_USER");
        if (role == null) {
            role = roleService.save(new Role("ROLE_USER"));
        }
        userService.saveUser(user);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication auth = new UsernamePasswordAuthenticationToken(
                username,
                password,
                List.of(new SimpleGrantedAuthority(role.getName()))
        );
        securityContext.setAuthentication(auth);
        return "redirect:/categories";
    }

}
