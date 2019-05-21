package sample;

// 自前のerrorクラスを実装
public class DAOException extends Exception {
    public DAOException(String message) {
        super(message);
    }
}
