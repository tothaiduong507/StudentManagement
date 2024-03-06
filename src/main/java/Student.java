//Mỗi đối tượng sinh viên có các thuộc tính sau: id, tên, giới tính, tuổi, điểm toán, điểm lý, điểm hóa, điểm trung bình và học lực.
//        Id là mã sinh viên tự động tăng.
//        Khi khởi tạo, chương trình sẽ đọc file "student.txt" để lấy ra danh sách sinh viên đã được lưu trước đó.
//        Điểm trung bình là giá trị trung bình của 3 môn toán, lý và hóa.
//        Học lực được tính như sau:
//        Giỏi: nếu điểm trung bình lớn hơn hoặc bằng 8.
//        Khá: nếu điểm trung bình nhỏ hơn 8 và lớn hơn hoặc bằng 6.5.
//        Trung Bình: nếu điểm trung bình nhỏ hơn 6.5 và lớn hơn hoặc bằng 5.
//        Yếu: nếu điểm trung bình nhỏ hơn 5.


class Student {
    private static int nextId = 1;
    private final int id;
    private String name;
    private String gender;
    private int age;
    private double mathScore;
    private double physicsScore;
    private double chemistryScore;
    private double averageScore;
    private Rank rank;

    public Student(String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore){
        this.id = nextId++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;
        this.averageScore = (mathScore + physicsScore + chemistryScore)/3;
        this.rank = getRank(this.averageScore);
    }

    public Student(int id, String name, String gender, int age, double mathScore, double physicsScore, double chemistryScore){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;
        this.averageScore = (mathScore + physicsScore + chemistryScore)/3;
        this.rank = getRank(this.averageScore);
    }

    public Rank getRank(double averageScore){
        if(averageScore < 5 && averageScore >= 0) return Rank.Yeu;
        else if(averageScore <= 6.5) return Rank.TrungBinh;
        else if(averageScore <= 8) return Rank.Kha;
        else return Rank.Gioi;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public void setPhysicsScore(double physicsScore) {
        this.physicsScore = physicsScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getMathScore() {
        return mathScore;
    }

    public double getPhysicsScore() {
        return physicsScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public Rank getRank() {
        return rank;
    }
}


