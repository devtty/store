package org.devtty.store.security;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import javax.enterprise.inject.Stereotype;
import org.apache.deltaspike.security.api.authorization.Secured;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Retention(value = RUNTIME)
@Target({TYPE, METHOD, FIELD})
@Stereotype
@Secured(RoleAccessDecisionVoter.class)
public @interface Customer {
    
}
