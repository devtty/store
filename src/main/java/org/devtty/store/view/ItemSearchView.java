package org.devtty.store.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.devtty.store.entity.Client;
import org.devtty.store.entity.Item;
import org.devtty.store.entity.ItemStatus;
import org.devtty.store.entity.Store;
import org.devtty.store.service.ClientRepository;
import org.devtty.store.service.ItemRepository;
import org.devtty.store.service.StoreRepository;

/**
 *
 * @author Denis Renning <denis@devtty.de>
 */
@Named
@ViewAccessScoped
public class ItemSearchView extends AbstractPersistableSearchView<Item>{
    
    @Inject ItemRepository itemRepository;
    @Inject ClientRepository clientRepository;
    @Inject StoreRepository storeRepository;
    
    private String clientRef;
    private String name;
    private String vehicleNo;
    private String startlocation;
    private String sender;
    private String inMProblem;
    
    private NBoolean ex;
    private NBoolean adr;
    private NBoolean mOk;
    
    
    private Integer startKolli;
    private Integer endKolli;
    private Integer startPaletten;
    private Integer endPaletten;
    
    
    private Date startIndate;
    private Date endIndate;
    
    private List<Client> selectableClients;
    private List<Store> selectableStores;

    private Client[] selectedClients;
    private Store[] selectedStores;

    private ItemStatus status;
    
    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public StoreRepository getStoreRepository() {
        return storeRepository;
    }

    public void setStoreRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getStartlocation() {
        return startlocation;
    }

    public void setStartlocation(String startlocation) {
        this.startlocation = startlocation;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getInMProblem() {
        return inMProblem;
    }

    public void setInMProblem(String inMProblem) {
        this.inMProblem = inMProblem;
    }

    public NBoolean getEx() {
        return ex;
    }

    public void setEx(NBoolean ex) {
        this.ex = ex;
    }

    public NBoolean getAdr() {
        return adr;
    }

    public void setAdr(NBoolean adr) {
        this.adr = adr;
    }

    public NBoolean getmOk() {
        return mOk;
    }

    public void setmOk(NBoolean mOk) {
        this.mOk = mOk;
    }

    public Integer getStartKolli() {
        return startKolli;
    }

    public void setStartKolli(Integer startKolli) {
        this.startKolli = startKolli;
    }

    public Integer getEndKolli() {
        return endKolli;
    }

    public void setEndKolli(Integer endKolli) {
        this.endKolli = endKolli;
    }

    public Integer getStartPaletten() {
        return startPaletten;
    }

    public void setStartPaletten(Integer startPaletten) {
        this.startPaletten = startPaletten;
    }

    public Integer getEndPaletten() {
        return endPaletten;
    }

    public void setEndPaletten(Integer endPaletten) {
        this.endPaletten = endPaletten;
    }

    public Date getStartIndate() {
        return startIndate;
    }

    public void setStartIndate(Date startIndate) {
        this.startIndate = startIndate;
    }

    public Date getEndIndate() {
        return endIndate;
    }

    public void setEndIndate(Date endIndate) {
        this.endIndate = endIndate;
    }

    public List<Client> getSelectableClients() {
        return selectableClients;
    }

    public void setSelectableClients(List<Client> selectableClients) {
        this.selectableClients = selectableClients;
    }

    public List<Store> getSelectableStores() {
        return selectableStores;
    }

    public void setSelectableStores(List<Store> selectableStores) {
        this.selectableStores = selectableStores;
    }

    public Client[] getSelectedClients() {
        return selectedClients;
    }

    public void setSelectedClients(Client[] selectedClients) {
        this.selectedClients = selectedClients;
    }

    public Store[] getSelectedStores() {
        return selectedStores;
    }

    public void setSelectedStores(Store[] selectedStores) {
        this.selectedStores = selectedStores;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
    
    @PostConstruct
    public void init(){
        selectableClients = clientRepository.findAllOrderByNameAsc();
        selectableStores = storeRepository.findAllOrderByNameAsc();
        adr = NBoolean.NULL;
        count();
    }
    
    @Override
    protected Predicate[] getPredicates(CriteriaBuilder b, Root<Item> item){
        List<Predicate> prdcts = new ArrayList<>();
        
        //TODO
        
        return prdcts.toArray(new Predicate[prdcts.size()]);
    }

    @Override
    protected Class<? extends ViewConfig> getIndexPage() {
        return Pages.Items.Index.class;
    }

    @Override
    protected Class<? extends AbstractPersistableIndexView> getIndexView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
