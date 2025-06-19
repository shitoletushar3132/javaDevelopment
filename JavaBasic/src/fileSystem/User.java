package fileSystem;

class User {
    int id;
    String name;
    int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // toCSV
    public String toCSV() {
        return id + "," + name + "," + age;
    }
}

