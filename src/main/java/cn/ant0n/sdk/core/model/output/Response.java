package cn.ant0n.sdk.core.model.output;

public class Response <T>{

    private T content;

    public Response(T content){
        this.content = content;
    }

    public T content(){
        return content;
    }

    public static <T> Response<T> from(T content){
        return new Response<>(content);
    }
}
