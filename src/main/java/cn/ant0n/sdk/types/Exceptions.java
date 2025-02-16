package cn.ant0n.sdk.types;

public class Exceptions {

    public static IllegalArgumentException illegalArgument(String format, Object... args) {
        return new IllegalArgumentException(String.format(format, args));
    }

    public static IllegalArgumentException illegalArgument(String msg){
        return new IllegalArgumentException(msg);
    }

    public static RuntimeException modelRequestException(String msg) {
        return new RuntimeException(msg);
    }

}
