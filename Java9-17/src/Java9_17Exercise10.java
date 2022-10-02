// Q 10. Demonstrate the use of repeat, strip, isBlank, indent, transform,
//         stripIndent, translateEscapes, formatted String methods.

public class Java9_17Exercise10 {
    public static void main(String[] args) {
        String string= "This is a BootCamp Assignment ";
        System.out.println(string.repeat(2));
        String stringWithSpaces="       This is a BootCamp Assignment     ";
        System.out.println(stringWithSpaces.strip());
        String blankString="     ";
        System.out.println(blankString.isBlank());
//        System.out.println(blanckString.isEmpty());
        System.out.println(string.indent(10));
        String resultString = string.transform(newString-> new StringBuilder(string).reverse().toString());
        System.out.println(resultString);
        String multiLineString=
                "\tStringLine 1\n"
                +"\t\tStringLine 2\n"
                +"\t\t\tStringLine 3\n"
                +"\t\tStringLine 4\n"
                +"\tStringLine 5";
        System.out.println(multiLineString);
        System.out.println(multiLineString.stripIndent());
        String stringWithEscapes="\"This is a \\nString with Escapes\"";
        System.out.println(stringWithEscapes);
        System.out.println(stringWithEscapes.translateEscapes());
        System.out.println(String.format("Abhishek %s","Garg"));
        System.out.println("Abhishek %s".formatted("Garg"));
    }
}
//-------------------------------------OUTPUT---------------------------
//        This is a BootCamp Assignment This is a BootCamp Assignment
//        This is a BootCamp Assignment
//        true
//                  This is a BootCamp Assignment
//
//        tnemngissA pmaCtooB a si sihT
//           StringLine 1
//               StringLine 2
//                   StringLine 3
//               StringLine 4
//           StringLine 5
//       StringLine 1
//           StringLine 2
//               StringLine 3
//           StringLine 4
//       StringLine 5
//        "This is a \nString with Escapes"
//        "This is a
//        String with Escapes"
//        Abhishek Garg
//        Abhishek Garg