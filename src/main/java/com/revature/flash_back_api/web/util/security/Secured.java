package com.revature.flash_back_api.web.util.security;

import java.lang.annotation.*;

@Documented // Makes this visible to the document, not required but good to have.
@Target(ElementType.METHOD) // Specifies the element you want to put the annotation on. In this case, a Method.
@Retention(RetentionPolicy.RUNTIME)  // Specify when the Annotation is supposed to fire off. We want this on runtime.
public @interface Secured {
    String[] allowedRoles();
}
