import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        String dsIdentifier = "2023-12-04T11:36:00.13275942";
//        int ondex = dsIdentifier.lastIndexOf(".");
//        System.out.println("Encoded string " + dsIdentifier.substring(0, ondex));
//
//        LocalDateTime returnValue = LocalDateTime.parse(dsIdentifier, DateTimeFormatter.ISO_DATE_TIME);
//        System.out.println(returnValue.toLocalDate());

//        String encodedDsIdentifier = String.valueOf(Base64.getEncoder().encode(dsIdentifier));
//        System.out.println("encoded ds identifier" + encodedDsIdentifier);


        System.out.println("Start time "+LocalDateTime.now());
        LocalDateTime start = LocalDateTime.now();
        IntStream.range(0, 20000).forEach( item -> {
            String strWithTabAndSpace = "     \t \n                                 ";
            System.out.println(item + "strWithTabAndSpace          [" + strWithTabAndSpace + "]");
            System.out.println(item + "strWithTabAndSpace.trim()   [" + strWithTabAndSpace.trim() + "]");
        });
        System.out.println(" start time "+ start);
        System.out.println(" End time "+ LocalDateTime.now());

    }
}