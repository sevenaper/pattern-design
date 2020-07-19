package com.aper.Command;

public class InsertCommand extends Command {
    Content c;
    String strToInsert = "design pattern";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void exec() {
        c.msg = c.msg + strToInsert;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() - strToInsert.length());
    }
}
