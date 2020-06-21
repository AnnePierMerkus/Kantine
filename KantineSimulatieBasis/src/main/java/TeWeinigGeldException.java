package main.java;

public class TeWeinigGeldException extends Exception{

    public TeWeinigGeldException()
    {
        this("Er is te weinig geld om te betalen.");
    }

    public TeWeinigGeldException(Exception e)
    {
        this(e.getMessage());
    }

    public TeWeinigGeldException(String message)
    {
        System.out.println(message);
    }
}
