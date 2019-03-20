package com.example.carservice.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue
   private long id;

   private String nazwa;

   @Column(name = "model_samochodu")
   private String modelSamochodu;
   public Car(){ }

   public Car(long id, String nazwa, String modelSamochodu){
       this.id = id;
       this.nazwa = nazwa;
       this.modelSamochodu = modelSamochodu;
   }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getModelSamochodu() {
        return modelSamochodu;
    }

    public void setModelSamochodu(String modelSamochodu) {
        this.modelSamochodu = modelSamochodu;
    }


}
