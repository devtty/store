package org.devtty.store.view;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.config.view.navigation.ViewNavigationHandler;
import org.devtty.store.service.HolidayRepository;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Named
@ViewScoped
public class CalendarView implements Serializable{
    
    @Inject ViewNavigationHandler viewNavigationHandler;
    
    @Inject HolidayRepository holidayRepository;
    
    @Inject Logger logger;
    
    private ScheduleModel model;
    
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    public void calendar(){
        viewNavigationHandler.navigateTo(Pages.Calendar.class);
    }

    public void addEvent(ActionEvent actionEvent){
        logger.info("addEvent");
        if(event.getId()==null){
            logger.info("add " + event.getTitle());
            model.addEvent(event);
        }else{
            logger.info("update " + event.getTitle());
            model.updateEvent(event);
        }
        
        event = new DefaultScheduleEvent();
    }
    
    public void onEventSelect(SelectEvent selectEvent) {
        logger.info("event select");
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        logger.info("date select: " + selectEvent.getObject().toString());
        //event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
    
    public ScheduleModel getModel() {
        return model;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
    
    @PostConstruct
    public void init(){
        model = new DefaultScheduleModel();
    }
    
 
}
