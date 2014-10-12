package org.devtty.store.service;

import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.activiti.engine.TaskService;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class TaskList {

    @Inject
    private TaskService taskService;
    
    @Produces
    @Named("taskList")
    public List getTaskList(){
        return taskService.createTaskQuery().list();
    }
    
}
