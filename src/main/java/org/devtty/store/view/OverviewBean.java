package org.devtty.store.view;

import java.security.Principal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 *
 * @author DenisRenning
 */
@Named
@RequestScoped
public class OverviewBean {
    
    @Resource Principal principal;
    
    @Inject TaskService taskService;
    
    private List<Task> tasks;
    
    
    @PostConstruct
    public void init(){
        
        tasks = taskService.createTaskQuery().taskInvolvedUser(principal.getName()).orderByDueDate().asc().list();
        
    }

    public List<Task> getTasks() {
        return tasks;
    }
    
    
    
    
}
