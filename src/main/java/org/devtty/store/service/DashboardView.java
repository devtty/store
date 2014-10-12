package org.devtty.store.service;

import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Named
public class DashboardView {

    @Inject TaskService taskService;
    
    public List<Task> getTaskList(){
        return taskService.createTaskQuery().list();
    }
    
}
