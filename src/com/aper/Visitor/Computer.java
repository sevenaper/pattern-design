package com.aper.Visitor;

/**
 * 适用于访问固定构成
 */
abstract class ComputerPart {
    abstract void accept(Visitor v);

    abstract double getPrice();
}

class CPU extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitCPU(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart {

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

interface Visitor {
    void visitCPU(CPU cpu);

    void visitMemory(Memory memory);

    void visitBoard(Board board);
}

class PersonalVisitor implements Visitor {
    double totalPrice = 0;

    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.88;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() * 0.92;
    }
}

public class Computer {
    private ComputerPart CPU = new CPU();
    private ComputerPart memory = new Memory();
    private ComputerPart board = new Board();

    public void accept(Visitor v) {
        CPU.accept(v);
        memory.accept(v);
        board.accept(v);
    }

    public static void main(String[] args) {
        PersonalVisitor p = new PersonalVisitor();
        new Computer().accept(p);
        System.out.println(p.totalPrice);
    }
}
