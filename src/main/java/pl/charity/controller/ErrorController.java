package pl.charity.controller;

import javassist.NotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.util.NestedServletException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ErrorController {



    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, SQLIntegrityConstraintViolationException.class, ConstraintViolationException.class,
            PersistenceException.class, JpaSystemException.class, NestedServletException.class, NoResultException.class, NoHandlerFoundException.class})

    public String handleException(HttpServletRequest request, Exception e) {

        return "error";

    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//
//    public String handleError404(HttpServletRequest request, Exception e) {
//
//        return "redirect:/error";
//    }

//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ModelAndView handle(Exception ex) {
//
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("message", ex.getMessage());
//        mv.setViewName("error");
//
//        return mv;
//    }



}
