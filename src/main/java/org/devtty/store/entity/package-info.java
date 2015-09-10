/**
 * This package contains the persistable data model classes.
 * 
 * <p>
 * <img src="classdiagram.png" />
 * 
 * 
 */
/*
 * @startuml org/devtty/store/entity/classdiagram.png

   class Client #dddddd{
     Long id
     String address
     String name
   }

   class Collection #dddddd{
    Long id
    ..fields..
    Date datum
    Date outIncome
    Integer weight
    Integer umlBool
    String infos
    String outNr
    String outVehicleId
    String outDestination
    String umlNote
    CollectionStatus status
   }

   enum CollectionStatus #dddddd {
     ARCHIVE
     DELETED
     OK
     RECIEVED
     SHIP
     STORNED
     STORNO
   }

   class Consolidation #dddddd {
    Long id
    ..fields..
    Double bruttoWeight
    Double priceFreight
    Double priceExa
    Double priceT1
    Double priceInsurance
    Double priceRoadCharge
    Double priceOther
    Double priceVAT
    Double priceInsuranceAmount
    Integer createT1
    Integer createExa
    Integer confirmation
    Integer insurance
    String vaddress
    String laddress
    String fixTerm
    String adr
    String type
    String name
    String annotation
    String contact
    String ass
    String reference
    String registerNo
    String sender
    String additional
    String item
    String ordernr
    String fixDate
  
    Date execDate
    Date contractDate
    ..relations..
    Client client
    Contractor contractor
    User createdBy
    Contract contract
    ConsolidationStatus status
   }

   enum ConsolidationStatus #dddddd {
     CONNECT
     EDIT
     INVOICE
     ORDER
     STORNO
   }

  class Contract #dddddd {
   Long id
   ..fields..
   Double bruttoweight
   Double insuranceamount
   Date contractdate
   Date execdate
   Integer createexa
   Integer createt1
   Integer insurance
   String adr
   String addditional
   String ass
   String contact
   String fixdate
   String fixterm
   String laddress
   String sender
   String vaddress
   String name
   String annotation
   String type
   ..relations..
   User createdBy
   Client client
   Set<Contractor> contractors
   Consolidation consolidation   
  }

  class ContractStatus #dddddd {
    EDIT
    FINISHED
    REQUEST
    RUNNING
  }
 
  class Contractor #dddddd {
    Long id
    ..fields..
    String name
    String address
    String contact
    String phone
    String fax
    String email
    ..relations..
    Contract contract
  }

  class File #dddddd {
    Long id
    ..fields..
    String name
    String nameOnDisk
    String folder
    Date created
    byte[] content
    ..relations..
    User createdBy
    Item item
    Collection collection
    Contract contract
    Consolidation consolidation
  }

  class Item #dddddd {
    Long id
    ..fields..
    String clientRef
    String consolidation
    String name
    String startcorp
    String startlocation
    Date lchghDate
    Date startdate
    Date indate
    BigDecimal kolli
    BigDecimal paletten
    BigDecimal lagerUnit
    BigDecimal key
    BigDecimal lid
    BigDecimal splitId
    ..relations..
    ItemStatus status
  }

  enum ItemStatus #dddddd {
    ARCHIVE
    CALLBACK
    DELETED
    LEAVING
    OK
    RECEIVED
    REQUEST
    SHIP
    STORNO
  }

   class Store #dddddd {
    Long id
    String address
    String name
   }

   class User #dddddd{
     Long id
     ..fields..
     boolean accounting
     String email
     String login
     String name
     String pass
     String role
     ..relations..
     Client client
     Store store
   }

   Collection --> CollectionStatus

   Consolidation --> ConsolidationStatus
   Consolidation *-- Client
   Consolidation *-- Contractor
   Consolidation *-- User
   Consolidation *-- Contract

   Contract *-- User
   Contract *-- Client
   Contract *-- Contractor
   Contract -- Consolidation
   Contract --> ContractStatus 

   File *-- User
   File *-- Item
   File *-- Contract
   File *-- Collection
   File *-- Consolidation

   Item --> ItemStatus

   User *-- Client
   User *-- Store

 
 * @enduml
 */
package org.devtty.store.entity;
