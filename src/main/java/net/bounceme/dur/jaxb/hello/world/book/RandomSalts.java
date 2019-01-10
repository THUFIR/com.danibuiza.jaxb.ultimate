package net.bounceme.dur.jaxb.hello.world.book;

public enum RandomSalts {
    LOWER("abcdefghijklmnopqrstuvwxyz"),
    DATE(""),
    NUMERIC("0123456789");

    private String string = null;

    RandomSalts(String string) {
        this.string = string;
    }

    public String getSalt() {
        return string;
    }
}
