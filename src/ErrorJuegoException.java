public class ErrorJuegoException extends Exception{
    public ErrorJuegoException() {
    }

    public ErrorJuegoException(String message) {
        super(message);
    }

    public ErrorJuegoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorJuegoException(Throwable cause) {
        super(cause);
    }

    public ErrorJuegoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
