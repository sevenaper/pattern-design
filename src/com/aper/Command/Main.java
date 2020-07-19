package com.aper.Command;

public class Main {
    public static void main(String[] args) {
        Content c = new Content();
        Command insertCommand = new InsertCommand(c);
        Command copyCommand = new CopyCommand(c);
        insertCommand.exec();
        insertCommand.undo();
        copyCommand.exec();
        copyCommand.undo();
        System.out.println(c.msg);
    }
}
