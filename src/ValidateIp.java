public class ValidateIp {
    public static void main(String[] args) {
        validIp();
    }

    public static void validIp(){
        String ip = "0.0.0.0";

        String [] octects = ip.split("\\.");

        if (octects.length < 4){
            System.out.println("not a valid ip");
            return;
        }

        for (String octet : octects){
            Integer value = Integer.valueOf(octet);
            if (value < 0 || value > 255){
                System.out.println("Not a valid ip");
                return;
            }
        }
        System.out.println("Valid IP");
    }
}
