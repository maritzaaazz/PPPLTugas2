package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String name;
    private List<Card> cards = new ArrayList<>();

    private Double cash;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Wallet(String name, List<Card> cards, Double cash) {
        this.name = name;
        this.cards = cards;
        this.cash = cash;
    }

    public Wallet(String name, Double cash) {
        this.name = name;
        this.cash = cash;
    }



    public Double withdraw(Double amount){
        if (amount < 0) {
            System.out.println("Masukkan ulang jumlah penarikan");
            return 0.0;
        }
        if (this.cash < amount) {
            System.out.println("Uang kurang");
            return cash;
        }
        else{
            this.cash -= amount;
            System.out.println("Sisa saldo Anda sebesar: Rp." + cash);
            return amount;
        }
    }


    public Double deposit(Double amount){
        if (amount < 0) {
            System.out.println("Masukkan ulang jumlah penarikan");
            return 0.0;
        }
        if (this.cash < amount) {
            System.out.println("Uang kurang");
            return cash;
        }
        else{
            this.cash += amount;
            System.out.println("Sisa saldo Anda sebesar: Rp." + cash);
            return amount;
        }
    }

    public void addCard(String bank, int accountNumber){
        Card card = new Card();
        card.setNamaPemilik(this.name);
        card.setNamaBank(bank);
        card.setNoRek(String.valueOf(accountNumber));
        this.cards.add(card);
//        // Mendapatkan kartu terakhir dari daftar kartu
//        Card lastCard = getCards().get(getCards().size() - 1);
//
//        // Menampilkan informasi jumlah kartu terakhir
//        System.out.println("Jumlah kartu terakhir Anda: " + getCards().size());
//        System.out.println("Informasi Kartu Terakhir: " +
//                "\nBank: " + lastCard.getNamaBank() +
//                "\nNomor Rekening: " + lastCard.getNoRek());
    }


    public void removeCard(int accountNumber){
        this.cards.removeIf(
                card -> card.getNoRek().equals(String.valueOf(accountNumber))
        );
//        System.out.println("Jumlah kartu anda " + cards.size());
    }
}
