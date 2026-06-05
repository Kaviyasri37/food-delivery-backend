package com.example.foodapp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String customerName;

        @Column(length = 1000)
        private String foodName;

        private double totalAmount;
        private String status = "Order Placed";

        public Long getId() {
            return id;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getFoodName() {
            return foodName;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public String getStatus() {
            return status;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public void setStatus(String status) {
            this.status = status;
        }
}
