package CryptBasic;

public class CryptoException extends Exception
{
    public CryptoException() {
    }
    
    public CryptoException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
