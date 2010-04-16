package uk.co.arunhorne.jhat;

public final class Cacheable {

    private final int primaryKey;

    public Cacheable(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cacheable cacheable = (Cacheable) o;

        return  primaryKey == cacheable.primaryKey;
    }

    @Override
    public int hashCode() {
        return primaryKey;
    }

    @Override
    public String toString() {
        return "Cacheable@" + super.hashCode();
    }
}
