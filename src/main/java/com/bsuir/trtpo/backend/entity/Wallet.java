package com.bsuir.trtpo.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private Long number;

    @Column(name = "balance")
    private double balance;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return id == wallet.id &&
                Double.compare(wallet.balance, balance) == 0 &&
                Objects.equals(number, wallet.number) &&
                Objects.equals(user, wallet.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, balance, user);
    }
}
