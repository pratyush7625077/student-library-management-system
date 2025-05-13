package com.demo.example.student_.library_.management_.system.model;


import com.demo.example.student_.library_.management_.system.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")

public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transactionDate", nullable = false)
    @CreationTimestamp
    private Date transactionDate;

    @Column(name = "due_date", nullable = false)
    private String dueDate;

    @Column(name = "fine", nullable = false)
    private int fine;

    @Column(name = "transaction_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;

    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Card card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
        public void setTransactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
        }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
