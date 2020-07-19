package com.aper.Command;

public class CopyCommand extends Command {
    Content c;

    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void exec() {
        c.msg = c.msg + c.msg;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() / 2);
    }
}
