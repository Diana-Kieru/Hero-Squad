package tech.diana.domain;

public class Squad {
    private int maxSize;
    private String name;
    private String cause;

    private int id;

    public Squad(int id, int maxSize, String name, String cause){
        this.maxSize = maxSize;
        this.name = name;
        this.cause = cause;
        this.id = id;
//        instance.add(this);
//        this.id = instance.size();

//

    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getName() {
        return name;
    }

    public String getCause() {
        return cause;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "maxSize=" + maxSize +
                ", name='" + name + '\'' +
                ", cause='" + cause + '\'' +
                ", id=" + id +
                '}';
    }
}
