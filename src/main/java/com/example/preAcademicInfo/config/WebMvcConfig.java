package com.example.preAcademicInfo.config;

import com.example.preAcademicInfo.controller.interceptor.Interceptor;
import com.example.preAcademicInfo.constants.Profile;
import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.repository.UserRepository;
import com.example.preAcademicInfo.utils.ContextProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/views/");
        bean.setSuffix(".jsp");

        return bean;
    }
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    @Bean
    public Interceptor interceptor(){
        return new Interceptor();
    }

    @Bean
    public CommandLineRunner demoData(UserRepository repo) {

        PasswordEncoder encoder = ContextProvider.getBean(PasswordEncoder.class);
        User u = repo.findByUsername("admin");
        if (u == null) {
            return args -> {
                repo.save(new User("admin", encoder.encode("admin"), "mail@mail.com", Profile.ADMIN.getName()));
            };
        }
        return args -> {};
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new Interceptor()).addPathPatterns("/**").excludePathPatterns("/login");
        registry.addInterceptor(new Interceptor());
    }

}
