package net.maks.model;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

   public int getId() {
      return id;
   }

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY) //(strategy = GenerationType.IDENTITY)
   private int id;

   @NotEmpty(message = "Name should not be empty")
   @Column(name = "name")
   private String name;

   @NotEmpty(message = "Name should not be empty")
   @Column(name = "size")
   private String size;

   @NotEmpty(message = "Name should not be empty")
   @Column(name = "rentalprice")
   private String rentalPrice;

   @Override
   public String toString() {
      return "Room{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", size='" + size + '\'' +
              ", rentalPrice='" + rentalPrice + '\'' +
              '}';
   }

   public Room() {
   }


   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getRentalPrice() {
      return rentalPrice;
   }

   public void setRentalPrice(String rentalPrice) {
      this.rentalPrice = rentalPrice;
   }

   public String getSize() {
      return size;
   }

   public void setSize(String size) {
      this.size = size;
   }
}
